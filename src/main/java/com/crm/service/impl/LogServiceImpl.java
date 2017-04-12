
package com.crm.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.crm.biz.LogBiz;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.LogInfo;
import com.crm.message.LogQueryInfo;


import com.crm.model.Message;
import com.crm.model.QueryResult;
import com.crm.model.Log;
import com.crm.model.LogQuery;


import com.crm.service.LogService;
import com.crm.service.convertor.LogConvertor;
import com.crm.service.convertor.MessageConvertor;

@Service("logService")
public class LogServiceImpl implements LogService {

	@Resource
	private LogBiz logBiz;
			
	public MessageInfo<Integer> deleteLog(Integer id,String operatorId){
		
		Message<Integer> message  = logBiz.deleteLog(id,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Integer> createLog(LogInfo logInfo){
		
		Log log = LogConvertor.toLog(logInfo);
		Message<Integer> message  =  logBiz.createLog( log );
		MessageInfo<Integer> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateLog(LogInfo logInfo){
		
		Log log = LogConvertor.toLog(logInfo);
		Message<Integer> message  =  logBiz.updateLog( log );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<Integer> changeStatus(
			Integer id,
			Byte status,
			String operatorId){
			
		Message<Integer> message  = logBiz.changeStatus(id,status,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<LogInfo> getLog( Integer id ){
		
		Message<Log> message  = logBiz.getLog( id );
		MessageInfo<LogInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		LogInfo logInfo = LogConvertor.toLogInfo(message.getData());
		messageInfo.setData(logInfo);
		return messageInfo;
	}

    public MessageInfo<List<LogInfo>> getAllLog(){
	
		Message<List<Log>> message  = logBiz.getAllLog();
		MessageInfo<List<LogInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<LogInfo> logInfoList = LogConvertor.toLogInfoList(message.getData());
		messageInfo.setData(logInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<LogInfo>> queryLog(LogQueryInfo logQueryInfo) {
		LogQuery logQuery = LogConvertor.toLogQuery(logQueryInfo);
		Message<QueryResult<Log>> message = logBiz.queryLog(logQuery);
		MessageInfo<QueryResultInfo<LogInfo>> messageInfo = new MessageInfo<QueryResultInfo<LogInfo>>();
		QueryResultInfo<LogInfo> queryResultInfo = LogConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}