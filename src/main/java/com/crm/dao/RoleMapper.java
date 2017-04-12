package com.crm.dao;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.crm.model.Role;
import com.crm.model.RoleQuery;

public interface RoleMapper {
	
	int deleteByPrimaryKey(Integer id);
	
		
	int logicalDeleteByPrimaryKey(
        		@Param("id")Integer id,
        		@Param("updateUserid")String updateUserid,
        		@Param("updateTime")Long updateTime);
	
    int insert(Role role);

    Role selectByPrimaryKey(Integer id);

	Role selectByPrimaryKeyForUpdate(Integer id);
	
    List<Role> selectAll();

	List<Role> queryRole(RoleQuery roleQuery);
			
    int updateByPrimaryKey(Role role);
	
			
	int changeStatus(
		@Param("id")Integer id,
		@Param("status")Byte status,
		@Param("updateUserid")String updateUserid,
		@Param("updateTime")Long updateTime);
		

}