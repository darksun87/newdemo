
package com.crm.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.crm.biz.DepartmentBiz;

import com.crm.message.MessageInfo;
import com.crm.message.QueryResultInfo;
import com.crm.message.DepartmentInfo;
import com.crm.message.DepartmentQueryInfo;


import com.crm.model.Message;
import com.crm.model.QueryResult;
import com.crm.model.Department;
import com.crm.model.DepartmentQuery;


import com.crm.service.DepartmentService;
import com.crm.service.convertor.DepartmentConvertor;
import com.crm.service.convertor.MessageConvertor;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

	@Resource
	private DepartmentBiz departmentBiz;
			
	public MessageInfo<Integer> deleteDepartment(Integer id,String operatorId){
		
		Message<Integer> message  = departmentBiz.deleteDepartment(id,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Integer> createDepartment(DepartmentInfo departmentInfo){
		
		Department department = DepartmentConvertor.toDepartment(departmentInfo);
		Message<Integer> message  =  departmentBiz.createDepartment( department );
		MessageInfo<Integer> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateDepartment(DepartmentInfo departmentInfo){
		
		Department department = DepartmentConvertor.toDepartment(departmentInfo);
		Message<Integer> message  =  departmentBiz.updateDepartment( department );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<Integer> changeStatus(
			Integer id,
			Byte status,
			String operatorId){
			
		Message<Integer> message  = departmentBiz.changeStatus(id,status,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<DepartmentInfo> getDepartment( Integer id ){
		
		Message<Department> message  = departmentBiz.getDepartment( id );
		MessageInfo<DepartmentInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		DepartmentInfo departmentInfo = DepartmentConvertor.toDepartmentInfo(message.getData());
		messageInfo.setData(departmentInfo);
		return messageInfo;
	}

    public MessageInfo<List<DepartmentInfo>> getAllDepartment(){
	
		Message<List<Department>> message  = departmentBiz.getAllDepartment();
		MessageInfo<List<DepartmentInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<DepartmentInfo> departmentInfoList = DepartmentConvertor.toDepartmentInfoList(message.getData());
		messageInfo.setData(departmentInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<DepartmentInfo>> queryDepartment(DepartmentQueryInfo departmentQueryInfo) {
		DepartmentQuery departmentQuery = DepartmentConvertor.toDepartmentQuery(departmentQueryInfo);
		Message<QueryResult<Department>> message = departmentBiz.queryDepartment(departmentQuery);
		MessageInfo<QueryResultInfo<DepartmentInfo>> messageInfo = new MessageInfo<QueryResultInfo<DepartmentInfo>>();
		QueryResultInfo<DepartmentInfo> queryResultInfo = DepartmentConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}