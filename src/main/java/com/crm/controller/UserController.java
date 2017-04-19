package com.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.crm.biz.UserBiz;
import com.crm.model.Department;
import com.crm.model.User;
import com.crm.model.UserQuery;
import com.crm.model.Message;
import com.crm.model.QueryResult;
import com.crm.service.system.FillOptionService;
import com.crm.service.system.SystemService;

@Controller
@RequestMapping("user")
public class UserController {

	@Resource
	private UserBiz userBiz;
	@Autowired
	private FillOptionService fillOptionService;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Department> departments = fillOptionService.selectDepartments();
		modelMap.put("departments", departments);
		return new ModelAndView("user/index", modelMap);
	}

	@RequestMapping("query")
	@ResponseBody
	public QueryResult<User> query(UserQuery userQuery) {
		Message<QueryResult<User>> resultMessage = userBiz.queryUser(userQuery);
		return resultMessage.getData();
	}

	@RequestMapping("get")
	@ResponseBody
	public User get(int id) {
		return userBiz.getUser(id).getData();
	}

	@RequestMapping("getAll")
	@ResponseBody
	public List<User> getAll() {
		return userBiz.getAllUser().getData();
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public Message<Integer> save(User user) {
		if (user.getId() == null) {
			user.setCreateUserid(1);
			return userBiz.createUser(user);
		}
		else {
			user.setUpdateUserid(1);
			return userBiz.updateUser(user);
		}
	}

	@RequestMapping("delete")
	@ResponseBody
	public Message<Integer> delete(Integer id) {
		return userBiz.deleteUser(id,"1");
	}
}
