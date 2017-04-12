package com.crm.service;


import java.util.List;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.TravelInfo;
import com.crm.message.TravelQueryInfo;

public interface TravelService {
		
	MessageInfo<Integer> deleteTravel(Integer id,String operatorId);
		
    MessageInfo<Integer> createTravel(TravelInfo travelInfo);
		
	MessageInfo<Integer> updateTravel(TravelInfo travelInfo);
			
	MessageInfo<Integer> changeStatus(Integer id,Byte status,String operatorId);
		
	MessageInfo<TravelInfo> getTravel( Integer id );
		
    MessageInfo<List<TravelInfo>> getAllTravel();
			
    MessageInfo<QueryResultInfo<TravelInfo>> queryTravel(TravelQueryInfo travelQueryInfo);
	
	

}