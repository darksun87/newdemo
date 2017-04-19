package com.crm.biz;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.log4j.Logger;
import com.crm.data.MapperFactory;

import com.crm.dao.RolePermissionMapper;

import com.crm.model.Message;
import com.crm.model.dict.MessageStatus;
import com.crm.model.QueryResult;
import com.crm.model.RolePermission;
import com.crm.model.RolePermissionQuery;
import static com.crm.biz.util.ValidationUtil.*;

@Service("rolePermissionBiz")
public class RolePermissionBiz {


	private static final Logger LOGGER = Logger.getLogger(RolePermissionBiz.class);

	@Resource
	private MapperFactory mapperFactory;
	
		public Message<Integer> deleteRolePermission(Integer id,String operatorId){
		Message<Integer> message = new Message<Integer>();
		try {
			RolePermissionMapper rolePermissionMapper  = mapperFactory.getMapperForMaster(RolePermissionMapper.class);
			int result = rolePermissionMapper.logicalDeleteByPrimaryKey(id,operatorId,System.currentTimeMillis());
			
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete,删除RolePermission失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;		
	}
		

    public Message<Integer> createRolePermission(RolePermission rolePermission){
		Message<Integer> message = new Message<Integer>();
		if (!validateForCreate( rolePermission, message)) {
			return message;
		}
		try {
			mapperFactory.beginTransaction();
			RolePermissionMapper rolePermissionMapper = mapperFactory.getMapperForMaster(RolePermissionMapper.class);
									rolePermission.setCreateTime(System.currentTimeMillis());			rolePermissionMapper.insert( rolePermission );
			mapperFactory.commitTransaction();
			message.setData(rolePermission.getId());

		} catch (Exception e) {
			LOGGER.error("createRolePermission,创建RolePermission失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;	
	}
	private boolean validateForCreate(RolePermission rolePermission, Message<?> message) {
								    		        		    								    		        		        		
        		if (isMoreThan(message, RolePermission.URL, rolePermission.getUrl(), 100)) {
        			return false;
        		}	
        		    																																return true;
	}
	public Message<Integer> updateRolePermission(RolePermission rolePermission){
		Message<Integer> message = new Message<Integer>();
		if (!validateForUpdate(rolePermission, message)) {
            return message;
        }
		try {
			RolePermissionMapper rolePermissionMapper = mapperFactory.getMapperForMaster(RolePermissionMapper.class);
			mapperFactory.beginTransaction();
			
			RolePermission rolePermissionLast = rolePermissionMapper.selectByPrimaryKeyForUpdate( rolePermission.getId() );
			if( rolePermissionLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}
			
									rolePermission.setUpdateTime(System.currentTimeMillis());			int result = rolePermissionMapper.updateByPrimaryKey( rolePermission );
			mapperFactory.commitTransaction();
			message.setData(result);
			
		} catch (Exception e) {
			LOGGER.error("updateRolePermission,更新RolePermission失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;	
	}
	private boolean validateForUpdate(RolePermission rolePermission, Message<?> message) {
       				if (isNull(message,RolePermission.ID, rolePermission.getId())) {
			return false;
		}
			   			   				if (isMoreThan(message, RolePermission.URL, rolePermission.getUrl(), 100)) {
			return false;
		}	
			   			   			   			   			   			   			   		return true;
    }
		public Message<Integer> changeStatus(Integer id,Byte status,String operatorId){
		Message<Integer> message = new Message<Integer>();
		try {
			
			RolePermissionMapper rolePermissionMapper = mapperFactory.getMapperForMaster(RolePermissionMapper.class);
			mapperFactory.beginTransaction();
			RolePermission rolePermissionLast = rolePermissionMapper.selectByPrimaryKeyForUpdate(id );
			if( rolePermissionLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}
			
			//TODO：其他判断
			
			int result = rolePermissionMapper.changeStatus(id,status,operatorId,System.currentTimeMillis());
			mapperFactory.commitTransaction();
			message.setData(result);
			
		} catch (Exception e) {
			LOGGER.error("changeStatus,更新RolePermission状态失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;
	}
		public Message<RolePermission> getRolePermission( Integer id ){
		Message<RolePermission> message = new Message<RolePermission>();
		try {
			RolePermissionMapper rolePermissionMapper = mapperFactory.getMapperForSlave(RolePermissionMapper.class);
			RolePermission rolePermission = rolePermissionMapper.selectByPrimaryKey( id );
			message.setData(rolePermission);

		} catch (Exception e) {
			LOGGER.error("getRolePermission,根据主键查询RolePermission失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<RolePermission>> getAllRolePermission(){
	
		Message<List<RolePermission>> message = new Message<List<RolePermission>>();
		try {
			RolePermissionMapper rolePermissionMapper = mapperFactory.getMapperForSlave(RolePermissionMapper.class);
				
			List<RolePermission> rolePermissionList = rolePermissionMapper.selectAll();
			message.setData( rolePermissionList);
		} catch (Exception e) {
			LOGGER.error("getAllRolePermission,查询全部RolePermission失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;	
	}
	
	public Message<QueryResult<RolePermission>> queryRolePermission(RolePermissionQuery rolePermissionQuery) {
		Message<QueryResult<RolePermission>> message = new Message<QueryResult<RolePermission>>();
		try {
			RolePermissionMapper rolePermissionMapper = mapperFactory.getMapperForSlave(RolePermissionMapper.class);
			QueryResult<RolePermission> queryResult = new QueryResult<RolePermission>();
			PageHelper.startPage(rolePermissionQuery.getPageIndex(), rolePermissionQuery.getPageSize());
			List<RolePermission> rolePermissionList = rolePermissionMapper.queryRolePermission(rolePermissionQuery);
			PageInfo<RolePermission> pageInfo = new PageInfo<RolePermission>(rolePermissionList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(rolePermissionList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryRolePermission,分页查询RolePermission失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
   
	

}