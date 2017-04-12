package com.crm.dao;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.crm.model.CertificateApply;
import com.crm.model.CertificateApplyQuery;

public interface CertificateApplyMapper {
	
	int deleteByPrimaryKey(Integer id);
	
		
	int logicalDeleteByPrimaryKey(
        		@Param("id")Integer id,
        		@Param("updateUserid")String updateUserid,
        		@Param("updateTime")Long updateTime);
	
    int insert(CertificateApply certificateApply);

    CertificateApply selectByPrimaryKey(Integer id);

	CertificateApply selectByPrimaryKeyForUpdate(Integer id);
	
    List<CertificateApply> selectAll();

	List<CertificateApply> queryCertificateApply(CertificateApplyQuery certificateApplyQuery);
			
    int updateByPrimaryKey(CertificateApply certificateApply);
	
			
	int changeStatus(
		@Param("id")Integer id,
		@Param("status")Byte status,
		@Param("updateUserid")String updateUserid,
		@Param("updateTime")Long updateTime);
		

}