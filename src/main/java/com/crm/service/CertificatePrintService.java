package com.crm.service;


import java.util.List;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.CertificatePrintInfo;
import com.crm.message.CertificatePrintQueryInfo;

public interface CertificatePrintService {
		
	MessageInfo<Integer> deleteCertificatePrint(Integer id,String operatorId);
		
    MessageInfo<Integer> createCertificatePrint(CertificatePrintInfo certificatePrintInfo);
		
	MessageInfo<Integer> updateCertificatePrint(CertificatePrintInfo certificatePrintInfo);
			
	MessageInfo<Integer> changeStatus(Integer id,Byte status,String operatorId);
		
	MessageInfo<CertificatePrintInfo> getCertificatePrint( Integer id );
		
    MessageInfo<List<CertificatePrintInfo>> getAllCertificatePrint();
			
    MessageInfo<QueryResultInfo<CertificatePrintInfo>> queryCertificatePrint(CertificatePrintQueryInfo certificatePrintQueryInfo);
	
	

}