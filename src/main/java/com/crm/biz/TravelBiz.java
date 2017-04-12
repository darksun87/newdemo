package com.crm.biz;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.log4j.Logger;
import com.crm.data.MapperFactory;

import com.crm.dao.TravelMapper;

import com.crm.model.Message;
import com.crm.model.dict.MessageStatus;
import com.crm.model.QueryResult;
import com.crm.model.Travel;
import com.crm.model.TravelQuery;
import static com.crm.biz.util.ValidationUtil.*;

@Service("travelBiz")
public class TravelBiz {


	private static final Logger LOGGER = Logger.getLogger(TravelBiz.class);

	@Resource
	private MapperFactory mapperFactory;
	
		public Message<Integer> deleteTravel(Integer id,String operatorId){
		Message<Integer> message = new Message<Integer>();
		try {
			TravelMapper travelMapper  = mapperFactory.getMapperForMaster(TravelMapper.class);
			int result = travelMapper.logicalDeleteByPrimaryKey(id,operatorId,System.currentTimeMillis());
			
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete,删除Travel失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;		
	}
		

    public Message<Integer> createTravel(Travel travel){
		Message<Integer> message = new Message<Integer>();
		if (!validateForCreate( travel, message)) {
			return message;
		}
		try {
			mapperFactory.beginTransaction();
			TravelMapper travelMapper = mapperFactory.getMapperForMaster(TravelMapper.class);
									travel.setCreateTime(System.currentTimeMillis());			travelMapper.insert( travel );
			mapperFactory.commitTransaction();
			message.setData(travel.getId());

		} catch (Exception e) {
			LOGGER.error("createTravel,创建Travel失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;	
	}
	private boolean validateForCreate(Travel travel, Message<?> message) {
								    		        		        		
        		if (isMoreThan(message, Travel.REASON, travel.getReason(), 100)) {
        			return false;
        		}	
        		    								    		        		        		
        		if (isMoreThan(message, Travel.DESTATION, travel.getDestation(), 20)) {
        			return false;
        		}	
        		    								    		        		    								    		        		    								    		        		    								    		        		    								    		        		    								    		        		    								    		        		        		
        		if (isMoreThan(message, Travel.GM_RESULT, travel.getGmResult(), 10)) {
        			return false;
        		}	
        		    								    		        		        		
        		if (isMoreThan(message, Travel.GM_SUGGEST, travel.getGmSuggest(), 100)) {
        			return false;
        		}	
        		    																																return true;
	}
	public Message<Integer> updateTravel(Travel travel){
		Message<Integer> message = new Message<Integer>();
		if (!validateForUpdate(travel, message)) {
            return message;
        }
		try {
			TravelMapper travelMapper = mapperFactory.getMapperForMaster(TravelMapper.class);
			mapperFactory.beginTransaction();
			
			Travel travelLast = travelMapper.selectByPrimaryKeyForUpdate( travel.getId() );
			if( travelLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}
			
									travel.setUpdateTime(System.currentTimeMillis());			int result = travelMapper.updateByPrimaryKey( travel );
			mapperFactory.commitTransaction();
			message.setData(result);
			
		} catch (Exception e) {
			LOGGER.error("updateTravel,更新Travel失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;	
	}
	private boolean validateForUpdate(Travel travel, Message<?> message) {
       				if (isNull(message,Travel.ID, travel.getId())) {
			return false;
		}
			   				if (isMoreThan(message, Travel.REASON, travel.getReason(), 100)) {
			return false;
		}	
			   				if (isMoreThan(message, Travel.DESTATION, travel.getDestation(), 20)) {
			return false;
		}	
			   			   			   			   			   			   			   				if (isMoreThan(message, Travel.GM_RESULT, travel.getGmResult(), 10)) {
			return false;
		}	
			   				if (isMoreThan(message, Travel.GM_SUGGEST, travel.getGmSuggest(), 100)) {
			return false;
		}	
			   			   			   			   			   			   			   		return true;
    }
		public Message<Integer> changeStatus(Integer id,Byte status,String operatorId){
		Message<Integer> message = new Message<Integer>();
		try {
			
			TravelMapper travelMapper = mapperFactory.getMapperForMaster(TravelMapper.class);
			mapperFactory.beginTransaction();
			Travel travelLast = travelMapper.selectByPrimaryKeyForUpdate(id );
			if( travelLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}
			
			//TODO：其他判断
			
			int result = travelMapper.changeStatus(id,status,operatorId,System.currentTimeMillis());
			mapperFactory.commitTransaction();
			message.setData(result);
			
		} catch (Exception e) {
			LOGGER.error("changeStatus,更新Travel状态失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;
	}
		public Message<Travel> getTravel( Integer id ){
		Message<Travel> message = new Message<Travel>();
		try {
			TravelMapper travelMapper = mapperFactory.getMapperForSlave(TravelMapper.class);
			Travel travel = travelMapper.selectByPrimaryKey( id );
			message.setData(travel);

		} catch (Exception e) {
			LOGGER.error("getTravel,根据主键查询Travel失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<Travel>> getAllTravel(){
	
		Message<List<Travel>> message = new Message<List<Travel>>();
		try {
			TravelMapper travelMapper = mapperFactory.getMapperForSlave(TravelMapper.class);
				
			List<Travel> travelList = travelMapper.selectAll();
			message.setData( travelList);
		} catch (Exception e) {
			LOGGER.error("getAllTravel,查询全部Travel失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;	
	}
	
	public Message<QueryResult<Travel>> queryTravel(TravelQuery travelQuery) {
		Message<QueryResult<Travel>> message = new Message<QueryResult<Travel>>();
		try {
			TravelMapper travelMapper = mapperFactory.getMapperForSlave(TravelMapper.class);
			QueryResult<Travel> queryResult = new QueryResult<Travel>();
			PageHelper.startPage(travelQuery.getPageIndex(), travelQuery.getPageSize());
			List<Travel> travelList = travelMapper.queryTravel(travelQuery);
			PageInfo<Travel> pageInfo = new PageInfo<Travel>(travelList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(travelList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryTravel,分页查询Travel失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
   
	

}