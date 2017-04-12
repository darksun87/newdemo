package com.crm.service;


import java.util.List;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.FileTypeInfo;
import com.crm.message.FileTypeQueryInfo;

public interface FileTypeService {
		
	MessageInfo<Integer> deleteFileType(Integer id,String operatorId);
		
    MessageInfo<Integer> createFileType(FileTypeInfo fileTypeInfo);
		
	MessageInfo<Integer> updateFileType(FileTypeInfo fileTypeInfo);
			
	MessageInfo<Integer> changeStatus(Integer id,Byte status,String operatorId);
		
	MessageInfo<FileTypeInfo> getFileType( Integer id );
		
    MessageInfo<List<FileTypeInfo>> getAllFileType();
			
    MessageInfo<QueryResultInfo<FileTypeInfo>> queryFileType(FileTypeQueryInfo fileTypeQueryInfo);
	
	

}