package com.crm.biz;

import static com.crm.biz.util.ValidationUtil.isMoreThan;
import static com.crm.biz.util.ValidationUtil.isNull;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.crm.dao.AutocodeMapper;
import com.crm.data.MapperFactory;
import com.crm.model.Autocode;
import com.crm.model.AutocodeQuery;
import com.crm.model.Message;
import com.crm.model.QueryResult;
import com.crm.model.dict.MessageStatus;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("autocodeBiz")
public class AutocodeBiz {


	private static final Logger LOGGER = Logger.getLogger(AutocodeBiz.class);

	@Resource
	private MapperFactory mapperFactory;
	
		
	public Message<Integer> deleteAutocode(Integer id){
		Message<Integer> message = new Message<Integer>();
		try {
		
			AutocodeMapper autocodeMapper = mapperFactory.getMapperForMaster(AutocodeMapper.class);
			int result = autocodeMapper.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete,删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;		
	}
		

    public Message<Integer> createAutocode(Autocode autocode){
		Message<Integer> message = new Message<Integer>();
		if (!validateForCreate( autocode, message)) {
			return message;
		}
		try {
			mapperFactory.beginTransaction();
			AutocodeMapper autocodeMapper = mapperFactory.getMapperForMaster(AutocodeMapper.class);
									autocode.setCreateTime(System.currentTimeMillis());			autocodeMapper.insert( autocode );
			mapperFactory.commitTransaction();
			message.setData(autocode.getId());

		} catch (Exception e) {
			LOGGER.error("createAutocode,创建Autocode失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;	
	}
	private boolean validateForCreate(Autocode autocode, Message<?> message) {
								    		        		        		
        		if (isMoreThan(message, Autocode.NAME, autocode.getName(), 64)) {
        			return false;
        		}	
        		    								    		        		        		
        		if (isMoreThan(message, Autocode.PASSWORD, autocode.getPassword(), 128)) {
        			return false;
        		}	
        		    																												    		        		    								return true;
	}
	public Message<Integer> updateAutocode(Autocode autocode){
		Message<Integer> message = new Message<Integer>();
		if (!validateForUpdate(autocode, message)) {
            return message;
        }
		try {
			AutocodeMapper autocodeMapper = mapperFactory.getMapperForMaster(AutocodeMapper.class);
			mapperFactory.beginTransaction();
			
			Autocode autocodeLast = autocodeMapper.selectByPrimaryKeyForUpdate( autocode.getId() );
			if( autocodeLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}
			
									autocode.setUpdateTime(System.currentTimeMillis());			int result = autocodeMapper.updateByPrimaryKey( autocode );
			mapperFactory.commitTransaction();
			message.setData(result);
			
		} catch (Exception e) {
			LOGGER.error("updateAutocode,更新Autocode失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;	
	}
	private boolean validateForUpdate(Autocode autocode, Message<?> message) {
       				if (isNull(message,Autocode.ID, autocode.getId())) {
			return false;
		}
			   				if (isMoreThan(message, Autocode.NAME, autocode.getName(), 64)) {
			return false;
		}	
			   				if (isMoreThan(message, Autocode.PASSWORD, autocode.getPassword(), 128)) {
			return false;
		}	
			   			   			   			   			   			   			   		return true;
    }
		public Message<Integer> changeStatus(Integer id,Boolean status,String operatorId){
		Message<Integer> message = new Message<Integer>();
		try {
			
			AutocodeMapper autocodeMapper = mapperFactory.getMapperForMaster(AutocodeMapper.class);
			mapperFactory.beginTransaction();
			Autocode autocodeLast = autocodeMapper.selectByPrimaryKeyForUpdate(id );
			if( autocodeLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}
			
			//TODO：其他判断
			
			int result = autocodeMapper.changeStatus(id,status,operatorId,System.currentTimeMillis());
			mapperFactory.commitTransaction();
			message.setData(result);
			
		} catch (Exception e) {
			LOGGER.error("changeStatus,更新Autocode状态失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;
	}
		public Message<Autocode> getAutocode( Integer id ){
		Message<Autocode> message = new Message<Autocode>();
		try {
			AutocodeMapper autocodeMapper = mapperFactory.getMapperForSlave(AutocodeMapper.class);
			Autocode autocode = autocodeMapper.selectByPrimaryKey( id );
			message.setData(autocode);

		} catch (Exception e) {
			LOGGER.error("getAutocode,根据主键查询Autocode失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<Autocode>> getAllAutocode(){
	
		Message<List<Autocode>> message = new Message<List<Autocode>>();
		try {
			AutocodeMapper autocodeMapper = mapperFactory.getMapperForSlave(AutocodeMapper.class);
				
			List<Autocode> autocodeList = autocodeMapper.selectAll();
			message.setData( autocodeList);
		} catch (Exception e) {
			LOGGER.error("getAllAutocode,查询全部Autocode失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;	
	}
	
	public Message<QueryResult<Autocode>> queryAutocode(AutocodeQuery autocodeQuery) {
		Message<QueryResult<Autocode>> message = new Message<QueryResult<Autocode>>();
		try {
			AutocodeMapper autocodeMapper = mapperFactory.getMapperForMaster(AutocodeMapper.class);
			QueryResult<Autocode> queryResult = new QueryResult<Autocode>();
			PageHelper.startPage(autocodeQuery.getPageIndex(), autocodeQuery.getPageSize());
			List<Autocode> autocodeList = autocodeMapper.queryAutocode(autocodeQuery);
			PageInfo<Autocode> pageInfo = new PageInfo<Autocode>(autocodeList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(autocodeList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryAutocode,分页查询Autocode失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
   
	

}