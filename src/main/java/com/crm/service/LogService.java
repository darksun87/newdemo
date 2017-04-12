package com.crm.service;


import java.util.List;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.LogInfo;
import com.crm.message.LogQueryInfo;

public interface LogService {
		
	MessageInfo<Integer> deleteLog(Integer id,String operatorId);
		
    MessageInfo<Integer> createLog(LogInfo logInfo);
		
	MessageInfo<Integer> updateLog(LogInfo logInfo);
			
	MessageInfo<Integer> changeStatus(Integer id,Byte status,String operatorId);
		
	MessageInfo<LogInfo> getLog( Integer id );
		
    MessageInfo<List<LogInfo>> getAllLog();
			
    MessageInfo<QueryResultInfo<LogInfo>> queryLog(LogQueryInfo logQueryInfo);
	
	

}