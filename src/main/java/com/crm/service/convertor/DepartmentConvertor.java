package com.crm.service.convertor;
import java.util.ArrayList;
import java.util.List;

import org.springframework.cglib.beans.BeanCopier;

import com.crm.message.DepartmentInfo;
import com.crm.message.DepartmentQueryInfo;
import com.crm.message.QueryResultInfo;
import com.crm.model.Department;
import com.crm.model.DepartmentQuery;
import com.crm.model.QueryResult;

public abstract class DepartmentConvertor {

	private static final BeanCopier beanCopierForDepartmentInfo = BeanCopier.create(Department.class, DepartmentInfo.class, false);
	private static final BeanCopier beanCopierForDepartment = BeanCopier.create(DepartmentInfo.class, Department.class, false);
	private static final BeanCopier beanCopierForDepartmentQuery = BeanCopier.create(DepartmentQueryInfo.class, DepartmentQuery.class, false);

	public static DepartmentInfo toDepartmentInfo(Department department)
	{
		if (department == null) {
			return null;
		}
		DepartmentInfo departmentInfo = new DepartmentInfo();
		beanCopierForDepartmentInfo.copy(department, departmentInfo, null);
		return departmentInfo;
	}

	public static Department toDepartment(DepartmentInfo departmentInfo)
	{
		Department department = new Department();
		beanCopierForDepartment.copy(departmentInfo, department, null);
		return department;
	}

	public static List<DepartmentInfo> toDepartmentInfoList(List<Department> departmentList)
	{
		if (departmentList == null || departmentList.isEmpty()) {
			return null;
		}
		List<DepartmentInfo> departmentInfoList = new ArrayList<DepartmentInfo>(departmentList.size());
		for (Department department : departmentList) {
			departmentInfoList.add(toDepartmentInfo(department));
		}
		return departmentInfoList;
	}

	public static List<Department> toDepartmentList(List<DepartmentInfo> departmentInfoList)
	{
		if (departmentInfoList == null || departmentInfoList.isEmpty()) {
			return null;
		}
		List<Department> departmentList = new ArrayList<Department>(departmentInfoList.size());
		for (DepartmentInfo departmentInfo : departmentInfoList) {
			departmentList.add(toDepartment(departmentInfo));
		}
		return departmentList;
	}
	
	public static DepartmentQuery toDepartmentQuery(DepartmentQueryInfo departmentQueryInfo)
	{
		if (departmentQueryInfo== null) {
			return null;
		}
		DepartmentQuery departmentQuery = new DepartmentQuery();
		beanCopierForDepartmentQuery.copy(departmentQueryInfo, departmentQuery, null);
		return departmentQuery;
	}

	public static QueryResultInfo<DepartmentInfo> toQueryResultInfo(QueryResult<Department> queryResult)
	{
		QueryResultInfo<DepartmentInfo> queryResultInfo = new QueryResultInfo<DepartmentInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toDepartmentInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}