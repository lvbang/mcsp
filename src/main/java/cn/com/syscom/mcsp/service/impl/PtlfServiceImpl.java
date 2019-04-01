package cn.com.syscom.mcsp.service.impl;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.syscom.iso8583.IsoMessage;
import cn.com.syscom.iso8583.util.HexUtil;
import cn.com.syscom.iso8583.util.MessageTemplate;
import cn.com.syscom.mcsp.service.PtlfService;
import cn.com.syscom.mysql.mapper.PTLFMapper;
import cn.com.syscom.mysql.model.PTLF;
import cn.com.syscom.mysql.model.PTLFExample;
import cn.com.syscom.mysql.model.PTLFKey;

@Service
public class PtlfServiceImpl implements PtlfService{
	private Logger logger = LoggerFactory.getLogger(PtlfServiceImpl.class);

	@Autowired
	private PTLFMapper ptlfMapper;
	
	@Override
	public int insert(IsoMessage isoMessageVisa, IsoMessage isoMessageCup) {
		// TODO Auto-generated method stub
		PTLF ptlf = new PTLF();
		if (isoMessageVisa.hasEveryField(2,7,11)) {
			ptlf.setDatDat(isoMessageVisa.getObjectValue(7));
			ptlf.setDatTim(isoMessageVisa.getObjectValue(7));
			ptlf.setCardNum(isoMessageVisa.getField(2).toString());
			ptlf.setTraceNumber(isoMessageVisa.getField(11).toString());
		}
		else {
			logger.error(MessageTemplate.MSG_DAT_FAIL_LOG + "主键不能为空");
			return 0;
		}
		
		ptlf.setCardType("V");
		
		if (isoMessageVisa.getBeginVisaTime() > 0) {
			ptlf.setEntryTim(new Date(isoMessageVisa.getBeginVisaTime()));
		}
		
		if (isoMessageVisa.getBeginEsbTime() > 0) {
			ptlf.setExitTim(new Date(isoMessageVisa.getBeginEsbTime()));
		}
		
		if (isoMessageVisa.getEndEsbTime() > 0) {
			ptlf.setReEntryTim(new Date(isoMessageVisa.getEndEsbTime()));
		}
		
		if (isoMessageVisa.getEndVisaTime() > 0) {
			ptlf.setTranTim(new Date(isoMessageVisa.getEndVisaTime()));
		}
		
		if (isoMessageVisa.getEndVisaTime() > 0) {
			ptlf.setTranDat(new Date(isoMessageVisa.getEndVisaTime()));
		}
		
/*		if (isoMessageVisa.isTimeOutTrans()) {
			ptlf.setRvrlCde("R");
		}*/
		
		if (isoMessageVisa.hasField(3)) {
			ptlf.setTranType(isoMessageVisa.getField(3).toString());
			ptlf.setTranCde(isoMessageVisa.getField(3).toString());
		}
		if (isoMessageVisa.hasField(4)) {
			ptlf.setTranAmount(isoMessageVisa.getObjectValue(4));
			ptlf.setTranCrncyAmt(isoMessageVisa.getField(4).toString());
		}
		if (isoMessageVisa.hasField(5)) {
			ptlf.setSetlCrncyAmt(isoMessageVisa.getField(5).toString());
		}
		if (isoMessageVisa.hasField(6)) {
			ptlf.setBillCrncyAmt(isoMessageVisa.getField(6).toString());
		}
		if (isoMessageVisa.hasField(9)) {
			ptlf.setSetlConversionRate(isoMessageVisa.getField(9).toString());
		}
		if (isoMessageVisa.hasField(10)) {
			ptlf.setBillConversionRate(isoMessageVisa.getField(10).toString());
		}
		if (isoMessageVisa.hasEveryField(12,13)) {
			SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			SimpleDateFormat sDateFormatYear = new SimpleDateFormat("yyyy");
			try {
				Date date = sDateFormat.parse(sDateFormatYear.format(new Date()) +isoMessageVisa.getField(13).toString()+isoMessageVisa.getField(12).toString());
				
				ptlf.setLocalDate(date);
				ptlf.setLocalTime(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				logger.error(MessageTemplate.MSG_DAT_FAIL_LOG + "{}",e);
			}
		}
		if (isoMessageVisa.hasField(14)) {
			ptlf.setExpDat(isoMessageVisa.getField(14).toString());
		}
		if (isoMessageVisa.hasField(18)) {
			ptlf.setMerchantType(isoMessageVisa.getField(18).toString());
		}
		if (isoMessageVisa.hasField(19)) {
			ptlf.setAcqCountyrCode(isoMessageVisa.getField(19).toString());
		}
		if (isoMessageVisa.hasField(22)) {
			ptlf.setPointServiceEntryCode(isoMessageVisa.getField(22).toString());
		}
		if (isoMessageVisa.hasField(23)) {
			ptlf.setCardSeqNum(isoMessageVisa.getField(23).toString());
		}
		if (isoMessageVisa.hasField(25)) {
			ptlf.setPointServiceCondCode(isoMessageVisa.getField(25).toString());
		}
		if (isoMessageVisa.hasField(26)) {
			ptlf.setPointServicePinCode(isoMessageVisa.getField(26).toString());
		}
		if (isoMessageVisa.hasField(28)) {
			ptlf.setTransactionFee(isoMessageVisa.getField(28).toString());
		}
		if (isoMessageVisa.hasField(32)) {
			ptlf.setAcqInstCode(isoMessageVisa.getField(32).toString());
		}
		if (isoMessageVisa.hasField(33)) {
			ptlf.setForwInstCode(isoMessageVisa.getField(33).toString());
		}
		if (isoMessageVisa.hasField(37)) {
			ptlf.setSeqNum(isoMessageVisa.getField(37).toString());
		}
		if (isoMessageVisa.hasField(38)) {
			ptlf.setAprvCde(isoMessageVisa.getField(38).toString());
		}
		if (isoMessageVisa.hasField(39)) {
			ptlf.setRespCde(isoMessageVisa.getField(39).toString());
		}
		if (isoMessageVisa.hasField(41)) {
			ptlf.setRetailerId(isoMessageVisa.getField(41).toString());
		}
		if (isoMessageVisa.hasField(42)) {
			ptlf.setTermId(isoMessageVisa.getField(42).toString());
		}
		if (isoMessageVisa.hasField(43)) {
		//	ptlf.set(isoMessageVisa.getField(42).toString());
			ptlf.setTermOwnerName(isoMessageVisa.getField(43).toString().substring(0, 24));
			ptlf.setTermNameLoc(isoMessageVisa.getField(43).toString().substring(25, 37));
			ptlf.setTermCity(isoMessageVisa.getField(43).toString().substring(38, 40));
		}
		if (isoMessageVisa.hasField(44)) {
			ptlf.setAdditionalRespData(isoMessageVisa.getField(44).toString());
		}
		if (isoMessageVisa.hasField(48)) {
			ptlf.setAdditionalData(isoMessageVisa.getField(48).toString());
		}
		if (isoMessageVisa.hasField(49)) {
			ptlf.setTranCrncyCde(isoMessageVisa.getField(49).toString());
		}
		if (isoMessageVisa.hasField(50)) {
			ptlf.setSetlCrncyCde(isoMessageVisa.getField(50).toString());
		}
		if (isoMessageVisa.hasField(51)) {
			ptlf.setBillCrncyCde(isoMessageVisa.getField(51).toString());
		}
		if (isoMessageVisa.hasField(52)) {
			ptlf.setPinInd("1");
		}else {
			ptlf.setPinInd("0");
		}
		
		if (isoMessageVisa.hasAnyField(45,35,55)) {
			if (isoMessageVisa.hasEveryField(35,55)) {
				ptlf.setTrackInd("4");
			}else if (isoMessageVisa.hasField(45)) {
				ptlf.setTrackInd("1");
			}else if (isoMessageVisa.hasField(35)) {
				ptlf.setTrackInd("2");
			}
		} else {
			ptlf.setTrackInd("0");
		}
		
		if (isoMessageVisa.hasField(54)) {
			ptlf.setAdditionalAmount(isoMessageVisa.getField(54).toString());
		}
		if (isoMessageVisa.hasField(55)) {
			ptlf.setChipDataField55(isoMessageVisa.getField(55).toString());
		}
		if (isoMessageVisa.hasField(60)) {
			ptlf.setAdditionalPosInfor(isoMessageVisa.getField(60).toString());
		}
		if (isoMessageVisa.hasField(62)) {
			try {
				ptlf.setCustomPaymentService(HexUtil.toHexString(isoMessageVisa.getField(62).toString().getBytes("Cp1047")));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				logger.error(MessageTemplate.MSG_DAT_FAIL_LOG + "{}",e);
			}
		}
		try {
			ptlfMapper.insert(ptlf);
			
		} catch (Exception e) {
			logger.error(MessageTemplate.MSG_DAT_FAIL_LOG + "数据库写入错误{}",e);
			return 0;
		}

		return 1;
	}
	
	
	@Override
	public long countByExample(PTLFExample example) {
		// TODO Auto-generated method stub
		return ptlfMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(PTLFExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(PTLFKey key) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int insertSelective(PTLF record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PTLF> selectByExample(PTLFExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PTLF selectByPrimaryKey(PTLFKey key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(PTLF record, PTLFExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(PTLF record, PTLFExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(PTLF record) {

		try {
			ptlfMapper.updateByPrimaryKeySelective(record);
		} catch (Exception e) {
			logger.error(MessageTemplate.MSG_DAT_FAIL_LOG + "数据库写入错误{}",e);
			return 0;
		}
		return 1;
	}

	@Override
	public int updateByPrimaryKey(PTLF record) {
		// TODO Auto-generated method stub
		try {
			 ptlfMapper.updateByPrimaryKey(record);
		} catch (Exception e) {
			logger.error(MessageTemplate.MSG_DAT_FAIL_LOG + "数据库写入错误{}",e);
			return 0;
		}
		return 1;
	}



}
