package com.crm.dao;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.crm.model.Log;
import com.crm.model.LogQuery;

public interface LogMapper {
	
	int deleteByPrimaryKey(Integer id);
	
		
	int logicalDeleteByPrimaryKey(
        		@Param("id")Integer id,
        		@Param("updateUserid")String updateUserid,
        		@Param("updateTime")Long updateTime);
	
    int insert(Log log);

    Log selectByPrimaryKey(Integer id);

	Log selectByPrimaryKeyForUpdate(Integer id);
	
    List<Log> selectAll();

	List<Log> queryLog(LogQuery logQuery);
			
    int updateByPrimaryKey(Log log);
	
			
	int changeStatus(
		@Param("id")Integer id,
		@Param("status")Byte status,
		@Param("updateUserid")String updateUserid,
		@Param("updateTime")Long updateTime);
		

}