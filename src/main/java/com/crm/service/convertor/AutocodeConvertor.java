package com.crm.service.convertor;
import java.util.ArrayList;
import java.util.List;

import org.springframework.cglib.beans.BeanCopier;

import com.crm.message.AutocodeInfo;
import com.crm.message.AutocodeQueryInfo;
import com.crm.message.QueryResultInfo;
import com.crm.model.Autocode;
import com.crm.model.AutocodeQuery;
import com.crm.model.QueryResult;

public abstract class AutocodeConvertor {

	private static final BeanCopier beanCopierForAutocodeInfo = BeanCopier.create(Autocode.class, AutocodeInfo.class, false);
	private static final BeanCopier beanCopierForAutocode = BeanCopier.create(AutocodeInfo.class, Autocode.class, false);
	private static final BeanCopier beanCopierForAutocodeQuery = BeanCopier.create(AutocodeQueryInfo.class, AutocodeQuery.class, false);

	public static AutocodeInfo toAutocodeInfo(Autocode autocode)
	{
		if (autocode == null) {
			return null;
		}
		AutocodeInfo autocodeInfo = new AutocodeInfo();
		beanCopierForAutocodeInfo.copy(autocode, autocodeInfo, null);
		return autocodeInfo;
	}

	public static Autocode toAutocode(AutocodeInfo autocodeInfo)
	{
		Autocode autocode = new Autocode();
		beanCopierForAutocode.copy(autocodeInfo, autocode, null);
		return autocode;
	}

	public static List<AutocodeInfo> toAutocodeInfoList(List<Autocode> autocodeList)
	{
		if (autocodeList == null || autocodeList.isEmpty()) {
			return null;
		}
		List<AutocodeInfo> autocodeInfoList = new ArrayList<AutocodeInfo>(autocodeList.size());
		for (Autocode autocode : autocodeList) {
			autocodeInfoList.add(toAutocodeInfo(autocode));
		}
		return autocodeInfoList;
	}

	public static List<Autocode> toAutocodeList(List<AutocodeInfo> autocodeInfoList)
	{
		if (autocodeInfoList == null || autocodeInfoList.isEmpty()) {
			return null;
		}
		List<Autocode> autocodeList = new ArrayList<Autocode>(autocodeInfoList.size());
		for (AutocodeInfo autocodeInfo : autocodeInfoList) {
			autocodeList.add(toAutocode(autocodeInfo));
		}
		return autocodeList;
	}
	
	public static AutocodeQuery toAutocodeQuery(AutocodeQueryInfo autocodeQueryInfo)
	{
		if (autocodeQueryInfo== null) {
			return null;
		}
		AutocodeQuery autocodeQuery = new AutocodeQuery();
		beanCopierForAutocodeQuery.copy(autocodeQueryInfo, autocodeQuery, null);
		return autocodeQuery;
	}

	public static QueryResultInfo<AutocodeInfo> toQueryResultInfo(QueryResult<Autocode> queryResult)
	{
		QueryResultInfo<AutocodeInfo> queryResultInfo = new QueryResultInfo<AutocodeInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toAutocodeInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}