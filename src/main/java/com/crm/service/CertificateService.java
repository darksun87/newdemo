package com.crm.service;


import java.util.List;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.CertificateInfo;
import com.crm.message.CertificateQueryInfo;

public interface CertificateService {
		
	MessageInfo<Integer> deleteCertificate(Integer id,String operatorId);
		
    MessageInfo<Integer> createCertificate(CertificateInfo certificateInfo);
		
	MessageInfo<Integer> updateCertificate(CertificateInfo certificateInfo);
			
	MessageInfo<Integer> changeStatus(Integer id,Byte status,String operatorId);
		
	MessageInfo<CertificateInfo> getCertificate( Integer id );
		
    MessageInfo<List<CertificateInfo>> getAllCertificate();
			
    MessageInfo<QueryResultInfo<CertificateInfo>> queryCertificate(CertificateQueryInfo certificateQueryInfo);
	
	

}