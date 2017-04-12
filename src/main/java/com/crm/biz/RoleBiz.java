package com.crm.biz;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.log4j.Logger;
import com.crm.data.MapperFactory;

import com.crm.dao.RoleMapper;

import com.crm.model.Message;
import com.crm.model.dict.MessageStatus;
import com.crm.model.QueryResult;
import com.crm.model.Role;
import com.crm.model.RoleQuery;
import static com.crm.biz.util.ValidationUtil.*;

@Service("roleBiz")
public class RoleBiz {


	private static final Logger LOGGER = Logger.getLogger(RoleBiz.class);

	@Resource
	private MapperFactory mapperFactory;
	
		public Message<Integer> deleteRole(Integer id,String operatorId){
		Message<Integer> message = new Message<Integer>();
		try {
			RoleMapper roleMapper  = mapperFactory.getMapperForMaster(RoleMapper.class);
			int result = roleMapper.logicalDeleteByPrimaryKey(id,operatorId,System.currentTimeMillis());
			
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete,删除Role失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;		
	}
		

    public Message<Integer> createRole(Role role){
		Message<Integer> message = new Message<Integer>();
		if (!validateForCreate( role, message)) {
			return message;
		}
		try {
			mapperFactory.beginTransaction();
			RoleMapper roleMapper = mapperFactory.getMapperForMaster(RoleMapper.class);
									role.setCreateTime(System.currentTimeMillis());			roleMapper.insert( role );
			mapperFactory.commitTransaction();
			message.setData(role.getId());

		} catch (Exception e) {
			LOGGER.error("createRole,创建Role失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;	
	}
	private boolean validateForCreate(Role role, Message<?> message) {
								    		        		        		
        		if (isMoreThan(message, Role.ROLENAME, role.getRolename(), 100)) {
        			return false;
        		}	
        		    																																return true;
	}
	public Message<Integer> updateRole(Role role){
		Message<Integer> message = new Message<Integer>();
		if (!validateForUpdate(role, message)) {
            return message;
        }
		try {
			RoleMapper roleMapper = mapperFactory.getMapperForMaster(RoleMapper.class);
			mapperFactory.beginTransaction();
			
			Role roleLast = roleMapper.selectByPrimaryKeyForUpdate( role.getId() );
			if( roleLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}
			
									role.setUpdateTime(System.currentTimeMillis());			int result = roleMapper.updateByPrimaryKey( role );
			mapperFactory.commitTransaction();
			message.setData(result);
			
		} catch (Exception e) {
			LOGGER.error("updateRole,更新Role失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;	
	}
	private boolean validateForUpdate(Role role, Message<?> message) {
       				if (isNull(message,Role.ID, role.getId())) {
			return false;
		}
			   				if (isMoreThan(message, Role.ROLENAME, role.getRolename(), 100)) {
			return false;
		}	
			   			   			   			   			   			   			   		return true;
    }
		public Message<Integer> changeStatus(Integer id,Byte status,String operatorId){
		Message<Integer> message = new Message<Integer>();
		try {
			
			RoleMapper roleMapper = mapperFactory.getMapperForMaster(RoleMapper.class);
			mapperFactory.beginTransaction();
			Role roleLast = roleMapper.selectByPrimaryKeyForUpdate(id );
			if( roleLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}
			
			//TODO：其他判断
			
			int result = roleMapper.changeStatus(id,status,operatorId,System.currentTimeMillis());
			mapperFactory.commitTransaction();
			message.setData(result);
			
		} catch (Exception e) {
			LOGGER.error("changeStatus,更新Role状态失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;
	}
		public Message<Role> getRole( Integer id ){
		Message<Role> message = new Message<Role>();
		try {
			RoleMapper roleMapper = mapperFactory.getMapperForSlave(RoleMapper.class);
			Role role = roleMapper.selectByPrimaryKey( id );
			message.setData(role);

		} catch (Exception e) {
			LOGGER.error("getRole,根据主键查询Role失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<Role>> getAllRole(){
	
		Message<List<Role>> message = new Message<List<Role>>();
		try {
			RoleMapper roleMapper = mapperFactory.getMapperForSlave(RoleMapper.class);
				
			List<Role> roleList = roleMapper.selectAll();
			message.setData( roleList);
		} catch (Exception e) {
			LOGGER.error("getAllRole,查询全部Role失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;	
	}
	
	public Message<QueryResult<Role>> queryRole(RoleQuery roleQuery) {
		Message<QueryResult<Role>> message = new Message<QueryResult<Role>>();
		try {
			RoleMapper roleMapper = mapperFactory.getMapperForSlave(RoleMapper.class);
			QueryResult<Role> queryResult = new QueryResult<Role>();
			PageHelper.startPage(roleQuery.getPageIndex(), roleQuery.getPageSize());
			List<Role> roleList = roleMapper.queryRole(roleQuery);
			PageInfo<Role> pageInfo = new PageInfo<Role>(roleList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(roleList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryRole,分页查询Role失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
   
	

}