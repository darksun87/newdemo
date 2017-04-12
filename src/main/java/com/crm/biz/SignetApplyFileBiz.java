package com.crm.biz;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.log4j.Logger;
import com.crm.data.MapperFactory;

import com.crm.dao.SignetApplyFileMapper;

import com.crm.model.Message;
import com.crm.model.dict.MessageStatus;
import com.crm.model.QueryResult;
import com.crm.model.SignetApplyFile;
import com.crm.model.SignetApplyFileQuery;
import static com.crm.biz.util.ValidationUtil.*;

@Service("signetApplyFileBiz")
public class SignetApplyFileBiz {


	private static final Logger LOGGER = Logger.getLogger(SignetApplyFileBiz.class);

	@Resource
	private MapperFactory mapperFactory;
	
		public Message<Integer> deleteSignetApplyFile(Integer id,String operatorId){
		Message<Integer> message = new Message<Integer>();
		try {
			SignetApplyFileMapper signetApplyFileMapper  = mapperFactory.getMapperForMaster(SignetApplyFileMapper.class);
			int result = signetApplyFileMapper.logicalDeleteByPrimaryKey(id,operatorId,System.currentTimeMillis());
			
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete,删除SignetApplyFile失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;		
	}
		

    public Message<Integer> createSignetApplyFile(SignetApplyFile signetApplyFile){
		Message<Integer> message = new Message<Integer>();
		if (!validateForCreate( signetApplyFile, message)) {
			return message;
		}
		try {
			mapperFactory.beginTransaction();
			SignetApplyFileMapper signetApplyFileMapper = mapperFactory.getMapperForMaster(SignetApplyFileMapper.class);
									signetApplyFile.setCreateTime(System.currentTimeMillis());			signetApplyFileMapper.insert( signetApplyFile );
			mapperFactory.commitTransaction();
			message.setData(signetApplyFile.getId());

		} catch (Exception e) {
			LOGGER.error("createSignetApplyFile,创建SignetApplyFile失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;	
	}
	private boolean validateForCreate(SignetApplyFile signetApplyFile, Message<?> message) {
								    		        		        				
        		if (isNull(message,SignetApplyFile.SIGNET_APPLYID, signetApplyFile.getSignetApplyid())) {
        			return false;
        		}
        		    								    		        		    								    		        		    																																return true;
	}
	public Message<Integer> updateSignetApplyFile(SignetApplyFile signetApplyFile){
		Message<Integer> message = new Message<Integer>();
		if (!validateForUpdate(signetApplyFile, message)) {
            return message;
        }
		try {
			SignetApplyFileMapper signetApplyFileMapper = mapperFactory.getMapperForMaster(SignetApplyFileMapper.class);
			mapperFactory.beginTransaction();
			
			SignetApplyFile signetApplyFileLast = signetApplyFileMapper.selectByPrimaryKeyForUpdate( signetApplyFile.getId() );
			if( signetApplyFileLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}
			
									signetApplyFile.setUpdateTime(System.currentTimeMillis());			int result = signetApplyFileMapper.updateByPrimaryKey( signetApplyFile );
			mapperFactory.commitTransaction();
			message.setData(result);
			
		} catch (Exception e) {
			LOGGER.error("updateSignetApplyFile,更新SignetApplyFile失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;	
	}
	private boolean validateForUpdate(SignetApplyFile signetApplyFile, Message<?> message) {
       				if (isNull(message,SignetApplyFile.ID, signetApplyFile.getId())) {
			return false;
		}
			   			   			   			   			   			   			   			   			   			   		return true;
    }
		public Message<Integer> changeStatus(Integer id,Byte status,String operatorId){
		Message<Integer> message = new Message<Integer>();
		try {
			
			SignetApplyFileMapper signetApplyFileMapper = mapperFactory.getMapperForMaster(SignetApplyFileMapper.class);
			mapperFactory.beginTransaction();
			SignetApplyFile signetApplyFileLast = signetApplyFileMapper.selectByPrimaryKeyForUpdate(id );
			if( signetApplyFileLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}
			
			//TODO：其他判断
			
			int result = signetApplyFileMapper.changeStatus(id,status,operatorId,System.currentTimeMillis());
			mapperFactory.commitTransaction();
			message.setData(result);
			
		} catch (Exception e) {
			LOGGER.error("changeStatus,更新SignetApplyFile状态失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;
	}
		public Message<SignetApplyFile> getSignetApplyFile( Integer id ){
		Message<SignetApplyFile> message = new Message<SignetApplyFile>();
		try {
			SignetApplyFileMapper signetApplyFileMapper = mapperFactory.getMapperForSlave(SignetApplyFileMapper.class);
			SignetApplyFile signetApplyFile = signetApplyFileMapper.selectByPrimaryKey( id );
			message.setData(signetApplyFile);

		} catch (Exception e) {
			LOGGER.error("getSignetApplyFile,根据主键查询SignetApplyFile失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<SignetApplyFile>> getAllSignetApplyFile(){
	
		Message<List<SignetApplyFile>> message = new Message<List<SignetApplyFile>>();
		try {
			SignetApplyFileMapper signetApplyFileMapper = mapperFactory.getMapperForSlave(SignetApplyFileMapper.class);
				
			List<SignetApplyFile> signetApplyFileList = signetApplyFileMapper.selectAll();
			message.setData( signetApplyFileList);
		} catch (Exception e) {
			LOGGER.error("getAllSignetApplyFile,查询全部SignetApplyFile失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;	
	}
	
	public Message<QueryResult<SignetApplyFile>> querySignetApplyFile(SignetApplyFileQuery signetApplyFileQuery) {
		Message<QueryResult<SignetApplyFile>> message = new Message<QueryResult<SignetApplyFile>>();
		try {
			SignetApplyFileMapper signetApplyFileMapper = mapperFactory.getMapperForSlave(SignetApplyFileMapper.class);
			QueryResult<SignetApplyFile> queryResult = new QueryResult<SignetApplyFile>();
			PageHelper.startPage(signetApplyFileQuery.getPageIndex(), signetApplyFileQuery.getPageSize());
			List<SignetApplyFile> signetApplyFileList = signetApplyFileMapper.querySignetApplyFile(signetApplyFileQuery);
			PageInfo<SignetApplyFile> pageInfo = new PageInfo<SignetApplyFile>(signetApplyFileList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(signetApplyFileList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("querySignetApplyFile,分页查询SignetApplyFile失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
   
	

}