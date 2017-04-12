package com.crm.dao;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.crm.model.File;
import com.crm.model.FileQuery;

public interface FileMapper {
	
	int deleteByPrimaryKey(Integer id);
	
		
	int logicalDeleteByPrimaryKey(
        		@Param("id")Integer id,
        		@Param("updateUserid")String updateUserid,
        		@Param("updateTime")Long updateTime);
	
    int insert(File file);

    File selectByPrimaryKey(Integer id);

	File selectByPrimaryKeyForUpdate(Integer id);
	
    List<File> selectAll();

	List<File> queryFile(FileQuery fileQuery);
			
    int updateByPrimaryKey(File file);
	
			
	int changeStatus(
		@Param("id")Integer id,
		@Param("status")Byte status,
		@Param("updateUserid")String updateUserid,
		@Param("updateTime")Long updateTime);
		

}