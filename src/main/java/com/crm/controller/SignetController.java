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

import com.crm.biz.SignetBiz;
import com.crm.model.Signet;
import com.crm.model.SignetQuery;
import com.crm.model.Message;
import com.crm.model.QueryResult;

@Controller
@RequestMapping("signet")
public class SignetController {

	@Resource
	private SignetBiz signetBiz;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("signet/index", modelMap);
	}

	@RequestMapping("query")
	@ResponseBody
	public QueryResult<Signet> query(SignetQuery signetQuery) {
		Message<QueryResult<Signet>> resultMessage = signetBiz.querySignet(signetQuery);
		return resultMessage.getData();
	}

	@RequestMapping("get")
	@ResponseBody
	public Signet get(int id) {
		return signetBiz.getSignet(id).getData();
	}

	@RequestMapping("getAll")
	@ResponseBody
	public List<Signet> getAll() {
		return signetBiz.getAllSignet().getData();
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public Message<Integer> save(Signet signet) {
		if (signet.getId() == null) {
			signet.setCreateUserid(1);
			return signetBiz.createSignet(signet);
		}
		else {
			signet.setUpdateUserid(1);
			return signetBiz.updateSignet(signet);
		}
	}

	@RequestMapping("delete")
	@ResponseBody
	public Message<Integer> delete(Integer id) {
		return signetBiz.deleteSignet(id,"1");
	}
}
