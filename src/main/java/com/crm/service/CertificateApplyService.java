package com.crm.service;


import java.util.List;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.CertificateApplyInfo;
import com.crm.message.CertificateApplyQueryInfo;

public interface CertificateApplyService {
		
	MessageInfo<Integer> deleteCertificateApply(Integer id,String operatorId);
		
    MessageInfo<Integer> createCertificateApply(CertificateApplyInfo certificateApplyInfo);
		
	MessageInfo<Integer> updateCertificateApply(CertificateApplyInfo certificateApplyInfo);
			
	MessageInfo<Integer> changeStatus(Integer id,Byte status,String operatorId);
		
	MessageInfo<CertificateApplyInfo> getCertificateApply( Integer id );
		
    MessageInfo<List<CertificateApplyInfo>> getAllCertificateApply();
			
    MessageInfo<QueryResultInfo<CertificateApplyInfo>> queryCertificateApply(CertificateApplyQueryInfo certificateApplyQueryInfo);
	
	

}