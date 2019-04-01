package cn.com.syscom.ibmmq;

import org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary;

import com.ibm.mq.*;
import com.ibm.mq.constants.MQConstants;

public class IbmMqTest {

    static MQQueueManager qMgr;
    private static MQQueue sendQueue;
    private static MQQueue receiveQueue;
    private static int CCSID = 1381;
    private static String hostname = "192.168.10.137";
    static int port = 1416;
    static String queueManagerName = "QM2";
    static String queueName = "Q1";
    static String channel = "TestChannel";
    static String userId = "Administrator";
    static String password = "Win@2012";
 
    public static void connect() throws MQException {
 
        MQEnvironment.hostname = hostname;
        MQEnvironment.port = port;
        MQEnvironment.channel = channel;
        MQEnvironment.CCSID = CCSID;
        MQEnvironment.userID = userId;     //MQ中拥有权限的用户名
        MQEnvironment.password = password; //用户名对应的密码
        qMgr = new MQQueueManager(queueManagerName);//创建队列管理器
    }
    
    public static void main(String[] args) {
    	try {
			connect();
				sendMsg("message1");
			//receiveMsg();
		} catch (MQException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            try {
				qMgr.disconnect();
			} catch (MQException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
    
    public static void sendMsg(String message)
    {

        int openOptions = MQConstants.MQOO_INPUT_AS_Q_DEF | MQConstants.MQOO_OUTPUT | MQConstants.MQOO_INQUIRE;
        try {
            // 建立通道的连接
            sendQueue = qMgr.accessQueue(queueName, openOptions, null, null, null);
 
            MQMessage msg = new MQMessage();// 要写入队列的消息
            msg.format = MQConstants.MQFMT_STRING;
            msg.characterSet = CCSID;
            msg.encoding = CCSID;
            msg.writeUTF(message);
 
            MQPutMessageOptions pmo = new MQPutMessageOptions();
            msg.expiry = -1; // 设置消息用不过期
 
            sendQueue.put(msg, pmo);// 将消息放入队列
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sendQueue != null) {
                try {
                    sendQueue.close();
                } catch (MQException e) {
                    e.printStackTrace();
                }
            }
        }
    	
    }
    

    
    public static void receiveMsg() {
        int openOptions = MQConstants.MQOO_INPUT_AS_Q_DEF | MQConstants.MQOO_OUTPUT | MQConstants.MQOO_INQUIRE;
        try {
            receiveQueue = qMgr.accessQueue(queueName, openOptions, null, null, null);
            int depth = receiveQueue.getCurrentDepth();
            System.out.println("该队列当前的深度为:" + depth);
 
            // 将队列的里的消息读出来
            while (depth-- > 0) {
                MQMessage rcvMessage = new MQMessage();// 要读的队列的消息
                MQGetMessageOptions gmo = new MQGetMessageOptions();
                receiveQueue.get(rcvMessage, gmo);
                String msgText = rcvMessage.readUTF();
                System.out.println("消息的内容:" + msgText);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (receiveQueue != null) {
                try {
                    receiveQueue.close();
                } catch (MQException e) {
                    e.printStackTrace();
                }
            }
            try {
                qMgr.disconnect();
            } catch (MQException e) {
                e.printStackTrace();
            }
        }
    } 
}
