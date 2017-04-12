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

import com.crm.biz.AutocodeBiz;
import com.crm.model.Autocode;
import com.crm.model.AutocodeQuery;
import com.crm.model.Message;
import com.crm.model.QueryResult;

@Controller
@RequestMapping("autocode")
public class AutocodeController {

	@Resource
	private AutocodeBiz autocodeBiz;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("autocode/index", modelMap);
	}

	@RequestMapping("query")
	@ResponseBody
	public QueryResult<Autocode> query(AutocodeQuery autocodeQuery) {
		Message<QueryResult<Autocode>> resultMessage = autocodeBiz.queryAutocode(autocodeQuery);
		return resultMessage.getData();
	}

	@RequestMapping("get")
	@ResponseBody
	public Autocode get(int id) {
		return autocodeBiz.getAutocode(id).getData();
	}

	@RequestMapping("getAll")
	@ResponseBody
	public List<Autocode> getAll() {
		return autocodeBiz.getAllAutocode().getData();
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public Message<Integer> save(Autocode autocode) {
		if (autocode.getId() == null) {
			autocode.setCreateUserid(1);
			return autocodeBiz.createAutocode(autocode);
		}
		else {
			autocode.setUpdateUserid(1);
			return autocodeBiz.updateAutocode(autocode);
		}
	}

	@RequestMapping("delete")
	@ResponseBody
	public Message<Integer> delete(Integer id) {
		return autocodeBiz.deleteAutocode(id);
	}
}
