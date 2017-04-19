package com.crm.dao;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.crm.model.RolePermission;
import com.crm.model.RolePermissionQuery;

public interface RolePermissionMapper {
	
	int deleteByPrimaryKey(Integer id);
	
		
	int logicalDeleteByPrimaryKey(
        		@Param("id")Integer id,
        		@Param("updateUserid")String updateUserid,
        		@Param("updateTime")Long updateTime);
	
    int insert(RolePermission rolePermission);

    RolePermission selectByPrimaryKey(Integer id);

	RolePermission selectByPrimaryKeyForUpdate(Integer id);
	
    List<RolePermission> selectAll();

	List<RolePermission> queryRolePermission(RolePermissionQuery rolePermissionQuery);
			
    int updateByPrimaryKey(RolePermission rolePermission);
	
			
	int changeStatus(
		@Param("id")Integer id,
		@Param("status")Byte status,
		@Param("updateUserid")String updateUserid,
		@Param("updateTime")Long updateTime);
		

}