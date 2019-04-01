package cn.com.syscom.mysql.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.com.syscom.mysql.model.PTLF;
import cn.com.syscom.mysql.model.PTLFExample;
import cn.com.syscom.mysql.model.PTLFKey;


public interface PTLFMapper {
    long countByExample(PTLFExample example);

    int deleteByExample(PTLFExample example);

    int deleteByPrimaryKey(PTLFKey key);

    int insert(PTLF record);

    int insertSelective(PTLF record);

    List<PTLF> selectByExample(PTLFExample example);

    PTLF selectByPrimaryKey(PTLFKey key);

    int updateByExampleSelective(@Param("record") PTLF record, @Param("example") PTLFExample example);

    int updateByExample(@Param("record") PTLF record, @Param("example") PTLFExample example);

    int updateByPrimaryKeySelective(PTLF record);

    int updateByPrimaryKey(PTLF record);
}