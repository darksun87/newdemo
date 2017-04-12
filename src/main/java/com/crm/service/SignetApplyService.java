package com.crm.service;


import java.util.List;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.SignetApplyInfo;
import com.crm.message.SignetApplyQueryInfo;

public interface SignetApplyService {
		
	MessageInfo<Integer> deleteSignetApply(Integer id,String operatorId);
		
    MessageInfo<Integer> createSignetApply(SignetApplyInfo signetApplyInfo);
		
	MessageInfo<Integer> updateSignetApply(SignetApplyInfo signetApplyInfo);
			
	MessageInfo<Integer> changeStatus(Integer id,Byte status,String operatorId);
		
	MessageInfo<SignetApplyInfo> getSignetApply( Integer id );
		
    MessageInfo<List<SignetApplyInfo>> getAllSignetApply();
			
    MessageInfo<QueryResultInfo<SignetApplyInfo>> querySignetApply(SignetApplyQueryInfo signetApplyQueryInfo);
	
	

}