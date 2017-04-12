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

import com.crm.biz.SignetApplyFileBiz;
import com.crm.model.SignetApplyFile;
import com.crm.model.SignetApplyFileQuery;
import com.crm.model.Message;
import com.crm.model.QueryResult;

@Controller
@RequestMapping("signetApplyFile")
public class SignetApplyFileController {

	@Resource
	private SignetApplyFileBiz signetApplyFileBiz;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("signetApplyFile/index", modelMap);
	}

	@RequestMapping("query")
	@ResponseBody
	public QueryResult<SignetApplyFile> query(SignetApplyFileQuery signetApplyFileQuery) {
		Message<QueryResult<SignetApplyFile>> resultMessage = signetApplyFileBiz.querySignetApplyFile(signetApplyFileQuery);
		return resultMessage.getData();
	}

	@RequestMapping("get")
	@ResponseBody
	public SignetApplyFile get(int id) {
		return signetApplyFileBiz.getSignetApplyFile(id).getData();
	}

	@RequestMapping("getAll")
	@ResponseBody
	public List<SignetApplyFile> getAll() {
		return signetApplyFileBiz.getAllSignetApplyFile().getData();
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public Message<Integer> save(SignetApplyFile signetApplyFile) {
		if (signetApplyFile.getId() == null) {
			signetApplyFile.setCreateUserid(1);
			return signetApplyFileBiz.createSignetApplyFile(signetApplyFile);
		}
		else {
			signetApplyFile.setUpdateUserid(1);
			return signetApplyFileBiz.updateSignetApplyFile(signetApplyFile);
		}
	}

	@RequestMapping("delete")
	@ResponseBody
	public Message<Integer> delete(Integer id) {
		return signetApplyFileBiz.deleteSignetApplyFile(id,"1");
	}
}
