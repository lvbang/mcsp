package cn.com.syscom.mysql.model;

import java.io.Serializable;
import java.util.Date;

public class Vtlf implements Serializable {
	private static final long serialVersionUID = 1L;	
	//交易时间
    private Date trantime;

    //交易笔数
    private Integer trancnt;
    
    //成功笔数
    private Integer aprvcnt;

    //成功率
    private Float aprvperc;

    //拒绝笔数
    private Integer denycnt;
    
    //响应时间
    private Float resptime;

    private Float ichgtime;

    private Float swchtime;

    public Date getTrantime() {
        return trantime;
    }

    public void setTrantime(Date trantime) {
        this.trantime = trantime;
    }

    public Integer getTrancnt() {
        return trancnt;
    }

    public void setTrancnt(Integer trancnt) {
        this.trancnt = trancnt;
    }

    public Integer getAprvcnt() {
        return aprvcnt;
    }

    public void setAprvcnt(Integer aprvcnt) {
        this.aprvcnt = aprvcnt;
    }

    public Float getAprvperc() {
        return aprvperc;
    }

    public void setAprvperc(Float aprvperc) {
        this.aprvperc = aprvperc;
    }

    public Integer getDenycnt() {
        return denycnt;
    }

    public void setDenycnt(Integer denycnt) {
        this.denycnt = denycnt;
    }

    public Float getResptime() {
    	if (resptime != null) {
            return resptime;
		} else {
			return (float) 0.0;
		}
    }

    public void setResptime(Float resptime) {
        this.resptime = resptime;
    }

    public Float getIchgtime() {
    	if (ichgtime != null) {
            return ichgtime;
		} else {
			return (float) 0.0;
		}
    }

    public void setIchgtime(Float ichgtime) {
        this.ichgtime = ichgtime;
    }

    public Float getSwchtime() {
    	if (swchtime != null) {
            return swchtime;
		} else {
			return (float) 0.0;
		}
        
    }

    public void setSwchtime(Float swchtime) {
        this.swchtime = swchtime;
    }

	@Override
	public String toString() {
		return "[交易时间(trantime)=" + trantime + ", 交易笔数trancnt=" + trancnt + ", 成功笔数aprvcnt=" + aprvcnt + ", 成功率aprvperc=" + aprvperc
				+ ", 失败笔数denycnt=" + denycnt + ", 响应时间resptime=" + resptime + ", ESB时间ichgtime=" + ichgtime + ", swchtime="
				+ swchtime + "]";
	}
}