
package com.crm.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.crm.biz.CertificatePrintBiz;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.CertificatePrintInfo;
import com.crm.message.CertificatePrintQueryInfo;


import com.crm.model.Message;
import com.crm.model.QueryResult;
import com.crm.model.CertificatePrint;
import com.crm.model.CertificatePrintQuery;


import com.crm.service.CertificatePrintService;
import com.crm.service.convertor.CertificatePrintConvertor;
import com.crm.service.convertor.MessageConvertor;

@Service("certificatePrintService")
public class CertificatePrintServiceImpl implements CertificatePrintService {

	@Resource
	private CertificatePrintBiz certificatePrintBiz;
			
	public MessageInfo<Integer> deleteCertificatePrint(Integer id,String operatorId){
		
		Message<Integer> message  = certificatePrintBiz.deleteCertificatePrint(id,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Integer> createCertificatePrint(CertificatePrintInfo certificatePrintInfo){
		
		CertificatePrint certificatePrint = CertificatePrintConvertor.toCertificatePrint(certificatePrintInfo);
		Message<Integer> message  =  certificatePrintBiz.createCertificatePrint( certificatePrint );
		MessageInfo<Integer> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateCertificatePrint(CertificatePrintInfo certificatePrintInfo){
		
		CertificatePrint certificatePrint = CertificatePrintConvertor.toCertificatePrint(certificatePrintInfo);
		Message<Integer> message  =  certificatePrintBiz.updateCertificatePrint( certificatePrint );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<Integer> changeStatus(
			Integer id,
			Byte status,
			String operatorId){
			
		Message<Integer> message  = certificatePrintBiz.changeStatus(id,status,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<CertificatePrintInfo> getCertificatePrint( Integer id ){
		
		Message<CertificatePrint> message  = certificatePrintBiz.getCertificatePrint( id );
		MessageInfo<CertificatePrintInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		CertificatePrintInfo certificatePrintInfo = CertificatePrintConvertor.toCertificatePrintInfo(message.getData());
		messageInfo.setData(certificatePrintInfo);
		return messageInfo;
	}

    public MessageInfo<List<CertificatePrintInfo>> getAllCertificatePrint(){
	
		Message<List<CertificatePrint>> message  = certificatePrintBiz.getAllCertificatePrint();
		MessageInfo<List<CertificatePrintInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<CertificatePrintInfo> certificatePrintInfoList = CertificatePrintConvertor.toCertificatePrintInfoList(message.getData());
		messageInfo.setData(certificatePrintInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<CertificatePrintInfo>> queryCertificatePrint(CertificatePrintQueryInfo certificatePrintQueryInfo) {
		CertificatePrintQuery certificatePrintQuery = CertificatePrintConvertor.toCertificatePrintQuery(certificatePrintQueryInfo);
		Message<QueryResult<CertificatePrint>> message = certificatePrintBiz.queryCertificatePrint(certificatePrintQuery);
		MessageInfo<QueryResultInfo<CertificatePrintInfo>> messageInfo = new MessageInfo<QueryResultInfo<CertificatePrintInfo>>();
		QueryResultInfo<CertificatePrintInfo> queryResultInfo = CertificatePrintConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}