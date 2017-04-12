package com.crm.biz;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.log4j.Logger;
import com.crm.data.MapperFactory;

import com.crm.dao.LogMapper;

import com.crm.model.Message;
import com.crm.model.dict.MessageStatus;
import com.crm.model.QueryResult;
import com.crm.model.Log;
import com.crm.model.LogQuery;
import static com.crm.biz.util.ValidationUtil.*;

@Service("logBiz")
public class LogBiz {


	private static final Logger LOGGER = Logger.getLogger(LogBiz.class);

	@Resource
	private MapperFactory mapperFactory;
	
		public Message<Integer> deleteLog(Integer id,String operatorId){
		Message<Integer> message = new Message<Integer>();
		try {
			LogMapper logMapper  = mapperFactory.getMapperForMaster(LogMapper.class);
			int result = logMapper.logicalDeleteByPrimaryKey(id,operatorId,System.currentTimeMillis());
			
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete,删除Log失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;		
	}
		

    public Message<Integer> createLog(Log log){
		Message<Integer> message = new Message<Integer>();
		if (!validateForCreate( log, message)) {
			return message;
		}
		try {
			mapperFactory.beginTransaction();
			LogMapper logMapper = mapperFactory.getMapperForMaster(LogMapper.class);
									log.setCreateTime(System.currentTimeMillis());			logMapper.insert( log );
			mapperFactory.commitTransaction();
			message.setData(log.getId());

		} catch (Exception e) {
			LOGGER.error("createLog,创建Log失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;	
	}
	private boolean validateForCreate(Log log, Message<?> message) {
								    		        		        		
        		if (isMoreThan(message, Log.MODULE, log.getModule(), 100)) {
        			return false;
        		}	
        		    								    		        		        		
        		if (isMoreThan(message, Log.LOGCONTENT, log.getLogcontent(), 255)) {
        			return false;
        		}	
        		    								    		        		        		
        		if (isMoreThan(message, Log.RESULT, log.getResult(), 100)) {
        			return false;
        		}	
        		    																																return true;
	}
	public Message<Integer> updateLog(Log log){
		Message<Integer> message = new Message<Integer>();
		if (!validateForUpdate(log, message)) {
            return message;
        }
		try {
			LogMapper logMapper = mapperFactory.getMapperForMaster(LogMapper.class);
			mapperFactory.beginTransaction();
			
			Log logLast = logMapper.selectByPrimaryKeyForUpdate( log.getId() );
			if( logLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}
			
									log.setUpdateTime(System.currentTimeMillis());			int result = logMapper.updateByPrimaryKey( log );
			mapperFactory.commitTransaction();
			message.setData(result);
			
		} catch (Exception e) {
			LOGGER.error("updateLog,更新Log失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;	
	}
	private boolean validateForUpdate(Log log, Message<?> message) {
       				if (isNull(message,Log.ID, log.getId())) {
			return false;
		}
			   				if (isMoreThan(message, Log.MODULE, log.getModule(), 100)) {
			return false;
		}	
			   				if (isMoreThan(message, Log.LOGCONTENT, log.getLogcontent(), 255)) {
			return false;
		}	
			   				if (isMoreThan(message, Log.RESULT, log.getResult(), 100)) {
			return false;
		}	
			   			   			   			   			   			   			   		return true;
    }
		public Message<Integer> changeStatus(Integer id,Byte status,String operatorId){
		Message<Integer> message = new Message<Integer>();
		try {
			
			LogMapper logMapper = mapperFactory.getMapperForMaster(LogMapper.class);
			mapperFactory.beginTransaction();
			Log logLast = logMapper.selectByPrimaryKeyForUpdate(id );
			if( logLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}
			
			//TODO：其他判断
			
			int result = logMapper.changeStatus(id,status,operatorId,System.currentTimeMillis());
			mapperFactory.commitTransaction();
			message.setData(result);
			
		} catch (Exception e) {
			LOGGER.error("changeStatus,更新Log状态失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;
	}
		public Message<Log> getLog( Integer id ){
		Message<Log> message = new Message<Log>();
		try {
			LogMapper logMapper = mapperFactory.getMapperForSlave(LogMapper.class);
			Log log = logMapper.selectByPrimaryKey( id );
			message.setData(log);

		} catch (Exception e) {
			LOGGER.error("getLog,根据主键查询Log失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<Log>> getAllLog(){
	
		Message<List<Log>> message = new Message<List<Log>>();
		try {
			LogMapper logMapper = mapperFactory.getMapperForSlave(LogMapper.class);
				
			List<Log> logList = logMapper.selectAll();
			message.setData( logList);
		} catch (Exception e) {
			LOGGER.error("getAllLog,查询全部Log失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;	
	}
	
	public Message<QueryResult<Log>> queryLog(LogQuery logQuery) {
		Message<QueryResult<Log>> message = new Message<QueryResult<Log>>();
		try {
			LogMapper logMapper = mapperFactory.getMapperForSlave(LogMapper.class);
			QueryResult<Log> queryResult = new QueryResult<Log>();
			PageHelper.startPage(logQuery.getPageIndex(), logQuery.getPageSize());
			List<Log> logList = logMapper.queryLog(logQuery);
			PageInfo<Log> pageInfo = new PageInfo<Log>(logList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(logList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryLog,分页查询Log失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
   
	

}