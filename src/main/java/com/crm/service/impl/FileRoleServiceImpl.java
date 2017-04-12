
package com.crm.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.crm.biz.FileRoleBiz;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.FileRoleInfo;
import com.crm.message.FileRoleQueryInfo;


import com.crm.model.Message;
import com.crm.model.QueryResult;
import com.crm.model.FileRole;
import com.crm.model.FileRoleQuery;


import com.crm.service.FileRoleService;
import com.crm.service.convertor.FileRoleConvertor;
import com.crm.service.convertor.MessageConvertor;

@Service("fileRoleService")
public class FileRoleServiceImpl implements FileRoleService {

	@Resource
	private FileRoleBiz fileRoleBiz;
			
	public MessageInfo<Integer> deleteFileRole(Integer id,String operatorId){
		
		Message<Integer> message  = fileRoleBiz.deleteFileRole(id,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Integer> createFileRole(FileRoleInfo fileRoleInfo){
		
		FileRole fileRole = FileRoleConvertor.toFileRole(fileRoleInfo);
		Message<Integer> message  =  fileRoleBiz.createFileRole( fileRole );
		MessageInfo<Integer> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateFileRole(FileRoleInfo fileRoleInfo){
		
		FileRole fileRole = FileRoleConvertor.toFileRole(fileRoleInfo);
		Message<Integer> message  =  fileRoleBiz.updateFileRole( fileRole );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<Integer> changeStatus(
			Integer id,
			Byte status,
			String operatorId){
			
		Message<Integer> message  = fileRoleBiz.changeStatus(id,status,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<FileRoleInfo> getFileRole( Integer id ){
		
		Message<FileRole> message  = fileRoleBiz.getFileRole( id );
		MessageInfo<FileRoleInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		FileRoleInfo fileRoleInfo = FileRoleConvertor.toFileRoleInfo(message.getData());
		messageInfo.setData(fileRoleInfo);
		return messageInfo;
	}

    public MessageInfo<List<FileRoleInfo>> getAllFileRole(){
	
		Message<List<FileRole>> message  = fileRoleBiz.getAllFileRole();
		MessageInfo<List<FileRoleInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<FileRoleInfo> fileRoleInfoList = FileRoleConvertor.toFileRoleInfoList(message.getData());
		messageInfo.setData(fileRoleInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<FileRoleInfo>> queryFileRole(FileRoleQueryInfo fileRoleQueryInfo) {
		FileRoleQuery fileRoleQuery = FileRoleConvertor.toFileRoleQuery(fileRoleQueryInfo);
		Message<QueryResult<FileRole>> message = fileRoleBiz.queryFileRole(fileRoleQuery);
		MessageInfo<QueryResultInfo<FileRoleInfo>> messageInfo = new MessageInfo<QueryResultInfo<FileRoleInfo>>();
		QueryResultInfo<FileRoleInfo> queryResultInfo = FileRoleConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}