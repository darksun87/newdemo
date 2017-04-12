package com.crm.service;


import java.util.List;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.SignetInfo;
import com.crm.message.SignetQueryInfo;

public interface SignetService {
		
	MessageInfo<Integer> deleteSignet(Integer id,String operatorId);
		
    MessageInfo<Integer> createSignet(SignetInfo signetInfo);
		
	MessageInfo<Integer> updateSignet(SignetInfo signetInfo);
			
	MessageInfo<Integer> changeStatus(Integer id,Byte status,String operatorId);
		
	MessageInfo<SignetInfo> getSignet( Integer id );
		
    MessageInfo<List<SignetInfo>> getAllSignet();
			
    MessageInfo<QueryResultInfo<SignetInfo>> querySignet(SignetQueryInfo signetQueryInfo);
	
	

}