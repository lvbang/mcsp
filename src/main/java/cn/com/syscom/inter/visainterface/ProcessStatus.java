package cn.com.syscom.inter.visainterface;

public class ProcessStatus {
	//��ʼ������ǩ����ǩ��״̬
	public static boolean boolProcessStatus  = false;
	//��ʼ������ǩ����ǩ��״̬
	public static boolean boolAdviceSignStatus  = false;
	//����ʱ�Ƿ��Զ�����ǩ������
	public static boolean boolAutoSignOn  = true;
	
	public ProcessStatus() {
		// TODO Auto-generated constructor stub
	}

	public static boolean isBoolAutoSignOn() {
		return boolAutoSignOn;
	}

	public static void setBoolAutoSignOn(boolean boolAutoSignOn) {
		ProcessStatus.boolAutoSignOn = boolAutoSignOn;
	}
	
	public static void setAdviceSignStatus(boolean boolAdviceSignOn) {
		ProcessStatus.boolAdviceSignStatus = boolAdviceSignOn;
	}

}
