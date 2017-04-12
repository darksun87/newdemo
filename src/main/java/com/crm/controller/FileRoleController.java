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

import com.crm.biz.FileRoleBiz;
import com.crm.model.FileRole;
import com.crm.model.FileRoleQuery;
import com.crm.model.Message;
import com.crm.model.QueryResult;

@Controller
@RequestMapping("fileRole")
public class FileRoleController {

	@Resource
	private FileRoleBiz fileRoleBiz;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("fileRole/index", modelMap);
	}

	@RequestMapping("query")
	@ResponseBody
	public QueryResult<FileRole> query(FileRoleQuery fileRoleQuery) {
		Message<QueryResult<FileRole>> resultMessage = fileRoleBiz.queryFileRole(fileRoleQuery);
		return resultMessage.getData();
	}

	@RequestMapping("get")
	@ResponseBody
	public FileRole get(int id) {
		return fileRoleBiz.getFileRole(id).getData();
	}

	@RequestMapping("getAll")
	@ResponseBody
	public List<FileRole> getAll() {
		return fileRoleBiz.getAllFileRole().getData();
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public Message<Integer> save(FileRole fileRole) {
		if (fileRole.getId() == null) {
			fileRole.setCreateUserid(1);
			return fileRoleBiz.createFileRole(fileRole);
		}
		else {
			fileRole.setUpdateUserid(1);
			return fileRoleBiz.updateFileRole(fileRole);
		}
	}

	@RequestMapping("delete")
	@ResponseBody
	public Message<Integer> delete(Integer id) {
		return fileRoleBiz.deleteFileRole(id,"1");
	}
}
