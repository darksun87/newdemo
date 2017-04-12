
package com.crm.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.crm.biz.RoleBiz;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.RoleInfo;
import com.crm.message.RoleQueryInfo;


import com.crm.model.Message;
import com.crm.model.QueryResult;
import com.crm.model.Role;
import com.crm.model.RoleQuery;


import com.crm.service.RoleService;
import com.crm.service.convertor.RoleConvertor;
import com.crm.service.convertor.MessageConvertor;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleBiz roleBiz;
			
	public MessageInfo<Integer> deleteRole(Integer id,String operatorId){
		
		Message<Integer> message  = roleBiz.deleteRole(id,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Integer> createRole(RoleInfo roleInfo){
		
		Role role = RoleConvertor.toRole(roleInfo);
		Message<Integer> message  =  roleBiz.createRole( role );
		MessageInfo<Integer> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateRole(RoleInfo roleInfo){
		
		Role role = RoleConvertor.toRole(roleInfo);
		Message<Integer> message  =  roleBiz.updateRole( role );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<Integer> changeStatus(
			Integer id,
			Byte status,
			String operatorId){
			
		Message<Integer> message  = roleBiz.changeStatus(id,status,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<RoleInfo> getRole( Integer id ){
		
		Message<Role> message  = roleBiz.getRole( id );
		MessageInfo<RoleInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		RoleInfo roleInfo = RoleConvertor.toRoleInfo(message.getData());
		messageInfo.setData(roleInfo);
		return messageInfo;
	}

    public MessageInfo<List<RoleInfo>> getAllRole(){
	
		Message<List<Role>> message  = roleBiz.getAllRole();
		MessageInfo<List<RoleInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<RoleInfo> roleInfoList = RoleConvertor.toRoleInfoList(message.getData());
		messageInfo.setData(roleInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<RoleInfo>> queryRole(RoleQueryInfo roleQueryInfo) {
		RoleQuery roleQuery = RoleConvertor.toRoleQuery(roleQueryInfo);
		Message<QueryResult<Role>> message = roleBiz.queryRole(roleQuery);
		MessageInfo<QueryResultInfo<RoleInfo>> messageInfo = new MessageInfo<QueryResultInfo<RoleInfo>>();
		QueryResultInfo<RoleInfo> queryResultInfo = RoleConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}