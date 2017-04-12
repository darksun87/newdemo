package com.crm.dao;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.crm.model.SignetApply;
import com.crm.model.SignetApplyQuery;

public interface SignetApplyMapper {
	
	int deleteByPrimaryKey(Integer id);
	
		
	int logicalDeleteByPrimaryKey(
        		@Param("id")Integer id,
        		@Param("updateUserid")String updateUserid,
        		@Param("updateTime")Long updateTime);
	
    int insert(SignetApply signetApply);

    SignetApply selectByPrimaryKey(Integer id);

	SignetApply selectByPrimaryKeyForUpdate(Integer id);
	
    List<SignetApply> selectAll();

	List<SignetApply> querySignetApply(SignetApplyQuery signetApplyQuery);
			
    int updateByPrimaryKey(SignetApply signetApply);
	
			
	int changeStatus(
		@Param("id")Integer id,
		@Param("status")Byte status,
		@Param("updateUserid")String updateUserid,
		@Param("updateTime")Long updateTime);
		

}