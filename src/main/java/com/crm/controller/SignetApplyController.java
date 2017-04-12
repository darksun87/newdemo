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

import com.crm.biz.SignetApplyBiz;
import com.crm.model.SignetApply;
import com.crm.model.SignetApplyQuery;
import com.crm.model.Message;
import com.crm.model.QueryResult;

@Controller
@RequestMapping("signetApply")
public class SignetApplyController {

	@Resource
	private SignetApplyBiz signetApplyBiz;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("signetApply/index", modelMap);
	}

	@RequestMapping("query")
	@ResponseBody
	public QueryResult<SignetApply> query(SignetApplyQuery signetApplyQuery) {
		Message<QueryResult<SignetApply>> resultMessage = signetApplyBiz.querySignetApply(signetApplyQuery);
		return resultMessage.getData();
	}

	@RequestMapping("get")
	@ResponseBody
	public SignetApply get(int id) {
		return signetApplyBiz.getSignetApply(id).getData();
	}

	@RequestMapping("getAll")
	@ResponseBody
	public List<SignetApply> getAll() {
		return signetApplyBiz.getAllSignetApply().getData();
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public Message<Integer> save(SignetApply signetApply) {
		if (signetApply.getId() == null) {
			signetApply.setCreateUserid(1);
			return signetApplyBiz.createSignetApply(signetApply);
		}
		else {
			signetApply.setUpdateUserid(1);
			return signetApplyBiz.updateSignetApply(signetApply);
		}
	}

	@RequestMapping("delete")
	@ResponseBody
	public Message<Integer> delete(Integer id) {
		return signetApplyBiz.deleteSignetApply(id,"1");
	}
}
