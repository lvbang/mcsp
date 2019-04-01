package cn.com.syscom.iso8583.util;

/**
 *   日志信息代码
 *   日志信息代码采用6个字节字符串表示，字符取值范围为"0 - 9"及 "A - Z"，
 *   其编码格式如“AACCCC”，其中
 *
 *   AA 表示子系统编号，其取值为：
 *      00 --- TCP/IP通讯子系统
 *      01 --- 消息中间件
 *      02 --- 接口
 *      03 --- ISO8583报文解包/组包
 *      04 --- 数据持久层
 *
 *   B 表示日志信息级别，其取值为：
 *      0 --- OFF (most specific, no logging)
 *      1 --- FATAL (most specific, little data)
 *      2 --- ERROR
 *      3 --- WARN
 *      4 --- INFO
 *      5 --- DEBUG
 *      6 --- TRACE (least specific, a lot of data)
 *      7 --- ALL (least specific, all data)
 *
 *   CCCC 表示具体日志信息编号，根据各子系统具体定义。
 *
 */
public class MessageTemplate
{
    //MsgNo:000001] (接口通讯进程初始化成功)
    public static final String MSG_INTR_INIT_SUC = "[000001] -  {}接口通讯进程初始化成功！";

    //MsgNo:000002 (接口通讯进程关闭)
    public static final String MSG_INTR_CLOSE = "[000002] -  {}接口通讯进程关闭！";

    //MsgNo:000002 (接口进程初始化失败)
    public static final String MSG_INTR_INIT_FAIL = "[000002] -  {}通讯进程初始化失败！";

    //MsgNo:000003 (读取配置文件失败)
    public static final String MSG_READ_FILE_FAIL = "[000003] -  读取配置文件{}出错！";

    //MsgNo:000004 (读取配置文件失败)
    public static final String MSG_READ_CONFIG_FIELD = "[000004] -  从配置文件{}中读取域{}，值为:{}";

    //MsgNo:000005 (读取配置文件失败)
    public static final String MSG_TCP_CONNECT_RESULT = "[000005] -  {}通讯客户端连接服务器{}。 IP:{}  Port:{} ";

    //MsgNo:020001
    public static final String MSG_VISA_INTER_LOG = "[020001] -  VISA接口：";

    //MsgNo:020002
    public static final String MSG_ESB_INTER_LOG = "[020002] -  ESB接口：";

    //MsgNo:030001]
    public static final String MSG_ISO8583_DECODER_LOG = "[030001] - 8583报文解包：";

    //MsgNo:030002
    public static final String MSG_ISO8583_ENCODER_LOG = "[030002] -  8583报文组包：";

    //MsgNo:040001]
    public static final String MSG_DAO_SUCESS_LOG = "[040001] - 交易日志写入数据库成功：";

    //MsgNo:040002
    public static final String MSG_DAT_FAIL_LOG = "[040002] -   交易日志写入数据库失败：";
}
