package cn.com.syscom.mcsp.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.syscom.iso8583.IsoMessage;
import cn.com.syscom.iso8583.util.MessageTemplate;
import cn.com.syscom.mcsp.service.FileMaintService;
import cn.com.syscom.mysql.mapper.FileMaintMapper;
import cn.com.syscom.mysql.model.FileMaint;
import cn.com.syscom.mysql.model.FileMaintExample;

@Service
public class FileMaintServiceImpl implements FileMaintService {
	
	private Logger logger = LoggerFactory.getLogger(FileMaintServiceImpl.class);
	
	@Autowired
	FileMaintMapper fileMaintMapper;
	
	@Override
	public int insert(IsoMessage isoMessage) {
		FileMaint fileMaint = new FileMaint();
		
		if (isoMessage.hasEveryField(2,7,91,101)) {
			fileMaint.setAccountnumber(isoMessage.getField(2).toString());
			fileMaint.setDate(isoMessage.getObjectValue(7));
			fileMaint.setTime(isoMessage.getObjectValue(7));
			fileMaint.setUpdatecode(Integer.valueOf(isoMessage.getObjectValue(91)));
			fileMaint.setFilename(isoMessage.getField(101).toString());
			
			switch (Integer.valueOf(isoMessage.getObjectValue(91))) {
			case 1:
				fileMaint.setCodedefinition("Add");
				break;
			case 2:
				fileMaint.setCodedefinition("Change");
				break;
			case 3:
				fileMaint.setCodedefinition("Delete");
				break;
			case 4:
				fileMaint.setCodedefinition("Replace");
				break;
			case 5:
				fileMaint.setCodedefinition("Inquire");
				break;
			default:
				break;
			}
		} else {
			logger.error("Online File Maintenance error");		
			return 0;
		}
		
		fileMaintMapper.insert(fileMaint);
		return 1;
	}
	
	@Override
	public long countByExample(FileMaintExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(FileMaintExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer primarykey) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int insertSelective(FileMaint record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<FileMaint> selectByExample(FileMaintExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FileMaint selectByPrimaryKey(Integer primarykey) {
		
		return fileMaintMapper.selectByPrimaryKey(primarykey);
	}

	@Override
	public int updateByExampleSelective(FileMaint record, FileMaintExample example) {
		try {
			fileMaintMapper.updateByExampleSelective(record,example);
			logger.info("更新File Maintenance数据库");
		} catch (Exception e) {
			logger.error(MessageTemplate.MSG_DAT_FAIL_LOG + "数据库写入错误{}",e);
			return 0;
		}
		return 1;
	}

	@Override
	public int updateByExample(FileMaint record, FileMaintExample example) {
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(FileMaint record) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(FileMaint record) {
		// TODO Auto-generated method stub
		return 0;
	}
}
