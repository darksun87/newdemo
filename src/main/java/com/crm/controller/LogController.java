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

import com.crm.biz.LogBiz;
import com.crm.model.Log;
import com.crm.model.LogQuery;
import com.crm.model.Message;
import com.crm.model.QueryResult;

@Controller
@RequestMapping("log")
public class LogController {

	@Resource
	private LogBiz logBiz;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("log/index", modelMap);
	}

	@RequestMapping("query")
	@ResponseBody
	public QueryResult<Log> query(LogQuery logQuery) {
		Message<QueryResult<Log>> resultMessage = logBiz.queryLog(logQuery);
		return resultMessage.getData();
	}

	@RequestMapping("get")
	@ResponseBody
	public Log get(int id) {
		return logBiz.getLog(id).getData();
	}

	@RequestMapping("getAll")
	@ResponseBody
	public List<Log> getAll() {
		return logBiz.getAllLog().getData();
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public Message<Integer> save(Log log) {
		if (log.getId() == null) {
			log.setCreateUserid(1);
			return logBiz.createLog(log);
		}
		else {
			log.setUpdateUserid(1);
			return logBiz.updateLog(log);
		}
	}

	@RequestMapping("delete")
	@ResponseBody
	public Message<Integer> delete(Integer id) {
		return logBiz.deleteLog(id,"1");
	}
}
