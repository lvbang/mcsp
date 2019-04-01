package cn.com.syscom.inter.esbinterface;

import javax.annotation.Resource;

import cn.com.syscom.iso8583.CustomField63;
import cn.com.syscom.iso8583.IsoMessage;
import cn.com.syscom.iso8583.MessageFactory;

public class MessageFactoryCup extends MessageFactory<IsoMessage> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Resource 
    private CustomField63 customField63Cup;
    
	public  MessageFactoryCup() {
		this.setCharacterEncoding("GBK");
		this.setUseBinaryBitmap(true);
		this.setUseBinaryMessages(false);
		// TODO Auto-generated constructor stub

		//this.setCustomField(63,customField63Cup);

	}
}
