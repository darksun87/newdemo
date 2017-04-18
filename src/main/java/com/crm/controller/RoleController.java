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

import com.crm.biz.RoleBiz;
import com.crm.model.Role;
import com.crm.model.RoleQuery;
import com.crm.model.Message;
import com.crm.model.QueryResult;
import com.crm.service.system.SystemService;

@Controller
@RequestMapping("role")
public class RoleController {

	@Resource
	private RoleBiz roleBiz;
	@Autowired
	private SystemService systemService;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<com.crm.model.Resource> menus = systemService.selectMenuByPid(0);
		modelMap.put("menu", menus);
		return new ModelAndView("role/index", modelMap);
	}

	@RequestMapping("query")
	@ResponseBody
	public QueryResult<Role> query(RoleQuery roleQuery) {
		Message<QueryResult<Role>> resultMessage = roleBiz.queryRole(roleQuery);
		return resultMessage.getData();
	}

	@RequestMapping("get")
	@ResponseBody
	public Role get(int id) {
		return roleBiz.getRole(id).getData();
	}

	@RequestMapping("getAll")
	@ResponseBody
	public List<Role> getAll() {
		return roleBiz.getAllRole().getData();
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public Message<Integer> save(Role role) {
		if (role.getId() == null) {
			role.setCreateUserid(1);
			return roleBiz.createRole(role);
		}
		else {
			role.setUpdateUserid(1);
			return roleBiz.updateRole(role);
		}
	}

	@RequestMapping("delete")
	@ResponseBody
	public Message<Integer> delete(Integer id) {
		return roleBiz.deleteRole(id,"1");
	}
}
