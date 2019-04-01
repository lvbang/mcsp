/*
j8583 A Java implementation of the ISO8583 protocol
Copyright (C) 2007 Enrique Zamudio Lopez

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA
*/
package cn.com.syscom.iso8583.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.syscom.iso8583.IsoMessage;
import cn.com.syscom.iso8583.IsoType;
import cn.com.syscom.iso8583.MessageFactory;
import cn.com.syscom.iso8583.baffle.IsoMessageLoggingHandler;
import cn.com.syscom.iso8583.parse.ConfigParser;

/** Example of a small server app that listens on a port, receives connections and reads
 * messages and responds back.
 * 
 * @author Enrique Zamudio
 */
public class Server implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(Server.class);

	private static ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(5);
	private static MessageFactory<IsoMessage> mfact;

	private Socket socket;

	Server(Socket sock) throws IOException {
		socket = sock;
	}

	public void run() {
		int count = 0;
		byte[] lenbuf = new byte[2];
		try {
			//For high volume apps you will be better off only reading the stream in this thread
			//and then using another thread to parse the buffers and process the requests
			//Otherwise the network buffer might fill up and you can miss a request.
			while (socket != null && socket.isConnected()
					&& Thread.currentThread().isAlive() && !Thread.currentThread().isInterrupted()) {
				if (socket.getInputStream().read(lenbuf) == 2) {
					int size = ((lenbuf[0] & 0xff) << 8) | (lenbuf[1] & 0xff);
					byte[] buf = new byte[size];
					//We're not expecting ETX in this case
					socket.getInputStream().read(buf);
					count++;
					//Set a job to parse the message and respond
					//Delay it a bit to pretend we're doing something important
					threadPool.schedule(new Processor(buf, socket), 400, TimeUnit.MILLISECONDS);
				}
			}
		} catch (IOException ex) {
			log.error("Exception occurred...", ex);
		}
		log.debug("Exiting after reading {} requests", count);
		try {
			socket.close();
		} catch (IOException ex) {}
	}

	private class Processor implements Runnable {

		private byte[] msg;
		private Socket sock;

		Processor(byte[] buf, Socket s) {
			msg = buf;
			sock = s;
		}

		public void run() {
			try {
				log.debug("Parsing incoming: '{}'", new String(msg));
				String respHeader = mfact.getIsoHeader(0x200);
				IsoMessage incoming = mfact.parseMessage(msg,
					respHeader == null ? 12 : respHeader.length());
				  if (incoming != null) {
			        	IsoMessageLoggingHandler isoMessageLoggingHandler = new IsoMessageLoggingHandler(false,true);
			        	System.out.println(isoMessageLoggingHandler.formatIsoMessage(incoming));
			        } else {
			            throw new ParseException("Can't parse ISO8583 message", 0);
			        }
				//Create a response
				IsoMessage response = mfact.createResponse(incoming);
				response.setField(11, incoming.getField(11));
				response.setField(7, incoming.getField(7));
				response.setValue(38, System.currentTimeMillis() % 1000000, IsoType.NUMERIC, 6);
				response.setValue(39, 0, IsoType.NUMERIC, 2);
				response.setValue(61, String.format("Dynamic data generated on %1$tF at %1$tT", new Date()),
					IsoType.LLLVAR, 0);
				log.debug("Sending response conf {}", response.getField(38));
				response.write(sock.getOutputStream(), 2);
			} catch (ParseException ex) {
				log.error("Parsing incoming message", ex);
			} catch (IOException ex) {
				log.error("Sending response", ex);
			}
		}

	}

	public static void main(String[] args) throws Exception {
		mfact = ConfigParser.createFromClasspathConfig("j8583_config.xml");
		log.info("Setting up server socket...");
		ServerSocket server = new ServerSocket(9999);
		log.info("Waiting for connections...");
		while (true) {
			Socket sock = server.accept();
			log.info("New connection from {}:{}", sock.getInetAddress(), sock.getPort());
			new Thread(new Server(sock), "j8583-server").start();
		}
	}

}
