package com.crm.service;


import java.util.List;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.RoleInfo;
import com.crm.message.RoleQueryInfo;

public interface RoleService {
		
	MessageInfo<Integer> deleteRole(Integer id,String operatorId);
		
    MessageInfo<Integer> createRole(RoleInfo roleInfo);
		
	MessageInfo<Integer> updateRole(RoleInfo roleInfo);
			
	MessageInfo<Integer> changeStatus(Integer id,Byte status,String operatorId);
		
	MessageInfo<RoleInfo> getRole( Integer id );
		
    MessageInfo<List<RoleInfo>> getAllRole();
			
    MessageInfo<QueryResultInfo<RoleInfo>> queryRole(RoleQueryInfo roleQueryInfo);
	
	

}