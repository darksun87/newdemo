package com.crm.biz;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.log4j.Logger;
import com.crm.data.MapperFactory;

import com.crm.dao.SignetMapper;

import com.crm.model.Message;
import com.crm.model.dict.MessageStatus;
import com.crm.model.QueryResult;
import com.crm.model.Signet;
import com.crm.model.SignetQuery;
import static com.crm.biz.util.ValidationUtil.*;

@Service("signetBiz")
public class SignetBiz {


	private static final Logger LOGGER = Logger.getLogger(SignetBiz.class);

	@Resource
	private MapperFactory mapperFactory;
	
		public Message<Integer> deleteSignet(Integer id,String operatorId){
		Message<Integer> message = new Message<Integer>();
		try {
			SignetMapper signetMapper  = mapperFactory.getMapperForMaster(SignetMapper.class);
			int result = signetMapper.logicalDeleteByPrimaryKey(id,operatorId,System.currentTimeMillis());
			
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete,删除Signet失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;		
	}
		

    public Message<Integer> createSignet(Signet signet){
		Message<Integer> message = new Message<Integer>();
		if (!validateForCreate( signet, message)) {
			return message;
		}
		try {
			mapperFactory.beginTransaction();
			SignetMapper signetMapper = mapperFactory.getMapperForMaster(SignetMapper.class);
									signet.setCreateTime(System.currentTimeMillis());			signetMapper.insert( signet );
			mapperFactory.commitTransaction();
			message.setData(signet.getId());

		} catch (Exception e) {
			LOGGER.error("createSignet,创建Signet失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;	
	}
	private boolean validateForCreate(Signet signet, Message<?> message) {
								    		        		        		
        		if (isMoreThan(message, Signet.SIGNETNAME, signet.getSignetname(), 100)) {
        			return false;
        		}	
        		    																																return true;
	}
	public Message<Integer> updateSignet(Signet signet){
		Message<Integer> message = new Message<Integer>();
		if (!validateForUpdate(signet, message)) {
            return message;
        }
		try {
			SignetMapper signetMapper = mapperFactory.getMapperForMaster(SignetMapper.class);
			mapperFactory.beginTransaction();
			
			Signet signetLast = signetMapper.selectByPrimaryKeyForUpdate( signet.getId() );
			if( signetLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}
			
									signet.setUpdateTime(System.currentTimeMillis());			int result = signetMapper.updateByPrimaryKey( signet );
			mapperFactory.commitTransaction();
			message.setData(result);
			
		} catch (Exception e) {
			LOGGER.error("updateSignet,更新Signet失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;	
	}
	private boolean validateForUpdate(Signet signet, Message<?> message) {
       				if (isNull(message,Signet.ID, signet.getId())) {
			return false;
		}
			   				if (isMoreThan(message, Signet.SIGNETNAME, signet.getSignetname(), 100)) {
			return false;
		}	
			   			   			   			   			   			   			   		return true;
    }
		public Message<Integer> changeStatus(Integer id,Byte status,String operatorId){
		Message<Integer> message = new Message<Integer>();
		try {
			
			SignetMapper signetMapper = mapperFactory.getMapperForMaster(SignetMapper.class);
			mapperFactory.beginTransaction();
			Signet signetLast = signetMapper.selectByPrimaryKeyForUpdate(id );
			if( signetLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}
			
			//TODO：其他判断
			
			int result = signetMapper.changeStatus(id,status,operatorId,System.currentTimeMillis());
			mapperFactory.commitTransaction();
			message.setData(result);
			
		} catch (Exception e) {
			LOGGER.error("changeStatus,更新Signet状态失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;
	}
		public Message<Signet> getSignet( Integer id ){
		Message<Signet> message = new Message<Signet>();
		try {
			SignetMapper signetMapper = mapperFactory.getMapperForSlave(SignetMapper.class);
			Signet signet = signetMapper.selectByPrimaryKey( id );
			message.setData(signet);

		} catch (Exception e) {
			LOGGER.error("getSignet,根据主键查询Signet失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<Signet>> getAllSignet(){
	
		Message<List<Signet>> message = new Message<List<Signet>>();
		try {
			SignetMapper signetMapper = mapperFactory.getMapperForSlave(SignetMapper.class);
				
			List<Signet> signetList = signetMapper.selectAll();
			message.setData( signetList);
		} catch (Exception e) {
			LOGGER.error("getAllSignet,查询全部Signet失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;	
	}
	
	public Message<QueryResult<Signet>> querySignet(SignetQuery signetQuery) {
		Message<QueryResult<Signet>> message = new Message<QueryResult<Signet>>();
		try {
			SignetMapper signetMapper = mapperFactory.getMapperForSlave(SignetMapper.class);
			QueryResult<Signet> queryResult = new QueryResult<Signet>();
			PageHelper.startPage(signetQuery.getPageIndex(), signetQuery.getPageSize());
			List<Signet> signetList = signetMapper.querySignet(signetQuery);
			PageInfo<Signet> pageInfo = new PageInfo<Signet>(signetList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(signetList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("querySignet,分页查询Signet失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
   
	

}