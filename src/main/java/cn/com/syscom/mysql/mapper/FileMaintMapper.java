package cn.com.syscom.mysql.mapper;

import cn.com.syscom.mysql.model.FileMaint;
import cn.com.syscom.mysql.model.FileMaintExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FileMaintMapper {
    long countByExample(FileMaintExample example);

    int deleteByExample(FileMaintExample example);

    int deleteByPrimaryKey(Integer primarykey);

    int insert(FileMaint record);

    int insertSelective(FileMaint record);

    List<FileMaint> selectByExample(FileMaintExample example);

    FileMaint selectByPrimaryKey(Integer primarykey);

    int updateByExampleSelective(@Param("record") FileMaint record, @Param("example") FileMaintExample example);

    int updateByExample(@Param("record") FileMaint record, @Param("example") FileMaintExample example);

    int updateByPrimaryKeySelective(FileMaint record);

    int updateByPrimaryKey(FileMaint record);
}