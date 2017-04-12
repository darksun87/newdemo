package com.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.crm.biz.DepartmentBiz;
import com.crm.model.Department;
import com.crm.model.DepartmentQuery;
import com.crm.model.Message;
import com.crm.model.QueryResult;

@Controller
@RequestMapping("department")
public class DepartmentController {

	@Resource
	private DepartmentBiz departmentBiz;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("department/index", modelMap);
	}

	@RequestMapping("query")
	@ResponseBody
	public QueryResult<Department> query(DepartmentQuery departmentQuery) {
		Message<QueryResult<Department>> resultMessage = departmentBiz.queryDepartment(departmentQuery);
		return resultMessage.getData();
	}

	@RequestMapping("get")
	@ResponseBody
	public Department get(int id) {
		return departmentBiz.getDepartment(id).getData();
	}

	@RequestMapping("getAll")
	@ResponseBody
	public List<Department> getAll() {
		return departmentBiz.getAllDepartment().getData();
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public Message<Integer> save(Department department) {
		if (department.getId() == null) {
			department.setCreateUserid(1);
			return departmentBiz.createDepartment(department);
		}
		else {
			department.setUpdateUserid(1);
			return departmentBiz.updateDepartment(department);
		}
	}

	@RequestMapping("delete")
	@ResponseBody
	public Message<Integer> delete(Integer id) {
		return departmentBiz.deleteDepartment(id,"1");
	}
}
