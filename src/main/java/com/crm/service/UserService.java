package com.crm.service;


import java.util.List;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.UserInfo;
import com.crm.message.UserQueryInfo;

public interface UserService {
		
	MessageInfo<Integer> deleteUser(Integer id,String operatorId);
		
    MessageInfo<Integer> createUser(UserInfo userInfo);
		
	MessageInfo<Integer> updateUser(UserInfo userInfo);
			
	MessageInfo<Integer> changeStatus(Integer id,Byte status,String operatorId);
		
	MessageInfo<UserInfo> getUser( Integer id );
		
    MessageInfo<List<UserInfo>> getAllUser();
			
    MessageInfo<QueryResultInfo<UserInfo>> queryUser(UserQueryInfo userQueryInfo);
	
	

}