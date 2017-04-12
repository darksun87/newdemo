
package com.crm.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.crm.biz.SignetApplyBiz;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.SignetApplyInfo;
import com.crm.message.SignetApplyQueryInfo;


import com.crm.model.Message;
import com.crm.model.QueryResult;
import com.crm.model.SignetApply;
import com.crm.model.SignetApplyQuery;


import com.crm.service.SignetApplyService;
import com.crm.service.convertor.SignetApplyConvertor;
import com.crm.service.convertor.MessageConvertor;

@Service("signetApplyService")
public class SignetApplyServiceImpl implements SignetApplyService {

	@Resource
	private SignetApplyBiz signetApplyBiz;
			
	public MessageInfo<Integer> deleteSignetApply(Integer id,String operatorId){
		
		Message<Integer> message  = signetApplyBiz.deleteSignetApply(id,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Integer> createSignetApply(SignetApplyInfo signetApplyInfo){
		
		SignetApply signetApply = SignetApplyConvertor.toSignetApply(signetApplyInfo);
		Message<Integer> message  =  signetApplyBiz.createSignetApply( signetApply );
		MessageInfo<Integer> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateSignetApply(SignetApplyInfo signetApplyInfo){
		
		SignetApply signetApply = SignetApplyConvertor.toSignetApply(signetApplyInfo);
		Message<Integer> message  =  signetApplyBiz.updateSignetApply( signetApply );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<Integer> changeStatus(
			Integer id,
			Byte status,
			String operatorId){
			
		Message<Integer> message  = signetApplyBiz.changeStatus(id,status,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<SignetApplyInfo> getSignetApply( Integer id ){
		
		Message<SignetApply> message  = signetApplyBiz.getSignetApply( id );
		MessageInfo<SignetApplyInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		SignetApplyInfo signetApplyInfo = SignetApplyConvertor.toSignetApplyInfo(message.getData());
		messageInfo.setData(signetApplyInfo);
		return messageInfo;
	}

    public MessageInfo<List<SignetApplyInfo>> getAllSignetApply(){
	
		Message<List<SignetApply>> message  = signetApplyBiz.getAllSignetApply();
		MessageInfo<List<SignetApplyInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<SignetApplyInfo> signetApplyInfoList = SignetApplyConvertor.toSignetApplyInfoList(message.getData());
		messageInfo.setData(signetApplyInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<SignetApplyInfo>> querySignetApply(SignetApplyQueryInfo signetApplyQueryInfo) {
		SignetApplyQuery signetApplyQuery = SignetApplyConvertor.toSignetApplyQuery(signetApplyQueryInfo);
		Message<QueryResult<SignetApply>> message = signetApplyBiz.querySignetApply(signetApplyQuery);
		MessageInfo<QueryResultInfo<SignetApplyInfo>> messageInfo = new MessageInfo<QueryResultInfo<SignetApplyInfo>>();
		QueryResultInfo<SignetApplyInfo> queryResultInfo = SignetApplyConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}