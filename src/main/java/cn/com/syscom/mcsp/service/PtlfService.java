package cn.com.syscom.mcsp.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.syscom.iso8583.IsoMessage;
import cn.com.syscom.mysql.model.PTLF;
import cn.com.syscom.mysql.model.PTLFExample;
import cn.com.syscom.mysql.model.PTLFKey;

public interface PtlfService {
    long countByExample(PTLFExample example);

    int deleteByExample(PTLFExample example);

    int deleteByPrimaryKey(PTLFKey key);

    int insert(IsoMessage isoMessageVisa,IsoMessage isoMessageCup);

    int insertSelective(PTLF record);

    List<PTLF> selectByExample(PTLFExample example);

    PTLF selectByPrimaryKey(PTLFKey key);

    int updateByExampleSelective(@Param("record") PTLF record, @Param("example") PTLFExample example);

    int updateByExample(@Param("record") PTLF record, @Param("example") PTLFExample example);

    int updateByPrimaryKeySelective(PTLF record);

    int updateByPrimaryKey(PTLF record);

}
