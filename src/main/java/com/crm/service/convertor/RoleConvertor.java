package com.crm.service.convertor;
import java.util.ArrayList;
import java.util.List;

import org.springframework.cglib.beans.BeanCopier;

import com.crm.message.RoleInfo;
import com.crm.message.RoleQueryInfo;
import com.crm.message.QueryResultInfo;
import com.crm.model.Role;
import com.crm.model.RoleQuery;
import com.crm.model.QueryResult;

public abstract class RoleConvertor {

	private static final BeanCopier beanCopierForRoleInfo = BeanCopier.create(Role.class, RoleInfo.class, false);
	private static final BeanCopier beanCopierForRole = BeanCopier.create(RoleInfo.class, Role.class, false);
	private static final BeanCopier beanCopierForRoleQuery = BeanCopier.create(RoleQueryInfo.class, RoleQuery.class, false);

	public static RoleInfo toRoleInfo(Role role)
	{
		if (role == null) {
			return null;
		}
		RoleInfo roleInfo = new RoleInfo();
		beanCopierForRoleInfo.copy(role, roleInfo, null);
		return roleInfo;
	}

	public static Role toRole(RoleInfo roleInfo)
	{
		Role role = new Role();
		beanCopierForRole.copy(roleInfo, role, null);
		return role;
	}

	public static List<RoleInfo> toRoleInfoList(List<Role> roleList)
	{
		if (roleList == null || roleList.isEmpty()) {
			return null;
		}
		List<RoleInfo> roleInfoList = new ArrayList<RoleInfo>(roleList.size());
		for (Role role : roleList) {
			roleInfoList.add(toRoleInfo(role));
		}
		return roleInfoList;
	}

	public static List<Role> toRoleList(List<RoleInfo> roleInfoList)
	{
		if (roleInfoList == null || roleInfoList.isEmpty()) {
			return null;
		}
		List<Role> roleList = new ArrayList<Role>(roleInfoList.size());
		for (RoleInfo roleInfo : roleInfoList) {
			roleList.add(toRole(roleInfo));
		}
		return roleList;
	}
	
	public static RoleQuery toRoleQuery(RoleQueryInfo roleQueryInfo)
	{
		if (roleQueryInfo== null) {
			return null;
		}
		RoleQuery roleQuery = new RoleQuery();
		beanCopierForRoleQuery.copy(roleQueryInfo, roleQuery, null);
		return roleQuery;
	}

	public static QueryResultInfo<RoleInfo> toQueryResultInfo(QueryResult<Role> queryResult)
	{
		QueryResultInfo<RoleInfo> queryResultInfo = new QueryResultInfo<RoleInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toRoleInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}