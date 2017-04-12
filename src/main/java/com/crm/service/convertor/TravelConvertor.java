package com.crm.service.convertor;
import java.util.ArrayList;
import java.util.List;

import org.springframework.cglib.beans.BeanCopier;

import com.crm.message.TravelInfo;
import com.crm.message.TravelQueryInfo;
import com.crm.message.QueryResultInfo;
import com.crm.model.Travel;
import com.crm.model.TravelQuery;
import com.crm.model.QueryResult;

public abstract class TravelConvertor {

	private static final BeanCopier beanCopierForTravelInfo = BeanCopier.create(Travel.class, TravelInfo.class, false);
	private static final BeanCopier beanCopierForTravel = BeanCopier.create(TravelInfo.class, Travel.class, false);
	private static final BeanCopier beanCopierForTravelQuery = BeanCopier.create(TravelQueryInfo.class, TravelQuery.class, false);

	public static TravelInfo toTravelInfo(Travel travel)
	{
		if (travel == null) {
			return null;
		}
		TravelInfo travelInfo = new TravelInfo();
		beanCopierForTravelInfo.copy(travel, travelInfo, null);
		return travelInfo;
	}

	public static Travel toTravel(TravelInfo travelInfo)
	{
		Travel travel = new Travel();
		beanCopierForTravel.copy(travelInfo, travel, null);
		return travel;
	}

	public static List<TravelInfo> toTravelInfoList(List<Travel> travelList)
	{
		if (travelList == null || travelList.isEmpty()) {
			return null;
		}
		List<TravelInfo> travelInfoList = new ArrayList<TravelInfo>(travelList.size());
		for (Travel travel : travelList) {
			travelInfoList.add(toTravelInfo(travel));
		}
		return travelInfoList;
	}

	public static List<Travel> toTravelList(List<TravelInfo> travelInfoList)
	{
		if (travelInfoList == null || travelInfoList.isEmpty()) {
			return null;
		}
		List<Travel> travelList = new ArrayList<Travel>(travelInfoList.size());
		for (TravelInfo travelInfo : travelInfoList) {
			travelList.add(toTravel(travelInfo));
		}
		return travelList;
	}
	
	public static TravelQuery toTravelQuery(TravelQueryInfo travelQueryInfo)
	{
		if (travelQueryInfo== null) {
			return null;
		}
		TravelQuery travelQuery = new TravelQuery();
		beanCopierForTravelQuery.copy(travelQueryInfo, travelQuery, null);
		return travelQuery;
	}

	public static QueryResultInfo<TravelInfo> toQueryResultInfo(QueryResult<Travel> queryResult)
	{
		QueryResultInfo<TravelInfo> queryResultInfo = new QueryResultInfo<TravelInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toTravelInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}