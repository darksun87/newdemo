
package com.crm.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.crm.biz.UserBiz;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.UserInfo;
import com.crm.message.UserQueryInfo;


import com.crm.model.Message;
import com.crm.model.QueryResult;
import com.crm.model.User;
import com.crm.model.UserQuery;


import com.crm.service.UserService;
import com.crm.service.convertor.UserConvertor;
import com.crm.service.convertor.MessageConvertor;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserBiz userBiz;
			
	public MessageInfo<Integer> deleteUser(Integer id,String operatorId){
		
		Message<Integer> message  = userBiz.deleteUser(id,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Integer> createUser(UserInfo userInfo){
		
		User user = UserConvertor.toUser(userInfo);
		Message<Integer> message  =  userBiz.createUser( user );
		MessageInfo<Integer> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateUser(UserInfo userInfo){
		
		User user = UserConvertor.toUser(userInfo);
		Message<Integer> message  =  userBiz.updateUser( user );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<Integer> changeStatus(
			Integer id,
			Byte status,
			String operatorId){
			
		Message<Integer> message  = userBiz.changeStatus(id,status,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<UserInfo> getUser( Integer id ){
		
		Message<User> message  = userBiz.getUser( id );
		MessageInfo<UserInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		UserInfo userInfo = UserConvertor.toUserInfo(message.getData());
		messageInfo.setData(userInfo);
		return messageInfo;
	}

    public MessageInfo<List<UserInfo>> getAllUser(){
	
		Message<List<User>> message  = userBiz.getAllUser();
		MessageInfo<List<UserInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<UserInfo> userInfoList = UserConvertor.toUserInfoList(message.getData());
		messageInfo.setData(userInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<UserInfo>> queryUser(UserQueryInfo userQueryInfo) {
		UserQuery userQuery = UserConvertor.toUserQuery(userQueryInfo);
		Message<QueryResult<User>> message = userBiz.queryUser(userQuery);
		MessageInfo<QueryResultInfo<UserInfo>> messageInfo = new MessageInfo<QueryResultInfo<UserInfo>>();
		QueryResultInfo<UserInfo> queryResultInfo = UserConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}