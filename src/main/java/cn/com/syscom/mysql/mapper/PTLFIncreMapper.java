package cn.com.syscom.mysql.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.com.syscom.mysql.model.PTLFIncre;
import cn.com.syscom.mysql.model.PTLFIncreExample;

public interface PTLFIncreMapper {
    long countByExample(PTLFIncreExample example);

    int deleteByExample(PTLFIncreExample example);

    int deleteByPrimaryKey(Integer primaryId);

    int insert(PTLFIncre record);

    int insertSelective(PTLFIncre record);

    List<PTLFIncre> selectByExample(PTLFIncreExample example);

    PTLFIncre selectByPrimaryKey(Integer primaryId);

    int updateByExampleSelective(@Param("record") PTLFIncre record, @Param("example") PTLFIncreExample example);

    int updateByExample(@Param("record") PTLFIncre record, @Param("example") PTLFIncreExample example);

    int updateByPrimaryKeySelective(PTLFIncre record);

    int updateByPrimaryKey(PTLFIncre record);
}