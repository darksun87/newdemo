package com.crm.dao;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.crm.model.FileType;
import com.crm.model.FileTypeQuery;

public interface FileTypeMapper {
	
	int deleteByPrimaryKey(Integer id);
	
		
	int logicalDeleteByPrimaryKey(
        		@Param("id")Integer id,
        		@Param("updateUserid")String updateUserid,
        		@Param("updateTime")Long updateTime);
	
    int insert(FileType fileType);

    FileType selectByPrimaryKey(Integer id);

	FileType selectByPrimaryKeyForUpdate(Integer id);
	
    List<FileType> selectAll();

	List<FileType> queryFileType(FileTypeQuery fileTypeQuery);
			
    int updateByPrimaryKey(FileType fileType);
	
			
	int changeStatus(
		@Param("id")Integer id,
		@Param("status")Byte status,
		@Param("updateUserid")String updateUserid,
		@Param("updateTime")Long updateTime);
		

}