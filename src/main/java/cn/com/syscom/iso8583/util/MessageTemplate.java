package cn.com.syscom.iso8583.util;

/**
 *   ��־��Ϣ����
 *   ��־��Ϣ�������6���ֽ��ַ�����ʾ���ַ�ȡֵ��ΧΪ"0 - 9"�� "A - Z"��
 *   ������ʽ�硰AACCCC��������
 *
 *   AA ��ʾ��ϵͳ��ţ���ȡֵΪ��
 *      00 --- TCP/IPͨѶ��ϵͳ
 *      01 --- ��Ϣ�м��
 *      02 --- �ӿ�
 *      03 --- ISO8583���Ľ��/���
 *      04 --- ���ݳ־ò�
 *
 *   B ��ʾ��־��Ϣ������ȡֵΪ��
 *      0 --- OFF (most specific, no logging)
 *      1 --- FATAL (most specific, little data)
 *      2 --- ERROR
 *      3 --- WARN
 *      4 --- INFO
 *      5 --- DEBUG
 *      6 --- TRACE (least specific, a lot of data)
 *      7 --- ALL (least specific, all data)
 *
 *   CCCC ��ʾ������־��Ϣ��ţ����ݸ���ϵͳ���嶨�塣
 *
 */
public class MessageTemplate
{
    //MsgNo:000001] (�ӿ�ͨѶ���̳�ʼ���ɹ�)
    public static final String MSG_INTR_INIT_SUC = "[000001] -  {}�ӿ�ͨѶ���̳�ʼ���ɹ���";

    //MsgNo:000002 (�ӿ�ͨѶ���̹ر�)
    public static final String MSG_INTR_CLOSE = "[000002] -  {}�ӿ�ͨѶ���̹رգ�";

    //MsgNo:000002 (�ӿڽ��̳�ʼ��ʧ��)
    public static final String MSG_INTR_INIT_FAIL = "[000002] -  {}ͨѶ���̳�ʼ��ʧ�ܣ�";

    //MsgNo:000003 (��ȡ�����ļ�ʧ��)
    public static final String MSG_READ_FILE_FAIL = "[000003] -  ��ȡ�����ļ�{}����";

    //MsgNo:000004 (��ȡ�����ļ�ʧ��)
    public static final String MSG_READ_CONFIG_FIELD = "[000004] -  �������ļ�{}�ж�ȡ��{}��ֵΪ:{}";

    //MsgNo:000005 (��ȡ�����ļ�ʧ��)
    public static final String MSG_TCP_CONNECT_RESULT = "[000005] -  {}ͨѶ�ͻ������ӷ�����{}�� IP:{}  Port:{} ";

    //MsgNo:020001
    public static final String MSG_VISA_INTER_LOG = "[020001] -  VISA�ӿڣ�";

    //MsgNo:020002
    public static final String MSG_ESB_INTER_LOG = "[020002] -  ESB�ӿڣ�";

    //MsgNo:030001]
    public static final String MSG_ISO8583_DECODER_LOG = "[030001] - 8583���Ľ����";

    //MsgNo:030002
    public static final String MSG_ISO8583_ENCODER_LOG = "[030002] -  8583���������";

    //MsgNo:040001]
    public static final String MSG_DAO_SUCESS_LOG = "[040001] - ������־д�����ݿ�ɹ���";

    //MsgNo:040002
    public static final String MSG_DAT_FAIL_LOG = "[040002] -   ������־д�����ݿ�ʧ�ܣ�";
}
