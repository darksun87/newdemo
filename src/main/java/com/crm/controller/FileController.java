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

import com.crm.biz.FileBiz;
import com.crm.model.File;
import com.crm.model.FileQuery;
import com.crm.model.Message;
import com.crm.model.QueryResult;

@Controller
@RequestMapping("file")
public class FileController {

	@Resource
	private FileBiz fileBiz;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("file/index", modelMap);
	}

	@RequestMapping("query")
	@ResponseBody
	public QueryResult<File> query(FileQuery fileQuery) {
		Message<QueryResult<File>> resultMessage = fileBiz.queryFile(fileQuery);
		return resultMessage.getData();
	}

	@RequestMapping("get")
	@ResponseBody
	public File get(int id) {
		return fileBiz.getFile(id).getData();
	}

	@RequestMapping("getAll")
	@ResponseBody
	public List<File> getAll() {
		return fileBiz.getAllFile().getData();
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public Message<Integer> save(File file) {
		if (file.getId() == null) {
			file.setCreateUserid(1);
			return fileBiz.createFile(file);
		}
		else {
			file.setUpdateUserid(1);
			return fileBiz.updateFile(file);
		}
	}

	@RequestMapping("delete")
	@ResponseBody
	public Message<Integer> delete(Integer id) {
		return fileBiz.deleteFile(id,"1");
	}
}
