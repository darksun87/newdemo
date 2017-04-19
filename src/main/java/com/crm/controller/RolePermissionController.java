package com.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.crm.biz.RolePermissionBiz;
import com.crm.model.RolePermission;
import com.crm.model.RolePermissionQuery;
import com.crm.model.Message;
import com.crm.model.QueryResult;
import com.crm.model.User;

@Controller
@RequestMapping("rolePermission")
public class RolePermissionController {

	@Resource
	private RolePermissionBiz rolePermissionBiz;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("rolePermission/index", modelMap);
	}

	@RequestMapping("query")
	@ResponseBody
	public QueryResult<RolePermission> query(RolePermissionQuery rolePermissionQuery) {
		Message<QueryResult<RolePermission>> resultMessage = rolePermissionBiz.queryRolePermission(rolePermissionQuery);
		return resultMessage.getData();
	}

	@RequestMapping("get")
	@ResponseBody
	public RolePermission get(int id) {
		return rolePermissionBiz.getRolePermission(id).getData();
	}

	@RequestMapping("getAll")
	@ResponseBody
	public List<RolePermission> getAll() {
		return rolePermissionBiz.getAllRolePermission().getData();
	}
	@RequestMapping("getByRoleid")
	@ResponseBody
	public List<RolePermission> getByRoleid(Integer roleid) {
		return rolePermissionBiz.getPermissionByRoleid(roleid).getData();
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public Message<Integer> save(RolePermission rolePermission) {
		if (rolePermission.getId() == null) {
			rolePermission.setCreateUserid(1);
			return rolePermissionBiz.createRolePermission(rolePermission);
		}
		else {
			rolePermission.setUpdateUserid(1);
			return rolePermissionBiz.updateRolePermission(rolePermission);
		}
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "saveByRoleid", method = RequestMethod.POST)
	@ResponseBody
	public Message<Integer> saveByRoleid(Integer[] resourceids, Integer roleid, HttpServletRequest request) {

		HttpSession session = request.getSession();
		Message<User> user = (Message<User>)session.getAttribute("user");
		return rolePermissionBiz.savePermissionBYroleid(resourceids, roleid, user.getData().getId());
	}

	@RequestMapping("delete")
	@ResponseBody
	public Message<Integer> delete(Integer id) {
		return rolePermissionBiz.deleteRolePermission(id,"1");
	}
}
