package com.crm.service;


import java.util.List;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.DepartmentInfo;
import com.crm.message.DepartmentQueryInfo;

public interface DepartmentService {
		
	MessageInfo<Integer> deleteDepartment(Integer id,String operatorId);
		
    MessageInfo<Integer> createDepartment(DepartmentInfo departmentInfo);
		
	MessageInfo<Integer> updateDepartment(DepartmentInfo departmentInfo);
			
	MessageInfo<Integer> changeStatus(Integer id,Byte status,String operatorId);
		
	MessageInfo<DepartmentInfo> getDepartment( Integer id );
		
    MessageInfo<List<DepartmentInfo>> getAllDepartment();
			
    MessageInfo<QueryResultInfo<DepartmentInfo>> queryDepartment(DepartmentQueryInfo departmentQueryInfo);
	
	

}