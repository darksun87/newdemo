
package com.crm.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.crm.biz.TravelBiz;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.TravelInfo;
import com.crm.message.TravelQueryInfo;


import com.crm.model.Message;
import com.crm.model.QueryResult;
import com.crm.model.Travel;
import com.crm.model.TravelQuery;


import com.crm.service.TravelService;
import com.crm.service.convertor.TravelConvertor;
import com.crm.service.convertor.MessageConvertor;

@Service("travelService")
public class TravelServiceImpl implements TravelService {

	@Resource
	private TravelBiz travelBiz;
			
	public MessageInfo<Integer> deleteTravel(Integer id,String operatorId){
		
		Message<Integer> message  = travelBiz.deleteTravel(id,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Integer> createTravel(TravelInfo travelInfo){
		
		Travel travel = TravelConvertor.toTravel(travelInfo);
		Message<Integer> message  =  travelBiz.createTravel( travel );
		MessageInfo<Integer> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateTravel(TravelInfo travelInfo){
		
		Travel travel = TravelConvertor.toTravel(travelInfo);
		Message<Integer> message  =  travelBiz.updateTravel( travel );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<Integer> changeStatus(
			Integer id,
			Byte status,
			String operatorId){
			
		Message<Integer> message  = travelBiz.changeStatus(id,status,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<TravelInfo> getTravel( Integer id ){
		
		Message<Travel> message  = travelBiz.getTravel( id );
		MessageInfo<TravelInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		TravelInfo travelInfo = TravelConvertor.toTravelInfo(message.getData());
		messageInfo.setData(travelInfo);
		return messageInfo;
	}

    public MessageInfo<List<TravelInfo>> getAllTravel(){
	
		Message<List<Travel>> message  = travelBiz.getAllTravel();
		MessageInfo<List<TravelInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<TravelInfo> travelInfoList = TravelConvertor.toTravelInfoList(message.getData());
		messageInfo.setData(travelInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<TravelInfo>> queryTravel(TravelQueryInfo travelQueryInfo) {
		TravelQuery travelQuery = TravelConvertor.toTravelQuery(travelQueryInfo);
		Message<QueryResult<Travel>> message = travelBiz.queryTravel(travelQuery);
		MessageInfo<QueryResultInfo<TravelInfo>> messageInfo = new MessageInfo<QueryResultInfo<TravelInfo>>();
		QueryResultInfo<TravelInfo> queryResultInfo = TravelConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}