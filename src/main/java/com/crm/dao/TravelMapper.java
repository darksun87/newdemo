package com.crm.dao;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.crm.model.Travel;
import com.crm.model.TravelQuery;

public interface TravelMapper {
	
	int deleteByPrimaryKey(Integer id);
	
		
	int logicalDeleteByPrimaryKey(
        		@Param("id")Integer id,
        		@Param("updateUserid")String updateUserid,
        		@Param("updateTime")Long updateTime);
	
    int insert(Travel travel);

    Travel selectByPrimaryKey(Integer id);

	Travel selectByPrimaryKeyForUpdate(Integer id);
	
    List<Travel> selectAll();

	List<Travel> queryTravel(TravelQuery travelQuery);
			
    int updateByPrimaryKey(Travel travel);
	
			
	int changeStatus(
		@Param("id")Integer id,
		@Param("status")Byte status,
		@Param("updateUserid")String updateUserid,
		@Param("updateTime")Long updateTime);
		

}