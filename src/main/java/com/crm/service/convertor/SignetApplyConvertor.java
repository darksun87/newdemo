package com.crm.service.convertor;
import java.util.ArrayList;
import java.util.List;

import org.springframework.cglib.beans.BeanCopier;

import com.crm.message.SignetApplyInfo;
import com.crm.message.SignetApplyQueryInfo;
import com.crm.message.QueryResultInfo;
import com.crm.model.SignetApply;
import com.crm.model.SignetApplyQuery;
import com.crm.model.QueryResult;

public abstract class SignetApplyConvertor {

	private static final BeanCopier beanCopierForSignetApplyInfo = BeanCopier.create(SignetApply.class, SignetApplyInfo.class, false);
	private static final BeanCopier beanCopierForSignetApply = BeanCopier.create(SignetApplyInfo.class, SignetApply.class, false);
	private static final BeanCopier beanCopierForSignetApplyQuery = BeanCopier.create(SignetApplyQueryInfo.class, SignetApplyQuery.class, false);

	public static SignetApplyInfo toSignetApplyInfo(SignetApply signetApply)
	{
		if (signetApply == null) {
			return null;
		}
		SignetApplyInfo signetApplyInfo = new SignetApplyInfo();
		beanCopierForSignetApplyInfo.copy(signetApply, signetApplyInfo, null);
		return signetApplyInfo;
	}

	public static SignetApply toSignetApply(SignetApplyInfo signetApplyInfo)
	{
		SignetApply signetApply = new SignetApply();
		beanCopierForSignetApply.copy(signetApplyInfo, signetApply, null);
		return signetApply;
	}

	public static List<SignetApplyInfo> toSignetApplyInfoList(List<SignetApply> signetApplyList)
	{
		if (signetApplyList == null || signetApplyList.isEmpty()) {
			return null;
		}
		List<SignetApplyInfo> signetApplyInfoList = new ArrayList<SignetApplyInfo>(signetApplyList.size());
		for (SignetApply signetApply : signetApplyList) {
			signetApplyInfoList.add(toSignetApplyInfo(signetApply));
		}
		return signetApplyInfoList;
	}

	public static List<SignetApply> toSignetApplyList(List<SignetApplyInfo> signetApplyInfoList)
	{
		if (signetApplyInfoList == null || signetApplyInfoList.isEmpty()) {
			return null;
		}
		List<SignetApply> signetApplyList = new ArrayList<SignetApply>(signetApplyInfoList.size());
		for (SignetApplyInfo signetApplyInfo : signetApplyInfoList) {
			signetApplyList.add(toSignetApply(signetApplyInfo));
		}
		return signetApplyList;
	}
	
	public static SignetApplyQuery toSignetApplyQuery(SignetApplyQueryInfo signetApplyQueryInfo)
	{
		if (signetApplyQueryInfo== null) {
			return null;
		}
		SignetApplyQuery signetApplyQuery = new SignetApplyQuery();
		beanCopierForSignetApplyQuery.copy(signetApplyQueryInfo, signetApplyQuery, null);
		return signetApplyQuery;
	}

	public static QueryResultInfo<SignetApplyInfo> toQueryResultInfo(QueryResult<SignetApply> queryResult)
	{
		QueryResultInfo<SignetApplyInfo> queryResultInfo = new QueryResultInfo<SignetApplyInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toSignetApplyInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}