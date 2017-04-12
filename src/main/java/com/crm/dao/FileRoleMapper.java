package com.crm.dao;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.crm.model.FileRole;
import com.crm.model.FileRoleQuery;

public interface FileRoleMapper {
	
	int deleteByPrimaryKey(Integer id);
	
		
	int logicalDeleteByPrimaryKey(
        		@Param("id")Integer id,
        		@Param("updateUserid")String updateUserid,
        		@Param("updateTime")Long updateTime);
	
    int insert(FileRole fileRole);

    FileRole selectByPrimaryKey(Integer id);

	FileRole selectByPrimaryKeyForUpdate(Integer id);
	
    List<FileRole> selectAll();

	List<FileRole> queryFileRole(FileRoleQuery fileRoleQuery);
			
    int updateByPrimaryKey(FileRole fileRole);
	
			
	int changeStatus(
		@Param("id")Integer id,
		@Param("status")Byte status,
		@Param("updateUserid")String updateUserid,
		@Param("updateTime")Long updateTime);
		

}