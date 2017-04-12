package com.crm.dao;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.crm.model.CertificatePrint;
import com.crm.model.CertificatePrintQuery;

public interface CertificatePrintMapper {
	
	int deleteByPrimaryKey(Integer id);
	
		
	int logicalDeleteByPrimaryKey(
        		@Param("id")Integer id,
        		@Param("updateUserid")String updateUserid,
        		@Param("updateTime")Long updateTime);
	
    int insert(CertificatePrint certificatePrint);

    CertificatePrint selectByPrimaryKey(Integer id);

	CertificatePrint selectByPrimaryKeyForUpdate(Integer id);
	
    List<CertificatePrint> selectAll();

	List<CertificatePrint> queryCertificatePrint(CertificatePrintQuery certificatePrintQuery);
			
    int updateByPrimaryKey(CertificatePrint certificatePrint);
	
			
	int changeStatus(
		@Param("id")Integer id,
		@Param("status")Byte status,
		@Param("updateUserid")String updateUserid,
		@Param("updateTime")Long updateTime);
		

}