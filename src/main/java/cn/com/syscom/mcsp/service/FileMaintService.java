package cn.com.syscom.mcsp.service;

import cn.com.syscom.iso8583.IsoMessage;
import cn.com.syscom.mysql.model.FileMaint;
import cn.com.syscom.mysql.model.FileMaintExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FileMaintService {
    long countByExample(FileMaintExample example);

    int deleteByExample(FileMaintExample example);

    int deleteByPrimaryKey(Integer primarykey);

    int insert(IsoMessage isoMessage);

    int insertSelective(FileMaint record);

    List<FileMaint> selectByExample(FileMaintExample example);

    FileMaint selectByPrimaryKey(Integer primarykey);

    int updateByExampleSelective(@Param("record") FileMaint record, @Param("example") FileMaintExample example);

    int updateByExample(@Param("record") FileMaint record, @Param("example") FileMaintExample example);

    int updateByPrimaryKeySelective(FileMaint record);

    int updateByPrimaryKey(FileMaint record);
}