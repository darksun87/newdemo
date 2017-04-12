package com.crm.service.convertor;
import java.util.ArrayList;
import java.util.List;

import org.springframework.cglib.beans.BeanCopier;

import com.crm.message.FileTypeInfo;
import com.crm.message.FileTypeQueryInfo;
import com.crm.message.QueryResultInfo;
import com.crm.model.FileType;
import com.crm.model.FileTypeQuery;
import com.crm.model.QueryResult;

public abstract class FileTypeConvertor {

	private static final BeanCopier beanCopierForFileTypeInfo = BeanCopier.create(FileType.class, FileTypeInfo.class, false);
	private static final BeanCopier beanCopierForFileType = BeanCopier.create(FileTypeInfo.class, FileType.class, false);
	private static final BeanCopier beanCopierForFileTypeQuery = BeanCopier.create(FileTypeQueryInfo.class, FileTypeQuery.class, false);

	public static FileTypeInfo toFileTypeInfo(FileType fileType)
	{
		if (fileType == null) {
			return null;
		}
		FileTypeInfo fileTypeInfo = new FileTypeInfo();
		beanCopierForFileTypeInfo.copy(fileType, fileTypeInfo, null);
		return fileTypeInfo;
	}

	public static FileType toFileType(FileTypeInfo fileTypeInfo)
	{
		FileType fileType = new FileType();
		beanCopierForFileType.copy(fileTypeInfo, fileType, null);
		return fileType;
	}

	public static List<FileTypeInfo> toFileTypeInfoList(List<FileType> fileTypeList)
	{
		if (fileTypeList == null || fileTypeList.isEmpty()) {
			return null;
		}
		List<FileTypeInfo> fileTypeInfoList = new ArrayList<FileTypeInfo>(fileTypeList.size());
		for (FileType fileType : fileTypeList) {
			fileTypeInfoList.add(toFileTypeInfo(fileType));
		}
		return fileTypeInfoList;
	}

	public static List<FileType> toFileTypeList(List<FileTypeInfo> fileTypeInfoList)
	{
		if (fileTypeInfoList == null || fileTypeInfoList.isEmpty()) {
			return null;
		}
		List<FileType> fileTypeList = new ArrayList<FileType>(fileTypeInfoList.size());
		for (FileTypeInfo fileTypeInfo : fileTypeInfoList) {
			fileTypeList.add(toFileType(fileTypeInfo));
		}
		return fileTypeList;
	}
	
	public static FileTypeQuery toFileTypeQuery(FileTypeQueryInfo fileTypeQueryInfo)
	{
		if (fileTypeQueryInfo== null) {
			return null;
		}
		FileTypeQuery fileTypeQuery = new FileTypeQuery();
		beanCopierForFileTypeQuery.copy(fileTypeQueryInfo, fileTypeQuery, null);
		return fileTypeQuery;
	}

	public static QueryResultInfo<FileTypeInfo> toQueryResultInfo(QueryResult<FileType> queryResult)
	{
		QueryResultInfo<FileTypeInfo> queryResultInfo = new QueryResultInfo<FileTypeInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toFileTypeInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}