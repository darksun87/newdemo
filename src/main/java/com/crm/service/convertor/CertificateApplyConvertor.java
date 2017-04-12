package com.crm.service.convertor;
import java.util.ArrayList;
import java.util.List;

import org.springframework.cglib.beans.BeanCopier;

import com.crm.message.CertificateApplyInfo;
import com.crm.message.CertificateApplyQueryInfo;
import com.crm.message.QueryResultInfo;
import com.crm.model.CertificateApply;
import com.crm.model.CertificateApplyQuery;
import com.crm.model.QueryResult;

public abstract class CertificateApplyConvertor {

	private static final BeanCopier beanCopierForCertificateApplyInfo = BeanCopier.create(CertificateApply.class, CertificateApplyInfo.class, false);
	private static final BeanCopier beanCopierForCertificateApply = BeanCopier.create(CertificateApplyInfo.class, CertificateApply.class, false);
	private static final BeanCopier beanCopierForCertificateApplyQuery = BeanCopier.create(CertificateApplyQueryInfo.class, CertificateApplyQuery.class, false);

	public static CertificateApplyInfo toCertificateApplyInfo(CertificateApply certificateApply)
	{
		if (certificateApply == null) {
			return null;
		}
		CertificateApplyInfo certificateApplyInfo = new CertificateApplyInfo();
		beanCopierForCertificateApplyInfo.copy(certificateApply, certificateApplyInfo, null);
		return certificateApplyInfo;
	}

	public static CertificateApply toCertificateApply(CertificateApplyInfo certificateApplyInfo)
	{
		CertificateApply certificateApply = new CertificateApply();
		beanCopierForCertificateApply.copy(certificateApplyInfo, certificateApply, null);
		return certificateApply;
	}

	public static List<CertificateApplyInfo> toCertificateApplyInfoList(List<CertificateApply> certificateApplyList)
	{
		if (certificateApplyList == null || certificateApplyList.isEmpty()) {
			return null;
		}
		List<CertificateApplyInfo> certificateApplyInfoList = new ArrayList<CertificateApplyInfo>(certificateApplyList.size());
		for (CertificateApply certificateApply : certificateApplyList) {
			certificateApplyInfoList.add(toCertificateApplyInfo(certificateApply));
		}
		return certificateApplyInfoList;
	}

	public static List<CertificateApply> toCertificateApplyList(List<CertificateApplyInfo> certificateApplyInfoList)
	{
		if (certificateApplyInfoList == null || certificateApplyInfoList.isEmpty()) {
			return null;
		}
		List<CertificateApply> certificateApplyList = new ArrayList<CertificateApply>(certificateApplyInfoList.size());
		for (CertificateApplyInfo certificateApplyInfo : certificateApplyInfoList) {
			certificateApplyList.add(toCertificateApply(certificateApplyInfo));
		}
		return certificateApplyList;
	}
	
	public static CertificateApplyQuery toCertificateApplyQuery(CertificateApplyQueryInfo certificateApplyQueryInfo)
	{
		if (certificateApplyQueryInfo== null) {
			return null;
		}
		CertificateApplyQuery certificateApplyQuery = new CertificateApplyQuery();
		beanCopierForCertificateApplyQuery.copy(certificateApplyQueryInfo, certificateApplyQuery, null);
		return certificateApplyQuery;
	}

	public static QueryResultInfo<CertificateApplyInfo> toQueryResultInfo(QueryResult<CertificateApply> queryResult)
	{
		QueryResultInfo<CertificateApplyInfo> queryResultInfo = new QueryResultInfo<CertificateApplyInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toCertificateApplyInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}