package cn.com.syscom.mysql.mapper;

import cn.com.syscom.mysql.model.ProcessParam;

public interface ProcessParamMapper {
    String selectSignonByInterfaceId(Integer interfaceId);
    ProcessParam selectByByInterfaceId(Integer interfaceId);
}