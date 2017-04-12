package com.crm.service;


import java.util.List;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.RolePermissionInfo;
import com.crm.message.RolePermissionQueryInfo;

public interface RolePermissionService {
		
	MessageInfo<Integer> deleteRolePermission(Integer id,String operatorId);
		
    MessageInfo<Integer> createRolePermission(RolePermissionInfo rolePermissionInfo);
		
	MessageInfo<Integer> updateRolePermission(RolePermissionInfo rolePermissionInfo);
			
	MessageInfo<Integer> changeStatus(Integer id,Byte status,String operatorId);
		
	MessageInfo<RolePermissionInfo> getRolePermission( Integer id );
		
    MessageInfo<List<RolePermissionInfo>> getAllRolePermission();
			
    MessageInfo<QueryResultInfo<RolePermissionInfo>> queryRolePermission(RolePermissionQueryInfo rolePermissionQueryInfo);
	
	

}