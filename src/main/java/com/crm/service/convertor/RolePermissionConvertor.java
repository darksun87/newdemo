package com.crm.service.convertor;
import java.util.ArrayList;
import java.util.List;

import org.springframework.cglib.beans.BeanCopier;

import com.crm.message.RolePermissionInfo;
import com.crm.message.RolePermissionQueryInfo;
import com.crm.message.QueryResultInfo;
import com.crm.model.RolePermission;
import com.crm.model.RolePermissionQuery;
import com.crm.model.QueryResult;

public abstract class RolePermissionConvertor {

	private static final BeanCopier beanCopierForRolePermissionInfo = BeanCopier.create(RolePermission.class, RolePermissionInfo.class, false);
	private static final BeanCopier beanCopierForRolePermission = BeanCopier.create(RolePermissionInfo.class, RolePermission.class, false);
	private static final BeanCopier beanCopierForRolePermissionQuery = BeanCopier.create(RolePermissionQueryInfo.class, RolePermissionQuery.class, false);

	public static RolePermissionInfo toRolePermissionInfo(RolePermission rolePermission)
	{
		if (rolePermission == null) {
			return null;
		}
		RolePermissionInfo rolePermissionInfo = new RolePermissionInfo();
		beanCopierForRolePermissionInfo.copy(rolePermission, rolePermissionInfo, null);
		return rolePermissionInfo;
	}

	public static RolePermission toRolePermission(RolePermissionInfo rolePermissionInfo)
	{
		RolePermission rolePermission = new RolePermission();
		beanCopierForRolePermission.copy(rolePermissionInfo, rolePermission, null);
		return rolePermission;
	}

	public static List<RolePermissionInfo> toRolePermissionInfoList(List<RolePermission> rolePermissionList)
	{
		if (rolePermissionList == null || rolePermissionList.isEmpty()) {
			return null;
		}
		List<RolePermissionInfo> rolePermissionInfoList = new ArrayList<RolePermissionInfo>(rolePermissionList.size());
		for (RolePermission rolePermission : rolePermissionList) {
			rolePermissionInfoList.add(toRolePermissionInfo(rolePermission));
		}
		return rolePermissionInfoList;
	}

	public static List<RolePermission> toRolePermissionList(List<RolePermissionInfo> rolePermissionInfoList)
	{
		if (rolePermissionInfoList == null || rolePermissionInfoList.isEmpty()) {
			return null;
		}
		List<RolePermission> rolePermissionList = new ArrayList<RolePermission>(rolePermissionInfoList.size());
		for (RolePermissionInfo rolePermissionInfo : rolePermissionInfoList) {
			rolePermissionList.add(toRolePermission(rolePermissionInfo));
		}
		return rolePermissionList;
	}
	
	public static RolePermissionQuery toRolePermissionQuery(RolePermissionQueryInfo rolePermissionQueryInfo)
	{
		if (rolePermissionQueryInfo== null) {
			return null;
		}
		RolePermissionQuery rolePermissionQuery = new RolePermissionQuery();
		beanCopierForRolePermissionQuery.copy(rolePermissionQueryInfo, rolePermissionQuery, null);
		return rolePermissionQuery;
	}

	public static QueryResultInfo<RolePermissionInfo> toQueryResultInfo(QueryResult<RolePermission> queryResult)
	{
		QueryResultInfo<RolePermissionInfo> queryResultInfo = new QueryResultInfo<RolePermissionInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toRolePermissionInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}