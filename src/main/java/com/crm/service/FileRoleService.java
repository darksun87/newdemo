package com.crm.service;


import java.util.List;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.FileRoleInfo;
import com.crm.message.FileRoleQueryInfo;

public interface FileRoleService {
		
	MessageInfo<Integer> deleteFileRole(Integer id,String operatorId);
		
    MessageInfo<Integer> createFileRole(FileRoleInfo fileRoleInfo);
		
	MessageInfo<Integer> updateFileRole(FileRoleInfo fileRoleInfo);
			
	MessageInfo<Integer> changeStatus(Integer id,Byte status,String operatorId);
		
	MessageInfo<FileRoleInfo> getFileRole( Integer id );
		
    MessageInfo<List<FileRoleInfo>> getAllFileRole();
			
    MessageInfo<QueryResultInfo<FileRoleInfo>> queryFileRole(FileRoleQueryInfo fileRoleQueryInfo);
	
	

}