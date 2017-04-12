
package com.crm.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.crm.biz.CertificateBiz;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.CertificateInfo;
import com.crm.message.CertificateQueryInfo;


import com.crm.model.Message;
import com.crm.model.QueryResult;
import com.crm.model.Certificate;
import com.crm.model.CertificateQuery;


import com.crm.service.CertificateService;
import com.crm.service.convertor.CertificateConvertor;
import com.crm.service.convertor.MessageConvertor;

@Service("certificateService")
public class CertificateServiceImpl implements CertificateService {

	@Resource
	private CertificateBiz certificateBiz;
			
	public MessageInfo<Integer> deleteCertificate(Integer id,String operatorId){
		
		Message<Integer> message  = certificateBiz.deleteCertificate(id,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Integer> createCertificate(CertificateInfo certificateInfo){
		
		Certificate certificate = CertificateConvertor.toCertificate(certificateInfo);
		Message<Integer> message  =  certificateBiz.createCertificate( certificate );
		MessageInfo<Integer> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateCertificate(CertificateInfo certificateInfo){
		
		Certificate certificate = CertificateConvertor.toCertificate(certificateInfo);
		Message<Integer> message  =  certificateBiz.updateCertificate( certificate );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<Integer> changeStatus(
			Integer id,
			Byte status,
			String operatorId){
			
		Message<Integer> message  = certificateBiz.changeStatus(id,status,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<CertificateInfo> getCertificate( Integer id ){
		
		Message<Certificate> message  = certificateBiz.getCertificate( id );
		MessageInfo<CertificateInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		CertificateInfo certificateInfo = CertificateConvertor.toCertificateInfo(message.getData());
		messageInfo.setData(certificateInfo);
		return messageInfo;
	}

    public MessageInfo<List<CertificateInfo>> getAllCertificate(){
	
		Message<List<Certificate>> message  = certificateBiz.getAllCertificate();
		MessageInfo<List<CertificateInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<CertificateInfo> certificateInfoList = CertificateConvertor.toCertificateInfoList(message.getData());
		messageInfo.setData(certificateInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<CertificateInfo>> queryCertificate(CertificateQueryInfo certificateQueryInfo) {
		CertificateQuery certificateQuery = CertificateConvertor.toCertificateQuery(certificateQueryInfo);
		Message<QueryResult<Certificate>> message = certificateBiz.queryCertificate(certificateQuery);
		MessageInfo<QueryResultInfo<CertificateInfo>> messageInfo = new MessageInfo<QueryResultInfo<CertificateInfo>>();
		QueryResultInfo<CertificateInfo> queryResultInfo = CertificateConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}