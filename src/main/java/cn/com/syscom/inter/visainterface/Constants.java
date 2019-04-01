package cn.com.syscom.inter.visainterface;


/**
 *  系统常量定义
 *
 */
public class Constants
{
    //最大输入报文长度
    public static final int MAX_INPUT_MESSAGE_LENGTH = 2048;

    //请求报文附加报文头长度
    public static final int RQST_MESSAGE_HEADER_LENGTH = 50;
    
    //报文头默认初始值
    public static final String RQST_MESSAGE_HEADER = "/0.0.0.0:0";
    
    //心跳报文长度
    public static final int HEARTBEAT_MESSAGE_LENGTH = 4;

    //报文内容写日志开关
    public static final boolean LOG_MESSAGE_OPEN = true;


}
