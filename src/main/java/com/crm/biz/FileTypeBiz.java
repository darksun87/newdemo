package com.crm.biz;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.log4j.Logger;
import com.crm.data.MapperFactory;

import com.crm.dao.FileTypeMapper;

import com.crm.model.Message;
import com.crm.model.dict.MessageStatus;
import com.crm.model.QueryResult;
import com.crm.model.FileType;
import com.crm.model.FileTypeQuery;
import static com.crm.biz.util.ValidationUtil.*;

@Service("fileTypeBiz")
public class FileTypeBiz {


	private static final Logger LOGGER = Logger.getLogger(FileTypeBiz.class);

	@Resource
	private MapperFactory mapperFactory;
	
		public Message<Integer> deleteFileType(Integer id,String operatorId){
		Message<Integer> message = new Message<Integer>();
		try {
			FileTypeMapper fileTypeMapper  = mapperFactory.getMapperForMaster(FileTypeMapper.class);
			int result = fileTypeMapper.logicalDeleteByPrimaryKey(id,operatorId,System.currentTimeMillis());
			
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete,删除FileType失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;		
	}
		

    public Message<Integer> createFileType(FileType fileType){
		Message<Integer> message = new Message<Integer>();
		if (!validateForCreate( fileType, message)) {
			return message;
		}
		try {
			mapperFactory.beginTransaction();
			FileTypeMapper fileTypeMapper = mapperFactory.getMapperForMaster(FileTypeMapper.class);
									fileType.setCreateTime(System.currentTimeMillis());			fileTypeMapper.insert( fileType );
			mapperFactory.commitTransaction();
			message.setData(fileType.getId());

		} catch (Exception e) {
			LOGGER.error("createFileType,创建FileType失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;	
	}
	private boolean validateForCreate(FileType fileType, Message<?> message) {
								    		        		        		
        		if (isMoreThan(message, FileType.TYPENAME, fileType.getTypename(), 100)) {
        			return false;
        		}	
        		    																																return true;
	}
	public Message<Integer> updateFileType(FileType fileType){
		Message<Integer> message = new Message<Integer>();
		if (!validateForUpdate(fileType, message)) {
            return message;
        }
		try {
			FileTypeMapper fileTypeMapper = mapperFactory.getMapperForMaster(FileTypeMapper.class);
			mapperFactory.beginTransaction();
			
			FileType fileTypeLast = fileTypeMapper.selectByPrimaryKeyForUpdate( fileType.getId() );
			if( fileTypeLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}
			
									fileType.setUpdateTime(System.currentTimeMillis());			int result = fileTypeMapper.updateByPrimaryKey( fileType );
			mapperFactory.commitTransaction();
			message.setData(result);
			
		} catch (Exception e) {
			LOGGER.error("updateFileType,更新FileType失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;	
	}
	private boolean validateForUpdate(FileType fileType, Message<?> message) {
       				if (isNull(message,FileType.ID, fileType.getId())) {
			return false;
		}
			   				if (isMoreThan(message, FileType.TYPENAME, fileType.getTypename(), 100)) {
			return false;
		}	
			   			   			   			   			   			   			   		return true;
    }
		public Message<Integer> changeStatus(Integer id,Byte status,String operatorId){
		Message<Integer> message = new Message<Integer>();
		try {
			
			FileTypeMapper fileTypeMapper = mapperFactory.getMapperForMaster(FileTypeMapper.class);
			mapperFactory.beginTransaction();
			FileType fileTypeLast = fileTypeMapper.selectByPrimaryKeyForUpdate(id );
			if( fileTypeLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}
			
			//TODO：其他判断
			
			int result = fileTypeMapper.changeStatus(id,status,operatorId,System.currentTimeMillis());
			mapperFactory.commitTransaction();
			message.setData(result);
			
		} catch (Exception e) {
			LOGGER.error("changeStatus,更新FileType状态失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;
	}
		public Message<FileType> getFileType( Integer id ){
		Message<FileType> message = new Message<FileType>();
		try {
			FileTypeMapper fileTypeMapper = mapperFactory.getMapperForSlave(FileTypeMapper.class);
			FileType fileType = fileTypeMapper.selectByPrimaryKey( id );
			message.setData(fileType);

		} catch (Exception e) {
			LOGGER.error("getFileType,根据主键查询FileType失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<FileType>> getAllFileType(){
	
		Message<List<FileType>> message = new Message<List<FileType>>();
		try {
			FileTypeMapper fileTypeMapper = mapperFactory.getMapperForSlave(FileTypeMapper.class);
				
			List<FileType> fileTypeList = fileTypeMapper.selectAll();
			message.setData( fileTypeList);
		} catch (Exception e) {
			LOGGER.error("getAllFileType,查询全部FileType失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;	
	}
	
	public Message<QueryResult<FileType>> queryFileType(FileTypeQuery fileTypeQuery) {
		Message<QueryResult<FileType>> message = new Message<QueryResult<FileType>>();
		try {
			FileTypeMapper fileTypeMapper = mapperFactory.getMapperForSlave(FileTypeMapper.class);
			QueryResult<FileType> queryResult = new QueryResult<FileType>();
			PageHelper.startPage(fileTypeQuery.getPageIndex(), fileTypeQuery.getPageSize());
			List<FileType> fileTypeList = fileTypeMapper.queryFileType(fileTypeQuery);
			PageInfo<FileType> pageInfo = new PageInfo<FileType>(fileTypeList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(fileTypeList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryFileType,分页查询FileType失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
   
	

}