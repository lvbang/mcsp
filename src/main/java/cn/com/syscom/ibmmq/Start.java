/*
 * The MIT License
 *
 * Copyright 2015 Vanio Informatika Kft..
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package cn.com.syscom.ibmmq;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Start application.
 *
 * @author Pato Istvan <istvan.pato@vanio.hu>
 */
public class Start {

    public static void main(String[] args)
            throws IOException, InterruptedException {
    	 @SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("application_ibmmq.xml");

        // sending messages
        JmsQueueSender jqs = ctx.getBean(JmsQueueSender.class);
        String message = "11111111111Hello queue world!"
                + " National chars (see CCSID): \"--\"''";

        // send five message and sleep half second
/*        for (int i = 1; i <= 5; i++) {
            Thread.sleep(500);
            jqs.simpleSend(i + ". " + message);
        }*/
        System.out.println(message.getBytes());
        for (int i = 1; i <= 5; i++) {
            Thread.sleep(500);
            jqs.simpleBytesSend(message.getBytes());
        }
        // quit after 1 second
        Thread.sleep(1000);
        ctx.close();
    }

}
