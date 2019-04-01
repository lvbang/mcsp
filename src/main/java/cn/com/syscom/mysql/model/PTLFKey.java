package cn.com.syscom.mysql.model;

import java.util.Date;

public class PTLFKey {
    private Date datDat;

    private Date datTim;

    private String cardNum;

    private String traceNumber;

    public Date getDatDat() {
        return datDat;
    }

    public void setDatDat(Date datDat) {
        this.datDat = datDat;
    }

    public Date getDatTim() {
        return datTim;
    }

    public void setDatTim(Date datTim) {
        this.datTim = datTim;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum == null ? null : cardNum.trim();
    }

    public String getTraceNumber() {
        return traceNumber;
    }

    public void setTraceNumber(String traceNumber) {
        this.traceNumber = traceNumber == null ? null : traceNumber.trim();
    }
}