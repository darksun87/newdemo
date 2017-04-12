package com.crm.biz;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.log4j.Logger;
import com.crm.data.MapperFactory;

import com.crm.dao.SignetApplyMapper;

import com.crm.model.Message;
import com.crm.model.dict.MessageStatus;
import com.crm.model.QueryResult;
import com.crm.model.SignetApply;
import com.crm.model.SignetApplyQuery;
import static com.crm.biz.util.ValidationUtil.*;

@Service("signetApplyBiz")
public class SignetApplyBiz {


	private static final Logger LOGGER = Logger.getLogger(SignetApplyBiz.class);

	@Resource
	private MapperFactory mapperFactory;
	
		public Message<Integer> deleteSignetApply(Integer id,String operatorId){
		Message<Integer> message = new Message<Integer>();
		try {
			SignetApplyMapper signetApplyMapper  = mapperFactory.getMapperForMaster(SignetApplyMapper.class);
			int result = signetApplyMapper.logicalDeleteByPrimaryKey(id,operatorId,System.currentTimeMillis());
			
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete,删除SignetApply失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;		
	}
		

    public Message<Integer> createSignetApply(SignetApply signetApply){
		Message<Integer> message = new Message<Integer>();
		if (!validateForCreate( signetApply, message)) {
			return message;
		}
		try {
			mapperFactory.beginTransaction();
			SignetApplyMapper signetApplyMapper = mapperFactory.getMapperForMaster(SignetApplyMapper.class);
									signetApply.setCreateTime(System.currentTimeMillis());			signetApplyMapper.insert( signetApply );
			mapperFactory.commitTransaction();
			message.setData(signetApply.getId());

		} catch (Exception e) {
			LOGGER.error("createSignetApply,创建SignetApply失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;	
	}
	private boolean validateForCreate(SignetApply signetApply, Message<?> message) {
								    		        		        		
        		if (isMoreThan(message, SignetApply.APPLYREASON, signetApply.getApplyreason(), 100)) {
        			return false;
        		}	
        		    								    		        		        				
        		if (isNull(message,SignetApply.SIGNETID, signetApply.getSignetid())) {
        			return false;
        		}
        		    								    		        		    								    		        		        		
        		if (isMoreThan(message, SignetApply.DGM_RESULT, signetApply.getDgmResult(), 10)) {
        			return false;
        		}	
        		    								    		        		        		
        		if (isMoreThan(message, SignetApply.DGM_SUGGEST, signetApply.getDgmSuggest(), 100)) {
        			return false;
        		}	
        		    								    		        		    								    		        		        		
        		if (isMoreThan(message, SignetApply.GM_RESULT, signetApply.getGmResult(), 10)) {
        			return false;
        		}	
        		    								    		        		        		
        		if (isMoreThan(message, SignetApply.GM_SUGGEST, signetApply.getGmSuggest(), 100)) {
        			return false;
        		}	
        		    																																return true;
	}
	public Message<Integer> updateSignetApply(SignetApply signetApply){
		Message<Integer> message = new Message<Integer>();
		if (!validateForUpdate(signetApply, message)) {
            return message;
        }
		try {
			SignetApplyMapper signetApplyMapper = mapperFactory.getMapperForMaster(SignetApplyMapper.class);
			mapperFactory.beginTransaction();
			
			SignetApply signetApplyLast = signetApplyMapper.selectByPrimaryKeyForUpdate( signetApply.getId() );
			if( signetApplyLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}
			
									signetApply.setUpdateTime(System.currentTimeMillis());			int result = signetApplyMapper.updateByPrimaryKey( signetApply );
			mapperFactory.commitTransaction();
			message.setData(result);
			
		} catch (Exception e) {
			LOGGER.error("updateSignetApply,更新SignetApply失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;	
	}
	private boolean validateForUpdate(SignetApply signetApply, Message<?> message) {
       				if (isNull(message,SignetApply.ID, signetApply.getId())) {
			return false;
		}
			   				if (isMoreThan(message, SignetApply.APPLYREASON, signetApply.getApplyreason(), 100)) {
			return false;
		}	
			   			   			   				if (isMoreThan(message, SignetApply.DGM_RESULT, signetApply.getDgmResult(), 10)) {
			return false;
		}	
			   				if (isMoreThan(message, SignetApply.DGM_SUGGEST, signetApply.getDgmSuggest(), 100)) {
			return false;
		}	
			   			   				if (isMoreThan(message, SignetApply.GM_RESULT, signetApply.getGmResult(), 10)) {
			return false;
		}	
			   				if (isMoreThan(message, SignetApply.GM_SUGGEST, signetApply.getGmSuggest(), 100)) {
			return false;
		}	
			   			   			   			   			   			   			   		return true;
    }
		public Message<Integer> changeStatus(Integer id,Byte status,String operatorId){
		Message<Integer> message = new Message<Integer>();
		try {
			
			SignetApplyMapper signetApplyMapper = mapperFactory.getMapperForMaster(SignetApplyMapper.class);
			mapperFactory.beginTransaction();
			SignetApply signetApplyLast = signetApplyMapper.selectByPrimaryKeyForUpdate(id );
			if( signetApplyLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}
			
			//TODO：其他判断
			
			int result = signetApplyMapper.changeStatus(id,status,operatorId,System.currentTimeMillis());
			mapperFactory.commitTransaction();
			message.setData(result);
			
		} catch (Exception e) {
			LOGGER.error("changeStatus,更新SignetApply状态失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;
	}
		public Message<SignetApply> getSignetApply( Integer id ){
		Message<SignetApply> message = new Message<SignetApply>();
		try {
			SignetApplyMapper signetApplyMapper = mapperFactory.getMapperForSlave(SignetApplyMapper.class);
			SignetApply signetApply = signetApplyMapper.selectByPrimaryKey( id );
			message.setData(signetApply);

		} catch (Exception e) {
			LOGGER.error("getSignetApply,根据主键查询SignetApply失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<SignetApply>> getAllSignetApply(){
	
		Message<List<SignetApply>> message = new Message<List<SignetApply>>();
		try {
			SignetApplyMapper signetApplyMapper = mapperFactory.getMapperForSlave(SignetApplyMapper.class);
				
			List<SignetApply> signetApplyList = signetApplyMapper.selectAll();
			message.setData( signetApplyList);
		} catch (Exception e) {
			LOGGER.error("getAllSignetApply,查询全部SignetApply失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;	
	}
	
	public Message<QueryResult<SignetApply>> querySignetApply(SignetApplyQuery signetApplyQuery) {
		Message<QueryResult<SignetApply>> message = new Message<QueryResult<SignetApply>>();
		try {
			SignetApplyMapper signetApplyMapper = mapperFactory.getMapperForSlave(SignetApplyMapper.class);
			QueryResult<SignetApply> queryResult = new QueryResult<SignetApply>();
			PageHelper.startPage(signetApplyQuery.getPageIndex(), signetApplyQuery.getPageSize());
			List<SignetApply> signetApplyList = signetApplyMapper.querySignetApply(signetApplyQuery);
			PageInfo<SignetApply> pageInfo = new PageInfo<SignetApply>(signetApplyList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(signetApplyList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("querySignetApply,分页查询SignetApply失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
   
	

}