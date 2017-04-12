package com.crm.dao;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.crm.model.Department;
import com.crm.model.DepartmentQuery;

public interface DepartmentMapper {
	
	int deleteByPrimaryKey(Integer id);
	
		
	int logicalDeleteByPrimaryKey(
        		@Param("id")Integer id,
        		@Param("updateUserid")String updateUserid,
        		@Param("updateTime")Long updateTime);
	
    int insert(Department department);

    Department selectByPrimaryKey(Integer id);

	Department selectByPrimaryKeyForUpdate(Integer id);
	
    List<Department> selectAll();

	List<Department> queryDepartment(DepartmentQuery departmentQuery);
			
    int updateByPrimaryKey(Department department);
	
			
	int changeStatus(
		@Param("id")Integer id,
		@Param("status")Byte status,
		@Param("updateUserid")String updateUserid,
		@Param("updateTime")Long updateTime);
		

}