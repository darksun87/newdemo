package com.crm.biz;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.log4j.Logger;
import com.crm.data.MapperFactory;

import com.crm.dao.FileMapper;

import com.crm.model.Message;
import com.crm.model.dict.MessageStatus;
import com.crm.model.QueryResult;
import com.crm.model.File;
import com.crm.model.FileQuery;
import static com.crm.biz.util.ValidationUtil.*;

@Service("fileBiz")
public class FileBiz {


	private static final Logger LOGGER = Logger.getLogger(FileBiz.class);

	@Resource
	private MapperFactory mapperFactory;
	
		public Message<Integer> deleteFile(Integer id,String operatorId){
		Message<Integer> message = new Message<Integer>();
		try {
			FileMapper fileMapper  = mapperFactory.getMapperForMaster(FileMapper.class);
			int result = fileMapper.logicalDeleteByPrimaryKey(id,operatorId,System.currentTimeMillis());
			
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete,删除File失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;		
	}
		

    public Message<Integer> createFile(File file){
		Message<Integer> message = new Message<Integer>();
		if (!validateForCreate( file, message)) {
			return message;
		}
		try {
			mapperFactory.beginTransaction();
			FileMapper fileMapper = mapperFactory.getMapperForMaster(FileMapper.class);
									file.setCreateTime(System.currentTimeMillis());			fileMapper.insert( file );
			mapperFactory.commitTransaction();
			message.setData(file.getId());

		} catch (Exception e) {
			LOGGER.error("createFile,创建File失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;	
	}
	private boolean validateForCreate(File file, Message<?> message) {
								    		        		        				
        		if (isNull(message,File.FILE_TYPE_ID, file.getFileTypeId())) {
        			return false;
        		}
        		    								    		        		        		
        		if (isMoreThan(message, File.FILENAME, file.getFilename(), 100)) {
        			return false;
        		}	
        		    								    		        		        		
        		if (isMoreThan(message, File.FILEDESC, file.getFiledesc(), 100)) {
        			return false;
        		}	
        		    								    		        		    																																return true;
	}
	public Message<Integer> updateFile(File file){
		Message<Integer> message = new Message<Integer>();
		if (!validateForUpdate(file, message)) {
            return message;
        }
		try {
			FileMapper fileMapper = mapperFactory.getMapperForMaster(FileMapper.class);
			mapperFactory.beginTransaction();
			
			File fileLast = fileMapper.selectByPrimaryKeyForUpdate( file.getId() );
			if( fileLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}
			
									file.setUpdateTime(System.currentTimeMillis());			int result = fileMapper.updateByPrimaryKey( file );
			mapperFactory.commitTransaction();
			message.setData(result);
			
		} catch (Exception e) {
			LOGGER.error("updateFile,更新File失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;	
	}
	private boolean validateForUpdate(File file, Message<?> message) {
       				if (isNull(message,File.ID, file.getId())) {
			return false;
		}
			   			   				if (isMoreThan(message, File.FILENAME, file.getFilename(), 100)) {
			return false;
		}	
			   				if (isMoreThan(message, File.FILEDESC, file.getFiledesc(), 100)) {
			return false;
		}	
			   			   			   			   			   			   			   			   		return true;
    }
		public Message<Integer> changeStatus(Integer id,Byte status,String operatorId){
		Message<Integer> message = new Message<Integer>();
		try {
			
			FileMapper fileMapper = mapperFactory.getMapperForMaster(FileMapper.class);
			mapperFactory.beginTransaction();
			File fileLast = fileMapper.selectByPrimaryKeyForUpdate(id );
			if( fileLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}
			
			//TODO：其他判断
			
			int result = fileMapper.changeStatus(id,status,operatorId,System.currentTimeMillis());
			mapperFactory.commitTransaction();
			message.setData(result);
			
		} catch (Exception e) {
			LOGGER.error("changeStatus,更新File状态失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;
	}
		public Message<File> getFile( Integer id ){
		Message<File> message = new Message<File>();
		try {
			FileMapper fileMapper = mapperFactory.getMapperForSlave(FileMapper.class);
			File file = fileMapper.selectByPrimaryKey( id );
			message.setData(file);

		} catch (Exception e) {
			LOGGER.error("getFile,根据主键查询File失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<File>> getAllFile(){
	
		Message<List<File>> message = new Message<List<File>>();
		try {
			FileMapper fileMapper = mapperFactory.getMapperForSlave(FileMapper.class);
				
			List<File> fileList = fileMapper.selectAll();
			message.setData( fileList);
		} catch (Exception e) {
			LOGGER.error("getAllFile,查询全部File失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;	
	}
	
	public Message<QueryResult<File>> queryFile(FileQuery fileQuery) {
		Message<QueryResult<File>> message = new Message<QueryResult<File>>();
		try {
			FileMapper fileMapper = mapperFactory.getMapperForSlave(FileMapper.class);
			QueryResult<File> queryResult = new QueryResult<File>();
			PageHelper.startPage(fileQuery.getPageIndex(), fileQuery.getPageSize());
			List<File> fileList = fileMapper.queryFile(fileQuery);
			PageInfo<File> pageInfo = new PageInfo<File>(fileList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(fileList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryFile,分页查询File失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
   
	

}