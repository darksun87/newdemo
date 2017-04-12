
package com.crm.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.crm.biz.CertificateApplyBiz;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.CertificateApplyInfo;
import com.crm.message.CertificateApplyQueryInfo;


import com.crm.model.Message;
import com.crm.model.QueryResult;
import com.crm.model.CertificateApply;
import com.crm.model.CertificateApplyQuery;


import com.crm.service.CertificateApplyService;
import com.crm.service.convertor.CertificateApplyConvertor;
import com.crm.service.convertor.MessageConvertor;

@Service("certificateApplyService")
public class CertificateApplyServiceImpl implements CertificateApplyService {

	@Resource
	private CertificateApplyBiz certificateApplyBiz;
			
	public MessageInfo<Integer> deleteCertificateApply(Integer id,String operatorId){
		
		Message<Integer> message  = certificateApplyBiz.deleteCertificateApply(id,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Integer> createCertificateApply(CertificateApplyInfo certificateApplyInfo){
		
		CertificateApply certificateApply = CertificateApplyConvertor.toCertificateApply(certificateApplyInfo);
		Message<Integer> message  =  certificateApplyBiz.createCertificateApply( certificateApply );
		MessageInfo<Integer> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateCertificateApply(CertificateApplyInfo certificateApplyInfo){
		
		CertificateApply certificateApply = CertificateApplyConvertor.toCertificateApply(certificateApplyInfo);
		Message<Integer> message  =  certificateApplyBiz.updateCertificateApply( certificateApply );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<Integer> changeStatus(
			Integer id,
			Byte status,
			String operatorId){
			
		Message<Integer> message  = certificateApplyBiz.changeStatus(id,status,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<CertificateApplyInfo> getCertificateApply( Integer id ){
		
		Message<CertificateApply> message  = certificateApplyBiz.getCertificateApply( id );
		MessageInfo<CertificateApplyInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		CertificateApplyInfo certificateApplyInfo = CertificateApplyConvertor.toCertificateApplyInfo(message.getData());
		messageInfo.setData(certificateApplyInfo);
		return messageInfo;
	}

    public MessageInfo<List<CertificateApplyInfo>> getAllCertificateApply(){
	
		Message<List<CertificateApply>> message  = certificateApplyBiz.getAllCertificateApply();
		MessageInfo<List<CertificateApplyInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<CertificateApplyInfo> certificateApplyInfoList = CertificateApplyConvertor.toCertificateApplyInfoList(message.getData());
		messageInfo.setData(certificateApplyInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<CertificateApplyInfo>> queryCertificateApply(CertificateApplyQueryInfo certificateApplyQueryInfo) {
		CertificateApplyQuery certificateApplyQuery = CertificateApplyConvertor.toCertificateApplyQuery(certificateApplyQueryInfo);
		Message<QueryResult<CertificateApply>> message = certificateApplyBiz.queryCertificateApply(certificateApplyQuery);
		MessageInfo<QueryResultInfo<CertificateApplyInfo>> messageInfo = new MessageInfo<QueryResultInfo<CertificateApplyInfo>>();
		QueryResultInfo<CertificateApplyInfo> queryResultInfo = CertificateApplyConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}