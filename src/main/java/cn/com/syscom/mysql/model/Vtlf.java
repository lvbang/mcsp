package cn.com.syscom.mysql.model;

import java.io.Serializable;
import java.util.Date;

public class Vtlf implements Serializable {
	private static final long serialVersionUID = 1L;	
	//����ʱ��
    private Date trantime;

    //���ױ���
    private Integer trancnt;
    
    //�ɹ�����
    private Integer aprvcnt;

    //�ɹ���
    private Float aprvperc;

    //�ܾ�����
    private Integer denycnt;
    
    //��Ӧʱ��
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
		return "[����ʱ��(trantime)=" + trantime + ", ���ױ���trancnt=" + trancnt + ", �ɹ�����aprvcnt=" + aprvcnt + ", �ɹ���aprvperc=" + aprvperc
				+ ", ʧ�ܱ���denycnt=" + denycnt + ", ��Ӧʱ��resptime=" + resptime + ", ESBʱ��ichgtime=" + ichgtime + ", swchtime="
				+ swchtime + "]";
	}
}