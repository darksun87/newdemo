
package com.crm.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.crm.biz.SignetApplyFileBiz;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.SignetApplyFileInfo;
import com.crm.message.SignetApplyFileQueryInfo;


import com.crm.model.Message;
import com.crm.model.QueryResult;
import com.crm.model.SignetApplyFile;
import com.crm.model.SignetApplyFileQuery;


import com.crm.service.SignetApplyFileService;
import com.crm.service.convertor.SignetApplyFileConvertor;
import com.crm.service.convertor.MessageConvertor;

@Service("signetApplyFileService")
public class SignetApplyFileServiceImpl implements SignetApplyFileService {

	@Resource
	private SignetApplyFileBiz signetApplyFileBiz;
			
	public MessageInfo<Integer> deleteSignetApplyFile(Integer id,String operatorId){
		
		Message<Integer> message  = signetApplyFileBiz.deleteSignetApplyFile(id,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Integer> createSignetApplyFile(SignetApplyFileInfo signetApplyFileInfo){
		
		SignetApplyFile signetApplyFile = SignetApplyFileConvertor.toSignetApplyFile(signetApplyFileInfo);
		Message<Integer> message  =  signetApplyFileBiz.createSignetApplyFile( signetApplyFile );
		MessageInfo<Integer> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateSignetApplyFile(SignetApplyFileInfo signetApplyFileInfo){
		
		SignetApplyFile signetApplyFile = SignetApplyFileConvertor.toSignetApplyFile(signetApplyFileInfo);
		Message<Integer> message  =  signetApplyFileBiz.updateSignetApplyFile( signetApplyFile );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<Integer> changeStatus(
			Integer id,
			Byte status,
			String operatorId){
			
		Message<Integer> message  = signetApplyFileBiz.changeStatus(id,status,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<SignetApplyFileInfo> getSignetApplyFile( Integer id ){
		
		Message<SignetApplyFile> message  = signetApplyFileBiz.getSignetApplyFile( id );
		MessageInfo<SignetApplyFileInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		SignetApplyFileInfo signetApplyFileInfo = SignetApplyFileConvertor.toSignetApplyFileInfo(message.getData());
		messageInfo.setData(signetApplyFileInfo);
		return messageInfo;
	}

    public MessageInfo<List<SignetApplyFileInfo>> getAllSignetApplyFile(){
	
		Message<List<SignetApplyFile>> message  = signetApplyFileBiz.getAllSignetApplyFile();
		MessageInfo<List<SignetApplyFileInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<SignetApplyFileInfo> signetApplyFileInfoList = SignetApplyFileConvertor.toSignetApplyFileInfoList(message.getData());
		messageInfo.setData(signetApplyFileInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<SignetApplyFileInfo>> querySignetApplyFile(SignetApplyFileQueryInfo signetApplyFileQueryInfo) {
		SignetApplyFileQuery signetApplyFileQuery = SignetApplyFileConvertor.toSignetApplyFileQuery(signetApplyFileQueryInfo);
		Message<QueryResult<SignetApplyFile>> message = signetApplyFileBiz.querySignetApplyFile(signetApplyFileQuery);
		MessageInfo<QueryResultInfo<SignetApplyFileInfo>> messageInfo = new MessageInfo<QueryResultInfo<SignetApplyFileInfo>>();
		QueryResultInfo<SignetApplyFileInfo> queryResultInfo = SignetApplyFileConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}