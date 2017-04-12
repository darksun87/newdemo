package com.crm.service;


import java.util.List;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.FileInfo;
import com.crm.message.FileQueryInfo;

public interface FileService {
		
	MessageInfo<Integer> deleteFile(Integer id,String operatorId);
		
    MessageInfo<Integer> createFile(FileInfo fileInfo);
		
	MessageInfo<Integer> updateFile(FileInfo fileInfo);
			
	MessageInfo<Integer> changeStatus(Integer id,Byte status,String operatorId);
		
	MessageInfo<FileInfo> getFile( Integer id );
		
    MessageInfo<List<FileInfo>> getAllFile();
			
    MessageInfo<QueryResultInfo<FileInfo>> queryFile(FileQueryInfo fileQueryInfo);
	
	

}