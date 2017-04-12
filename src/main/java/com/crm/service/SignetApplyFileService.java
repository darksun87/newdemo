package com.crm.service;


import java.util.List;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.SignetApplyFileInfo;
import com.crm.message.SignetApplyFileQueryInfo;

public interface SignetApplyFileService {
		
	MessageInfo<Integer> deleteSignetApplyFile(Integer id,String operatorId);
		
    MessageInfo<Integer> createSignetApplyFile(SignetApplyFileInfo signetApplyFileInfo);
		
	MessageInfo<Integer> updateSignetApplyFile(SignetApplyFileInfo signetApplyFileInfo);
			
	MessageInfo<Integer> changeStatus(Integer id,Byte status,String operatorId);
		
	MessageInfo<SignetApplyFileInfo> getSignetApplyFile( Integer id );
		
    MessageInfo<List<SignetApplyFileInfo>> getAllSignetApplyFile();
			
    MessageInfo<QueryResultInfo<SignetApplyFileInfo>> querySignetApplyFile(SignetApplyFileQueryInfo signetApplyFileQueryInfo);
	
	

}