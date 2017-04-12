package com.crm.service.convertor;
import java.util.ArrayList;
import java.util.List;

import org.springframework.cglib.beans.BeanCopier;

import com.crm.message.CertificateInfo;
import com.crm.message.CertificateQueryInfo;
import com.crm.message.QueryResultInfo;
import com.crm.model.Certificate;
import com.crm.model.CertificateQuery;
import com.crm.model.QueryResult;

public abstract class CertificateConvertor {

	private static final BeanCopier beanCopierForCertificateInfo = BeanCopier.create(Certificate.class, CertificateInfo.class, false);
	private static final BeanCopier beanCopierForCertificate = BeanCopier.create(CertificateInfo.class, Certificate.class, false);
	private static final BeanCopier beanCopierForCertificateQuery = BeanCopier.create(CertificateQueryInfo.class, CertificateQuery.class, false);

	public static CertificateInfo toCertificateInfo(Certificate certificate)
	{
		if (certificate == null) {
			return null;
		}
		CertificateInfo certificateInfo = new CertificateInfo();
		beanCopierForCertificateInfo.copy(certificate, certificateInfo, null);
		return certificateInfo;
	}

	public static Certificate toCertificate(CertificateInfo certificateInfo)
	{
		Certificate certificate = new Certificate();
		beanCopierForCertificate.copy(certificateInfo, certificate, null);
		return certificate;
	}

	public static List<CertificateInfo> toCertificateInfoList(List<Certificate> certificateList)
	{
		if (certificateList == null || certificateList.isEmpty()) {
			return null;
		}
		List<CertificateInfo> certificateInfoList = new ArrayList<CertificateInfo>(certificateList.size());
		for (Certificate certificate : certificateList) {
			certificateInfoList.add(toCertificateInfo(certificate));
		}
		return certificateInfoList;
	}

	public static List<Certificate> toCertificateList(List<CertificateInfo> certificateInfoList)
	{
		if (certificateInfoList == null || certificateInfoList.isEmpty()) {
			return null;
		}
		List<Certificate> certificateList = new ArrayList<Certificate>(certificateInfoList.size());
		for (CertificateInfo certificateInfo : certificateInfoList) {
			certificateList.add(toCertificate(certificateInfo));
		}
		return certificateList;
	}
	
	public static CertificateQuery toCertificateQuery(CertificateQueryInfo certificateQueryInfo)
	{
		if (certificateQueryInfo== null) {
			return null;
		}
		CertificateQuery certificateQuery = new CertificateQuery();
		beanCopierForCertificateQuery.copy(certificateQueryInfo, certificateQuery, null);
		return certificateQuery;
	}

	public static QueryResultInfo<CertificateInfo> toQueryResultInfo(QueryResult<Certificate> queryResult)
	{
		QueryResultInfo<CertificateInfo> queryResultInfo = new QueryResultInfo<CertificateInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toCertificateInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}