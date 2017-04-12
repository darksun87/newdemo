package com.crm.dao;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.crm.model.SignetApplyFile;
import com.crm.model.SignetApplyFileQuery;

public interface SignetApplyFileMapper {
	
	int deleteByPrimaryKey(Integer id);
	
		
	int logicalDeleteByPrimaryKey(
        		@Param("id")Integer id,
        		@Param("updateUserid")String updateUserid,
        		@Param("updateTime")Long updateTime);
	
    int insert(SignetApplyFile signetApplyFile);

    SignetApplyFile selectByPrimaryKey(Integer id);

	SignetApplyFile selectByPrimaryKeyForUpdate(Integer id);
	
    List<SignetApplyFile> selectAll();

	List<SignetApplyFile> querySignetApplyFile(SignetApplyFileQuery signetApplyFileQuery);
			
    int updateByPrimaryKey(SignetApplyFile signetApplyFile);
	
			
	int changeStatus(
		@Param("id")Integer id,
		@Param("status")Byte status,
		@Param("updateUserid")String updateUserid,
		@Param("updateTime")Long updateTime);
		

}