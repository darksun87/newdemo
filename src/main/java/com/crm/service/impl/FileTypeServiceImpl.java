
package com.crm.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.crm.biz.FileTypeBiz;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.FileTypeInfo;
import com.crm.message.FileTypeQueryInfo;


import com.crm.model.Message;
import com.crm.model.QueryResult;
import com.crm.model.FileType;
import com.crm.model.FileTypeQuery;


import com.crm.service.FileTypeService;
import com.crm.service.convertor.FileTypeConvertor;
import com.crm.service.convertor.MessageConvertor;

@Service("fileTypeService")
public class FileTypeServiceImpl implements FileTypeService {

	@Resource
	private FileTypeBiz fileTypeBiz;
			
	public MessageInfo<Integer> deleteFileType(Integer id,String operatorId){
		
		Message<Integer> message  = fileTypeBiz.deleteFileType(id,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Integer> createFileType(FileTypeInfo fileTypeInfo){
		
		FileType fileType = FileTypeConvertor.toFileType(fileTypeInfo);
		Message<Integer> message  =  fileTypeBiz.createFileType( fileType );
		MessageInfo<Integer> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateFileType(FileTypeInfo fileTypeInfo){
		
		FileType fileType = FileTypeConvertor.toFileType(fileTypeInfo);
		Message<Integer> message  =  fileTypeBiz.updateFileType( fileType );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<Integer> changeStatus(
			Integer id,
			Byte status,
			String operatorId){
			
		Message<Integer> message  = fileTypeBiz.changeStatus(id,status,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<FileTypeInfo> getFileType( Integer id ){
		
		Message<FileType> message  = fileTypeBiz.getFileType( id );
		MessageInfo<FileTypeInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		FileTypeInfo fileTypeInfo = FileTypeConvertor.toFileTypeInfo(message.getData());
		messageInfo.setData(fileTypeInfo);
		return messageInfo;
	}

    public MessageInfo<List<FileTypeInfo>> getAllFileType(){
	
		Message<List<FileType>> message  = fileTypeBiz.getAllFileType();
		MessageInfo<List<FileTypeInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<FileTypeInfo> fileTypeInfoList = FileTypeConvertor.toFileTypeInfoList(message.getData());
		messageInfo.setData(fileTypeInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<FileTypeInfo>> queryFileType(FileTypeQueryInfo fileTypeQueryInfo) {
		FileTypeQuery fileTypeQuery = FileTypeConvertor.toFileTypeQuery(fileTypeQueryInfo);
		Message<QueryResult<FileType>> message = fileTypeBiz.queryFileType(fileTypeQuery);
		MessageInfo<QueryResultInfo<FileTypeInfo>> messageInfo = new MessageInfo<QueryResultInfo<FileTypeInfo>>();
		QueryResultInfo<FileTypeInfo> queryResultInfo = FileTypeConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}