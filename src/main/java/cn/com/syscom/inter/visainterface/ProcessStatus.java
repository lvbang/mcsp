package cn.com.syscom.inter.visainterface;

public class ProcessStatus {
	//初始化进程签到、签退状态
	public static boolean boolProcessStatus  = false;
	//初始化进程签到、签退状态
	public static boolean boolAdviceSignStatus  = false;
	//启动时是否自动发送签到报文
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
