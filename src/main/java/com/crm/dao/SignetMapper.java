package com.crm.dao;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.crm.model.Signet;
import com.crm.model.SignetQuery;

public interface SignetMapper {
	
	int deleteByPrimaryKey(Integer id);
	
		
	int logicalDeleteByPrimaryKey(
        		@Param("id")Integer id,
        		@Param("updateUserid")String updateUserid,
        		@Param("updateTime")Long updateTime);
	
    int insert(Signet signet);

    Signet selectByPrimaryKey(Integer id);

	Signet selectByPrimaryKeyForUpdate(Integer id);
	
    List<Signet> selectAll();

	List<Signet> querySignet(SignetQuery signetQuery);
			
    int updateByPrimaryKey(Signet signet);
	
			
	int changeStatus(
		@Param("id")Integer id,
		@Param("status")Byte status,
		@Param("updateUserid")String updateUserid,
		@Param("updateTime")Long updateTime);
		

}