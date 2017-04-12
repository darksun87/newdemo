
package com.crm.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.crm.biz.FileBiz;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.FileInfo;
import com.crm.message.FileQueryInfo;


import com.crm.model.Message;
import com.crm.model.QueryResult;
import com.crm.model.File;
import com.crm.model.FileQuery;


import com.crm.service.FileService;
import com.crm.service.convertor.FileConvertor;
import com.crm.service.convertor.MessageConvertor;

@Service("fileService")
public class FileServiceImpl implements FileService {

	@Resource
	private FileBiz fileBiz;
			
	public MessageInfo<Integer> deleteFile(Integer id,String operatorId){
		
		Message<Integer> message  = fileBiz.deleteFile(id,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Integer> createFile(FileInfo fileInfo){
		
		File file = FileConvertor.toFile(fileInfo);
		Message<Integer> message  =  fileBiz.createFile( file );
		MessageInfo<Integer> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateFile(FileInfo fileInfo){
		
		File file = FileConvertor.toFile(fileInfo);
		Message<Integer> message  =  fileBiz.updateFile( file );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<Integer> changeStatus(
			Integer id,
			Byte status,
			String operatorId){
			
		Message<Integer> message  = fileBiz.changeStatus(id,status,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<FileInfo> getFile( Integer id ){
		
		Message<File> message  = fileBiz.getFile( id );
		MessageInfo<FileInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		FileInfo fileInfo = FileConvertor.toFileInfo(message.getData());
		messageInfo.setData(fileInfo);
		return messageInfo;
	}

    public MessageInfo<List<FileInfo>> getAllFile(){
	
		Message<List<File>> message  = fileBiz.getAllFile();
		MessageInfo<List<FileInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<FileInfo> fileInfoList = FileConvertor.toFileInfoList(message.getData());
		messageInfo.setData(fileInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<FileInfo>> queryFile(FileQueryInfo fileQueryInfo) {
		FileQuery fileQuery = FileConvertor.toFileQuery(fileQueryInfo);
		Message<QueryResult<File>> message = fileBiz.queryFile(fileQuery);
		MessageInfo<QueryResultInfo<FileInfo>> messageInfo = new MessageInfo<QueryResultInfo<FileInfo>>();
		QueryResultInfo<FileInfo> queryResultInfo = FileConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}