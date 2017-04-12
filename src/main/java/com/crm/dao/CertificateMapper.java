package com.crm.dao;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.crm.model.Certificate;
import com.crm.model.CertificateQuery;

public interface CertificateMapper {
	
	int deleteByPrimaryKey(Integer id);
	
		
	int logicalDeleteByPrimaryKey(
        		@Param("id")Integer id,
        		@Param("updateUserid")String updateUserid,
        		@Param("updateTime")Long updateTime);
	
    int insert(Certificate certificate);

    Certificate selectByPrimaryKey(Integer id);

	Certificate selectByPrimaryKeyForUpdate(Integer id);
	
    List<Certificate> selectAll();

	List<Certificate> queryCertificate(CertificateQuery certificateQuery);
			
    int updateByPrimaryKey(Certificate certificate);
	
			
	int changeStatus(
		@Param("id")Integer id,
		@Param("status")Byte status,
		@Param("updateUserid")String updateUserid,
		@Param("updateTime")Long updateTime);
		

}