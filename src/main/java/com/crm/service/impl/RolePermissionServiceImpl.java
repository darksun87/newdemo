
package com.crm.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.crm.biz.RolePermissionBiz;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.RolePermissionInfo;
import com.crm.message.RolePermissionQueryInfo;


import com.crm.model.Message;
import com.crm.model.QueryResult;
import com.crm.model.RolePermission;
import com.crm.model.RolePermissionQuery;


import com.crm.service.RolePermissionService;
import com.crm.service.convertor.RolePermissionConvertor;
import com.crm.service.convertor.MessageConvertor;

@Service("rolePermissionService")
public class RolePermissionServiceImpl implements RolePermissionService {

	@Resource
	private RolePermissionBiz rolePermissionBiz;
			
	public MessageInfo<Integer> deleteRolePermission(Integer id,String operatorId){
		
		Message<Integer> message  = rolePermissionBiz.deleteRolePermission(id,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Integer> createRolePermission(RolePermissionInfo rolePermissionInfo){
		
		RolePermission rolePermission = RolePermissionConvertor.toRolePermission(rolePermissionInfo);
		Message<Integer> message  =  rolePermissionBiz.createRolePermission( rolePermission );
		MessageInfo<Integer> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateRolePermission(RolePermissionInfo rolePermissionInfo){
		
		RolePermission rolePermission = RolePermissionConvertor.toRolePermission(rolePermissionInfo);
		Message<Integer> message  =  rolePermissionBiz.updateRolePermission( rolePermission );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<Integer> changeStatus(
			Integer id,
			Byte status,
			String operatorId){
			
		Message<Integer> message  = rolePermissionBiz.changeStatus(id,status,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<RolePermissionInfo> getRolePermission( Integer id ){
		
		Message<RolePermission> message  = rolePermissionBiz.getRolePermission( id );
		MessageInfo<RolePermissionInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		RolePermissionInfo rolePermissionInfo = RolePermissionConvertor.toRolePermissionInfo(message.getData());
		messageInfo.setData(rolePermissionInfo);
		return messageInfo;
	}

    public MessageInfo<List<RolePermissionInfo>> getAllRolePermission(){
	
		Message<List<RolePermission>> message  = rolePermissionBiz.getAllRolePermission();
		MessageInfo<List<RolePermissionInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<RolePermissionInfo> rolePermissionInfoList = RolePermissionConvertor.toRolePermissionInfoList(message.getData());
		messageInfo.setData(rolePermissionInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<RolePermissionInfo>> queryRolePermission(RolePermissionQueryInfo rolePermissionQueryInfo) {
		RolePermissionQuery rolePermissionQuery = RolePermissionConvertor.toRolePermissionQuery(rolePermissionQueryInfo);
		Message<QueryResult<RolePermission>> message = rolePermissionBiz.queryRolePermission(rolePermissionQuery);
		MessageInfo<QueryResultInfo<RolePermissionInfo>> messageInfo = new MessageInfo<QueryResultInfo<RolePermissionInfo>>();
		QueryResultInfo<RolePermissionInfo> queryResultInfo = RolePermissionConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}