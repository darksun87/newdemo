package com.crm.service;


import java.util.List;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.AutocodeInfo;
import com.crm.message.AutocodeQueryInfo;

public interface AutocodeService {
		MessageInfo<Integer> deleteAutocode(Integer id);
		
    MessageInfo<Integer> createAutocode(AutocodeInfo autocodeInfo);
		
	MessageInfo<Integer> updateAutocode(AutocodeInfo autocodeInfo);
			
	MessageInfo<Integer> changeStatus(Integer id,Boolean status,String operatorId);
		
	MessageInfo<AutocodeInfo> getAutocode( Integer id );
		
    MessageInfo<List<AutocodeInfo>> getAllAutocode();
			
    MessageInfo<QueryResultInfo<AutocodeInfo>> queryAutocode(AutocodeQueryInfo autocodeQueryInfo);
	
	

}