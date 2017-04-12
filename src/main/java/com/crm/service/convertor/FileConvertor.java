package com.crm.service.convertor;
import java.util.ArrayList;
import java.util.List;

import org.springframework.cglib.beans.BeanCopier;

import com.crm.message.FileInfo;
import com.crm.message.FileQueryInfo;
import com.crm.message.QueryResultInfo;
import com.crm.model.File;
import com.crm.model.FileQuery;
import com.crm.model.QueryResult;

public abstract class FileConvertor {

	private static final BeanCopier beanCopierForFileInfo = BeanCopier.create(File.class, FileInfo.class, false);
	private static final BeanCopier beanCopierForFile = BeanCopier.create(FileInfo.class, File.class, false);
	private static final BeanCopier beanCopierForFileQuery = BeanCopier.create(FileQueryInfo.class, FileQuery.class, false);

	public static FileInfo toFileInfo(File file)
	{
		if (file == null) {
			return null;
		}
		FileInfo fileInfo = new FileInfo();
		beanCopierForFileInfo.copy(file, fileInfo, null);
		return fileInfo;
	}

	public static File toFile(FileInfo fileInfo)
	{
		File file = new File();
		beanCopierForFile.copy(fileInfo, file, null);
		return file;
	}

	public static List<FileInfo> toFileInfoList(List<File> fileList)
	{
		if (fileList == null || fileList.isEmpty()) {
			return null;
		}
		List<FileInfo> fileInfoList = new ArrayList<FileInfo>(fileList.size());
		for (File file : fileList) {
			fileInfoList.add(toFileInfo(file));
		}
		return fileInfoList;
	}

	public static List<File> toFileList(List<FileInfo> fileInfoList)
	{
		if (fileInfoList == null || fileInfoList.isEmpty()) {
			return null;
		}
		List<File> fileList = new ArrayList<File>(fileInfoList.size());
		for (FileInfo fileInfo : fileInfoList) {
			fileList.add(toFile(fileInfo));
		}
		return fileList;
	}
	
	public static FileQuery toFileQuery(FileQueryInfo fileQueryInfo)
	{
		if (fileQueryInfo== null) {
			return null;
		}
		FileQuery fileQuery = new FileQuery();
		beanCopierForFileQuery.copy(fileQueryInfo, fileQuery, null);
		return fileQuery;
	}

	public static QueryResultInfo<FileInfo> toQueryResultInfo(QueryResult<File> queryResult)
	{
		QueryResultInfo<FileInfo> queryResultInfo = new QueryResultInfo<FileInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toFileInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}