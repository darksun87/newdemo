package com.crm.service.convertor;
import java.util.ArrayList;
import java.util.List;

import org.springframework.cglib.beans.BeanCopier;

import com.crm.message.CertificatePrintInfo;
import com.crm.message.CertificatePrintQueryInfo;
import com.crm.message.QueryResultInfo;
import com.crm.model.CertificatePrint;
import com.crm.model.CertificatePrintQuery;
import com.crm.model.QueryResult;

public abstract class CertificatePrintConvertor {

	private static final BeanCopier beanCopierForCertificatePrintInfo = BeanCopier.create(CertificatePrint.class, CertificatePrintInfo.class, false);
	private static final BeanCopier beanCopierForCertificatePrint = BeanCopier.create(CertificatePrintInfo.class, CertificatePrint.class, false);
	private static final BeanCopier beanCopierForCertificatePrintQuery = BeanCopier.create(CertificatePrintQueryInfo.class, CertificatePrintQuery.class, false);

	public static CertificatePrintInfo toCertificatePrintInfo(CertificatePrint certificatePrint)
	{
		if (certificatePrint == null) {
			return null;
		}
		CertificatePrintInfo certificatePrintInfo = new CertificatePrintInfo();
		beanCopierForCertificatePrintInfo.copy(certificatePrint, certificatePrintInfo, null);
		return certificatePrintInfo;
	}

	public static CertificatePrint toCertificatePrint(CertificatePrintInfo certificatePrintInfo)
	{
		CertificatePrint certificatePrint = new CertificatePrint();
		beanCopierForCertificatePrint.copy(certificatePrintInfo, certificatePrint, null);
		return certificatePrint;
	}

	public static List<CertificatePrintInfo> toCertificatePrintInfoList(List<CertificatePrint> certificatePrintList)
	{
		if (certificatePrintList == null || certificatePrintList.isEmpty()) {
			return null;
		}
		List<CertificatePrintInfo> certificatePrintInfoList = new ArrayList<CertificatePrintInfo>(certificatePrintList.size());
		for (CertificatePrint certificatePrint : certificatePrintList) {
			certificatePrintInfoList.add(toCertificatePrintInfo(certificatePrint));
		}
		return certificatePrintInfoList;
	}

	public static List<CertificatePrint> toCertificatePrintList(List<CertificatePrintInfo> certificatePrintInfoList)
	{
		if (certificatePrintInfoList == null || certificatePrintInfoList.isEmpty()) {
			return null;
		}
		List<CertificatePrint> certificatePrintList = new ArrayList<CertificatePrint>(certificatePrintInfoList.size());
		for (CertificatePrintInfo certificatePrintInfo : certificatePrintInfoList) {
			certificatePrintList.add(toCertificatePrint(certificatePrintInfo));
		}
		return certificatePrintList;
	}
	
	public static CertificatePrintQuery toCertificatePrintQuery(CertificatePrintQueryInfo certificatePrintQueryInfo)
	{
		if (certificatePrintQueryInfo== null) {
			return null;
		}
		CertificatePrintQuery certificatePrintQuery = new CertificatePrintQuery();
		beanCopierForCertificatePrintQuery.copy(certificatePrintQueryInfo, certificatePrintQuery, null);
		return certificatePrintQuery;
	}

	public static QueryResultInfo<CertificatePrintInfo> toQueryResultInfo(QueryResult<CertificatePrint> queryResult)
	{
		QueryResultInfo<CertificatePrintInfo> queryResultInfo = new QueryResultInfo<CertificatePrintInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toCertificatePrintInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}