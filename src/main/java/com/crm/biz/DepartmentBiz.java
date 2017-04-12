package com.crm.biz;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.log4j.Logger;
import com.crm.data.MapperFactory;

import com.crm.dao.DepartmentMapper;

import com.crm.model.Message;
import com.crm.model.dict.MessageStatus;
import com.crm.model.QueryResult;
import com.crm.model.Department;
import com.crm.model.DepartmentQuery;
import static com.crm.biz.util.ValidationUtil.*;

@Service("departmentBiz")
public class DepartmentBiz {


	private static final Logger LOGGER = Logger.getLogger(DepartmentBiz.class);

	@Resource
	private MapperFactory mapperFactory;
	
		public Message<Integer> deleteDepartment(Integer id,String operatorId){
		Message<Integer> message = new Message<Integer>();
		try {
			DepartmentMapper departmentMapper  = mapperFactory.getMapperForMaster(DepartmentMapper.class);
			int result = departmentMapper.logicalDeleteByPrimaryKey(id,operatorId,System.currentTimeMillis());
			
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete,删除Department失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;		
	}
		

    public Message<Integer> createDepartment(Department department){
		Message<Integer> message = new Message<Integer>();
		if (!validateForCreate( department, message)) {
			return message;
		}
		try {
			mapperFactory.beginTransaction();
			DepartmentMapper departmentMapper = mapperFactory.getMapperForMaster(DepartmentMapper.class);
									department.setCreateTime(System.currentTimeMillis());			departmentMapper.insert( department );
			mapperFactory.commitTransaction();
			message.setData(department.getId());

		} catch (Exception e) {
			LOGGER.error("createDepartment,创建Department失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;	
	}
	private boolean validateForCreate(Department department, Message<?> message) {
								    		        		        		
        		if (isMoreThan(message, Department.DEPARTMENTNAME, department.getDepartmentname(), 100)) {
        			return false;
        		}	
        		    																																return true;
	}
	public Message<Integer> updateDepartment(Department department){
		Message<Integer> message = new Message<Integer>();
		if (!validateForUpdate(department, message)) {
            return message;
        }
		try {
			DepartmentMapper departmentMapper = mapperFactory.getMapperForMaster(DepartmentMapper.class);
			mapperFactory.beginTransaction();
			
			Department departmentLast = departmentMapper.selectByPrimaryKeyForUpdate( department.getId() );
			if( departmentLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}
			
									department.setUpdateTime(System.currentTimeMillis());			int result = departmentMapper.updateByPrimaryKey( department );
			mapperFactory.commitTransaction();
			message.setData(result);
			
		} catch (Exception e) {
			LOGGER.error("updateDepartment,更新Department失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;	
	}
	private boolean validateForUpdate(Department department, Message<?> message) {
       				if (isNull(message,Department.ID, department.getId())) {
			return false;
		}
			   				if (isMoreThan(message, Department.DEPARTMENTNAME, department.getDepartmentname(), 100)) {
			return false;
		}	
			   			   			   			   			   			   			   		return true;
    }
		public Message<Integer> changeStatus(Integer id,Byte status,String operatorId){
		Message<Integer> message = new Message<Integer>();
		try {
			
			DepartmentMapper departmentMapper = mapperFactory.getMapperForMaster(DepartmentMapper.class);
			mapperFactory.beginTransaction();
			Department departmentLast = departmentMapper.selectByPrimaryKeyForUpdate(id );
			if( departmentLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}
			
			//TODO：其他判断
			
			int result = departmentMapper.changeStatus(id,status,operatorId,System.currentTimeMillis());
			mapperFactory.commitTransaction();
			message.setData(result);
			
		} catch (Exception e) {
			LOGGER.error("changeStatus,更新Department状态失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;
	}
		public Message<Department> getDepartment( Integer id ){
		Message<Department> message = new Message<Department>();
		try {
			DepartmentMapper departmentMapper = mapperFactory.getMapperForSlave(DepartmentMapper.class);
			Department department = departmentMapper.selectByPrimaryKey( id );
			message.setData(department);

		} catch (Exception e) {
			LOGGER.error("getDepartment,根据主键查询Department失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<Department>> getAllDepartment(){
	
		Message<List<Department>> message = new Message<List<Department>>();
		try {
			DepartmentMapper departmentMapper = mapperFactory.getMapperForSlave(DepartmentMapper.class);
				
			List<Department> departmentList = departmentMapper.selectAll();
			message.setData( departmentList);
		} catch (Exception e) {
			LOGGER.error("getAllDepartment,查询全部Department失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;	
	}
	
	public Message<QueryResult<Department>> queryDepartment(DepartmentQuery departmentQuery) {
		Message<QueryResult<Department>> message = new Message<QueryResult<Department>>();
		try {
			DepartmentMapper departmentMapper = mapperFactory.getMapperForSlave(DepartmentMapper.class);
			QueryResult<Department> queryResult = new QueryResult<Department>();
			PageHelper.startPage(departmentQuery.getPageIndex(), departmentQuery.getPageSize());
			List<Department> departmentList = departmentMapper.queryDepartment(departmentQuery);
			PageInfo<Department> pageInfo = new PageInfo<Department>(departmentList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(departmentList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryDepartment,分页查询Department失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
   
	

}