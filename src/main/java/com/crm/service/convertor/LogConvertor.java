package com.crm.service.convertor;
import java.util.ArrayList;
import java.util.List;

import org.springframework.cglib.beans.BeanCopier;

import com.crm.message.LogInfo;
import com.crm.message.LogQueryInfo;
import com.crm.message.QueryResultInfo;
import com.crm.model.Log;
import com.crm.model.LogQuery;
import com.crm.model.QueryResult;

public abstract class LogConvertor {

	private static final BeanCopier beanCopierForLogInfo = BeanCopier.create(Log.class, LogInfo.class, false);
	private static final BeanCopier beanCopierForLog = BeanCopier.create(LogInfo.class, Log.class, false);
	private static final BeanCopier beanCopierForLogQuery = BeanCopier.create(LogQueryInfo.class, LogQuery.class, false);

	public static LogInfo toLogInfo(Log log)
	{
		if (log == null) {
			return null;
		}
		LogInfo logInfo = new LogInfo();
		beanCopierForLogInfo.copy(log, logInfo, null);
		return logInfo;
	}

	public static Log toLog(LogInfo logInfo)
	{
		Log log = new Log();
		beanCopierForLog.copy(logInfo, log, null);
		return log;
	}

	public static List<LogInfo> toLogInfoList(List<Log> logList)
	{
		if (logList == null || logList.isEmpty()) {
			return null;
		}
		List<LogInfo> logInfoList = new ArrayList<LogInfo>(logList.size());
		for (Log log : logList) {
			logInfoList.add(toLogInfo(log));
		}
		return logInfoList;
	}

	public static List<Log> toLogList(List<LogInfo> logInfoList)
	{
		if (logInfoList == null || logInfoList.isEmpty()) {
			return null;
		}
		List<Log> logList = new ArrayList<Log>(logInfoList.size());
		for (LogInfo logInfo : logInfoList) {
			logList.add(toLog(logInfo));
		}
		return logList;
	}
	
	public static LogQuery toLogQuery(LogQueryInfo logQueryInfo)
	{
		if (logQueryInfo== null) {
			return null;
		}
		LogQuery logQuery = new LogQuery();
		beanCopierForLogQuery.copy(logQueryInfo, logQuery, null);
		return logQuery;
	}

	public static QueryResultInfo<LogInfo> toQueryResultInfo(QueryResult<Log> queryResult)
	{
		QueryResultInfo<LogInfo> queryResultInfo = new QueryResultInfo<LogInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toLogInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}