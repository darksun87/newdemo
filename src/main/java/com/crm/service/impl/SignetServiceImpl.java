
package com.crm.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.crm.biz.SignetBiz;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.SignetInfo;
import com.crm.message.SignetQueryInfo;


import com.crm.model.Message;
import com.crm.model.QueryResult;
import com.crm.model.Signet;
import com.crm.model.SignetQuery;


import com.crm.service.SignetService;
import com.crm.service.convertor.SignetConvertor;
import com.crm.service.convertor.MessageConvertor;

@Service("signetService")
public class SignetServiceImpl implements SignetService {

	@Resource
	private SignetBiz signetBiz;
			
	public MessageInfo<Integer> deleteSignet(Integer id,String operatorId){
		
		Message<Integer> message  = signetBiz.deleteSignet(id,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Integer> createSignet(SignetInfo signetInfo){
		
		Signet signet = SignetConvertor.toSignet(signetInfo);
		Message<Integer> message  =  signetBiz.createSignet( signet );
		MessageInfo<Integer> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateSignet(SignetInfo signetInfo){
		
		Signet signet = SignetConvertor.toSignet(signetInfo);
		Message<Integer> message  =  signetBiz.updateSignet( signet );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<Integer> changeStatus(
			Integer id,
			Byte status,
			String operatorId){
			
		Message<Integer> message  = signetBiz.changeStatus(id,status,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<SignetInfo> getSignet( Integer id ){
		
		Message<Signet> message  = signetBiz.getSignet( id );
		MessageInfo<SignetInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		SignetInfo signetInfo = SignetConvertor.toSignetInfo(message.getData());
		messageInfo.setData(signetInfo);
		return messageInfo;
	}

    public MessageInfo<List<SignetInfo>> getAllSignet(){
	
		Message<List<Signet>> message  = signetBiz.getAllSignet();
		MessageInfo<List<SignetInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<SignetInfo> signetInfoList = SignetConvertor.toSignetInfoList(message.getData());
		messageInfo.setData(signetInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<SignetInfo>> querySignet(SignetQueryInfo signetQueryInfo) {
		SignetQuery signetQuery = SignetConvertor.toSignetQuery(signetQueryInfo);
		Message<QueryResult<Signet>> message = signetBiz.querySignet(signetQuery);
		MessageInfo<QueryResultInfo<SignetInfo>> messageInfo = new MessageInfo<QueryResultInfo<SignetInfo>>();
		QueryResultInfo<SignetInfo> queryResultInfo = SignetConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}