package com.crm.service.convertor;
import java.util.ArrayList;
import java.util.List;

import org.springframework.cglib.beans.BeanCopier;

import com.crm.message.FileRoleInfo;
import com.crm.message.FileRoleQueryInfo;
import com.crm.message.QueryResultInfo;
import com.crm.model.FileRole;
import com.crm.model.FileRoleQuery;
import com.crm.model.QueryResult;

public abstract class FileRoleConvertor {

	private static final BeanCopier beanCopierForFileRoleInfo = BeanCopier.create(FileRole.class, FileRoleInfo.class, false);
	private static final BeanCopier beanCopierForFileRole = BeanCopier.create(FileRoleInfo.class, FileRole.class, false);
	private static final BeanCopier beanCopierForFileRoleQuery = BeanCopier.create(FileRoleQueryInfo.class, FileRoleQuery.class, false);

	public static FileRoleInfo toFileRoleInfo(FileRole fileRole)
	{
		if (fileRole == null) {
			return null;
		}
		FileRoleInfo fileRoleInfo = new FileRoleInfo();
		beanCopierForFileRoleInfo.copy(fileRole, fileRoleInfo, null);
		return fileRoleInfo;
	}

	public static FileRole toFileRole(FileRoleInfo fileRoleInfo)
	{
		FileRole fileRole = new FileRole();
		beanCopierForFileRole.copy(fileRoleInfo, fileRole, null);
		return fileRole;
	}

	public static List<FileRoleInfo> toFileRoleInfoList(List<FileRole> fileRoleList)
	{
		if (fileRoleList == null || fileRoleList.isEmpty()) {
			return null;
		}
		List<FileRoleInfo> fileRoleInfoList = new ArrayList<FileRoleInfo>(fileRoleList.size());
		for (FileRole fileRole : fileRoleList) {
			fileRoleInfoList.add(toFileRoleInfo(fileRole));
		}
		return fileRoleInfoList;
	}

	public static List<FileRole> toFileRoleList(List<FileRoleInfo> fileRoleInfoList)
	{
		if (fileRoleInfoList == null || fileRoleInfoList.isEmpty()) {
			return null;
		}
		List<FileRole> fileRoleList = new ArrayList<FileRole>(fileRoleInfoList.size());
		for (FileRoleInfo fileRoleInfo : fileRoleInfoList) {
			fileRoleList.add(toFileRole(fileRoleInfo));
		}
		return fileRoleList;
	}
	
	public static FileRoleQuery toFileRoleQuery(FileRoleQueryInfo fileRoleQueryInfo)
	{
		if (fileRoleQueryInfo== null) {
			return null;
		}
		FileRoleQuery fileRoleQuery = new FileRoleQuery();
		beanCopierForFileRoleQuery.copy(fileRoleQueryInfo, fileRoleQuery, null);
		return fileRoleQuery;
	}

	public static QueryResultInfo<FileRoleInfo> toQueryResultInfo(QueryResult<FileRole> queryResult)
	{
		QueryResultInfo<FileRoleInfo> queryResultInfo = new QueryResultInfo<FileRoleInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toFileRoleInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}