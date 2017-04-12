package com.crm.service.convertor;
import java.util.ArrayList;
import java.util.List;

import org.springframework.cglib.beans.BeanCopier;

import com.crm.message.SignetApplyFileInfo;
import com.crm.message.SignetApplyFileQueryInfo;
import com.crm.message.QueryResultInfo;
import com.crm.model.SignetApplyFile;
import com.crm.model.SignetApplyFileQuery;
import com.crm.model.QueryResult;

public abstract class SignetApplyFileConvertor {

	private static final BeanCopier beanCopierForSignetApplyFileInfo = BeanCopier.create(SignetApplyFile.class, SignetApplyFileInfo.class, false);
	private static final BeanCopier beanCopierForSignetApplyFile = BeanCopier.create(SignetApplyFileInfo.class, SignetApplyFile.class, false);
	private static final BeanCopier beanCopierForSignetApplyFileQuery = BeanCopier.create(SignetApplyFileQueryInfo.class, SignetApplyFileQuery.class, false);

	public static SignetApplyFileInfo toSignetApplyFileInfo(SignetApplyFile signetApplyFile)
	{
		if (signetApplyFile == null) {
			return null;
		}
		SignetApplyFileInfo signetApplyFileInfo = new SignetApplyFileInfo();
		beanCopierForSignetApplyFileInfo.copy(signetApplyFile, signetApplyFileInfo, null);
		return signetApplyFileInfo;
	}

	public static SignetApplyFile toSignetApplyFile(SignetApplyFileInfo signetApplyFileInfo)
	{
		SignetApplyFile signetApplyFile = new SignetApplyFile();
		beanCopierForSignetApplyFile.copy(signetApplyFileInfo, signetApplyFile, null);
		return signetApplyFile;
	}

	public static List<SignetApplyFileInfo> toSignetApplyFileInfoList(List<SignetApplyFile> signetApplyFileList)
	{
		if (signetApplyFileList == null || signetApplyFileList.isEmpty()) {
			return null;
		}
		List<SignetApplyFileInfo> signetApplyFileInfoList = new ArrayList<SignetApplyFileInfo>(signetApplyFileList.size());
		for (SignetApplyFile signetApplyFile : signetApplyFileList) {
			signetApplyFileInfoList.add(toSignetApplyFileInfo(signetApplyFile));
		}
		return signetApplyFileInfoList;
	}

	public static List<SignetApplyFile> toSignetApplyFileList(List<SignetApplyFileInfo> signetApplyFileInfoList)
	{
		if (signetApplyFileInfoList == null || signetApplyFileInfoList.isEmpty()) {
			return null;
		}
		List<SignetApplyFile> signetApplyFileList = new ArrayList<SignetApplyFile>(signetApplyFileInfoList.size());
		for (SignetApplyFileInfo signetApplyFileInfo : signetApplyFileInfoList) {
			signetApplyFileList.add(toSignetApplyFile(signetApplyFileInfo));
		}
		return signetApplyFileList;
	}
	
	public static SignetApplyFileQuery toSignetApplyFileQuery(SignetApplyFileQueryInfo signetApplyFileQueryInfo)
	{
		if (signetApplyFileQueryInfo== null) {
			return null;
		}
		SignetApplyFileQuery signetApplyFileQuery = new SignetApplyFileQuery();
		beanCopierForSignetApplyFileQuery.copy(signetApplyFileQueryInfo, signetApplyFileQuery, null);
		return signetApplyFileQuery;
	}

	public static QueryResultInfo<SignetApplyFileInfo> toQueryResultInfo(QueryResult<SignetApplyFile> queryResult)
	{
		QueryResultInfo<SignetApplyFileInfo> queryResultInfo = new QueryResultInfo<SignetApplyFileInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toSignetApplyFileInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}