package com.crm.service.convertor;
import java.util.ArrayList;
import java.util.List;

import org.springframework.cglib.beans.BeanCopier;

import com.crm.message.SignetInfo;
import com.crm.message.SignetQueryInfo;
import com.crm.message.QueryResultInfo;
import com.crm.model.Signet;
import com.crm.model.SignetQuery;
import com.crm.model.QueryResult;

public abstract class SignetConvertor {

	private static final BeanCopier beanCopierForSignetInfo = BeanCopier.create(Signet.class, SignetInfo.class, false);
	private static final BeanCopier beanCopierForSignet = BeanCopier.create(SignetInfo.class, Signet.class, false);
	private static final BeanCopier beanCopierForSignetQuery = BeanCopier.create(SignetQueryInfo.class, SignetQuery.class, false);

	public static SignetInfo toSignetInfo(Signet signet)
	{
		if (signet == null) {
			return null;
		}
		SignetInfo signetInfo = new SignetInfo();
		beanCopierForSignetInfo.copy(signet, signetInfo, null);
		return signetInfo;
	}

	public static Signet toSignet(SignetInfo signetInfo)
	{
		Signet signet = new Signet();
		beanCopierForSignet.copy(signetInfo, signet, null);
		return signet;
	}

	public static List<SignetInfo> toSignetInfoList(List<Signet> signetList)
	{
		if (signetList == null || signetList.isEmpty()) {
			return null;
		}
		List<SignetInfo> signetInfoList = new ArrayList<SignetInfo>(signetList.size());
		for (Signet signet : signetList) {
			signetInfoList.add(toSignetInfo(signet));
		}
		return signetInfoList;
	}

	public static List<Signet> toSignetList(List<SignetInfo> signetInfoList)
	{
		if (signetInfoList == null || signetInfoList.isEmpty()) {
			return null;
		}
		List<Signet> signetList = new ArrayList<Signet>(signetInfoList.size());
		for (SignetInfo signetInfo : signetInfoList) {
			signetList.add(toSignet(signetInfo));
		}
		return signetList;
	}
	
	public static SignetQuery toSignetQuery(SignetQueryInfo signetQueryInfo)
	{
		if (signetQueryInfo== null) {
			return null;
		}
		SignetQuery signetQuery = new SignetQuery();
		beanCopierForSignetQuery.copy(signetQueryInfo, signetQuery, null);
		return signetQuery;
	}

	public static QueryResultInfo<SignetInfo> toQueryResultInfo(QueryResult<Signet> queryResult)
	{
		QueryResultInfo<SignetInfo> queryResultInfo = new QueryResultInfo<SignetInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toSignetInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}