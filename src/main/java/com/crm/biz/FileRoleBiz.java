package com.crm.biz;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.log4j.Logger;
import com.crm.data.MapperFactory;

import com.crm.dao.FileRoleMapper;

import com.crm.model.Message;
import com.crm.model.dict.MessageStatus;
import com.crm.model.QueryResult;
import com.crm.model.FileRole;
import com.crm.model.FileRoleQuery;
import static com.crm.biz.util.ValidationUtil.*;

@Service("fileRoleBiz")
public class FileRoleBiz {


	private static final Logger LOGGER = Logger.getLogger(FileRoleBiz.class);

	@Resource
	private MapperFactory mapperFactory;
	
		public Message<Integer> deleteFileRole(Integer id,String operatorId){
		Message<Integer> message = new Message<Integer>();
		try {
			FileRoleMapper fileRoleMapper  = mapperFactory.getMapperForMaster(FileRoleMapper.class);
			int result = fileRoleMapper.logicalDeleteByPrimaryKey(id,operatorId,System.currentTimeMillis());
			
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete,删除FileRole失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;		
	}
		

    public Message<Integer> createFileRole(FileRole fileRole){
		Message<Integer> message = new Message<Integer>();
		if (!validateForCreate( fileRole, message)) {
			return message;
		}
		try {
			mapperFactory.beginTransaction();
			FileRoleMapper fileRoleMapper = mapperFactory.getMapperForMaster(FileRoleMapper.class);
									fileRole.setCreateTime(System.currentTimeMillis());			fileRoleMapper.insert( fileRole );
			mapperFactory.commitTransaction();
			message.setData(fileRole.getId());

		} catch (Exception e) {
			LOGGER.error("createFileRole,创建FileRole失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;	
	}
	private boolean validateForCreate(FileRole fileRole, Message<?> message) {
								    		        		        				
        		if (isNull(message,FileRole.FILE_ID, fileRole.getFileId())) {
        			return false;
        		}
        		    								    		        		        				
        		if (isNull(message,FileRole.ROLEID, fileRole.getRoleid())) {
        			return false;
        		}
        		    																																return true;
	}
	public Message<Integer> updateFileRole(FileRole fileRole){
		Message<Integer> message = new Message<Integer>();
		if (!validateForUpdate(fileRole, message)) {
            return message;
        }
		try {
			FileRoleMapper fileRoleMapper = mapperFactory.getMapperForMaster(FileRoleMapper.class);
			mapperFactory.beginTransaction();
			
			FileRole fileRoleLast = fileRoleMapper.selectByPrimaryKeyForUpdate( fileRole.getId() );
			if( fileRoleLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}
			
									fileRole.setUpdateTime(System.currentTimeMillis());			int result = fileRoleMapper.updateByPrimaryKey( fileRole );
			mapperFactory.commitTransaction();
			message.setData(result);
			
		} catch (Exception e) {
			LOGGER.error("updateFileRole,更新FileRole失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;	
	}
	private boolean validateForUpdate(FileRole fileRole, Message<?> message) {
       				if (isNull(message,FileRole.ID, fileRole.getId())) {
			return false;
		}
			   			   			   			   			   			   			   			   			   		return true;
    }
		public Message<Integer> changeStatus(Integer id,Byte status,String operatorId){
		Message<Integer> message = new Message<Integer>();
		try {
			
			FileRoleMapper fileRoleMapper = mapperFactory.getMapperForMaster(FileRoleMapper.class);
			mapperFactory.beginTransaction();
			FileRole fileRoleLast = fileRoleMapper.selectByPrimaryKeyForUpdate(id );
			if( fileRoleLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}
			
			//TODO：其他判断
			
			int result = fileRoleMapper.changeStatus(id,status,operatorId,System.currentTimeMillis());
			mapperFactory.commitTransaction();
			message.setData(result);
			
		} catch (Exception e) {
			LOGGER.error("changeStatus,更新FileRole状态失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;
	}
		public Message<FileRole> getFileRole( Integer id ){
		Message<FileRole> message = new Message<FileRole>();
		try {
			FileRoleMapper fileRoleMapper = mapperFactory.getMapperForSlave(FileRoleMapper.class);
			FileRole fileRole = fileRoleMapper.selectByPrimaryKey( id );
			message.setData(fileRole);

		} catch (Exception e) {
			LOGGER.error("getFileRole,根据主键查询FileRole失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<FileRole>> getAllFileRole(){
	
		Message<List<FileRole>> message = new Message<List<FileRole>>();
		try {
			FileRoleMapper fileRoleMapper = mapperFactory.getMapperForSlave(FileRoleMapper.class);
				
			List<FileRole> fileRoleList = fileRoleMapper.selectAll();
			message.setData( fileRoleList);
		} catch (Exception e) {
			LOGGER.error("getAllFileRole,查询全部FileRole失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;	
	}
	
	public Message<QueryResult<FileRole>> queryFileRole(FileRoleQuery fileRoleQuery) {
		Message<QueryResult<FileRole>> message = new Message<QueryResult<FileRole>>();
		try {
			FileRoleMapper fileRoleMapper = mapperFactory.getMapperForSlave(FileRoleMapper.class);
			QueryResult<FileRole> queryResult = new QueryResult<FileRole>();
			PageHelper.startPage(fileRoleQuery.getPageIndex(), fileRoleQuery.getPageSize());
			List<FileRole> fileRoleList = fileRoleMapper.queryFileRole(fileRoleQuery);
			PageInfo<FileRole> pageInfo = new PageInfo<FileRole>(fileRoleList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(fileRoleList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryFileRole,分页查询FileRole失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
   
	

}