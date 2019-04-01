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
        MQEnvironment.userID = userId;     //MQ��ӵ��Ȩ�޵��û���
        MQEnvironment.password = password; //�û�����Ӧ������
        qMgr = new MQQueueManager(queueManagerName);//�������й�����
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
            // ����ͨ��������
            sendQueue = qMgr.accessQueue(queueName, openOptions, null, null, null);
 
            MQMessage msg = new MQMessage();// Ҫд����е���Ϣ
            msg.format = MQConstants.MQFMT_STRING;
            msg.characterSet = CCSID;
            msg.encoding = CCSID;
            msg.writeUTF(message);
 
            MQPutMessageOptions pmo = new MQPutMessageOptions();
            msg.expiry = -1; // ������Ϣ�ò�����
 
            sendQueue.put(msg, pmo);// ����Ϣ�������
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
            System.out.println("�ö��е�ǰ�����Ϊ:" + depth);
 
            // �����е������Ϣ������
            while (depth-- > 0) {
                MQMessage rcvMessage = new MQMessage();// Ҫ���Ķ��е���Ϣ
                MQGetMessageOptions gmo = new MQGetMessageOptions();
                receiveQueue.get(rcvMessage, gmo);
                String msgText = rcvMessage.readUTF();
                System.out.println("��Ϣ������:" + msgText);
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
