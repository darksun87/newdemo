
package com.crm.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.crm.biz.AutocodeBiz;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.AutocodeInfo;
import com.crm.message.AutocodeQueryInfo;


import com.crm.model.Message;
import com.crm.model.QueryResult;
import com.crm.model.Autocode;
import com.crm.model.AutocodeQuery;


import com.crm.service.AutocodeService;
import com.crm.service.convertor.AutocodeConvertor;
import com.crm.service.convertor.MessageConvertor;

@Service("autocodeService")
public class AutocodeServiceImpl implements AutocodeService {

	@Resource
	private AutocodeBiz autocodeBiz;
				
	public MessageInfo<Integer> deleteAutocode(Integer id){
		
		Message<Integer> message  = autocodeBiz.deleteAutocode(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Integer> createAutocode(AutocodeInfo autocodeInfo){
		
		Autocode autocode = AutocodeConvertor.toAutocode(autocodeInfo);
		Message<Integer> message  =  autocodeBiz.createAutocode( autocode );
		MessageInfo<Integer> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateAutocode(AutocodeInfo autocodeInfo){
		
		Autocode autocode = AutocodeConvertor.toAutocode(autocodeInfo);
		Message<Integer> message  =  autocodeBiz.updateAutocode( autocode );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<Integer> changeStatus(
			Integer id,
			Boolean status,
			String operatorId){
			
		Message<Integer> message  = autocodeBiz.changeStatus(id,status,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<AutocodeInfo> getAutocode( Integer id ){
		
		Message<Autocode> message  = autocodeBiz.getAutocode( id );
		MessageInfo<AutocodeInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		AutocodeInfo autocodeInfo = AutocodeConvertor.toAutocodeInfo(message.getData());
		messageInfo.setData(autocodeInfo);
		return messageInfo;
	}

    public MessageInfo<List<AutocodeInfo>> getAllAutocode(){
	
		Message<List<Autocode>> message  = autocodeBiz.getAllAutocode();
		MessageInfo<List<AutocodeInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<AutocodeInfo> autocodeInfoList = AutocodeConvertor.toAutocodeInfoList(message.getData());
		messageInfo.setData(autocodeInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<AutocodeInfo>> queryAutocode(AutocodeQueryInfo autocodeQueryInfo) {
		AutocodeQuery autocodeQuery = AutocodeConvertor.toAutocodeQuery(autocodeQueryInfo);
		Message<QueryResult<Autocode>> message = autocodeBiz.queryAutocode(autocodeQuery);
		MessageInfo<QueryResultInfo<AutocodeInfo>> messageInfo = new MessageInfo<QueryResultInfo<AutocodeInfo>>();
		QueryResultInfo<AutocodeInfo> queryResultInfo = AutocodeConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}