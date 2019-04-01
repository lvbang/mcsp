package cn.com.syscom.iso8583.tlv;

public interface IBerTlvLogger {

    boolean isDebugEnabled();

    void debug(String aFormat, Object ...args);
}
