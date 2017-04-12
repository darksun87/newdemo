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

import com.crm.biz.FileTypeBiz;
import com.crm.model.FileType;
import com.crm.model.FileTypeQuery;
import com.crm.model.Message;
import com.crm.model.QueryResult;

@Controller
@RequestMapping("fileType")
public class FileTypeController {

	@Resource
	private FileTypeBiz fileTypeBiz;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("fileType/index", modelMap);
	}

	@RequestMapping("query")
	@ResponseBody
	public QueryResult<FileType> query(FileTypeQuery fileTypeQuery) {
		Message<QueryResult<FileType>> resultMessage = fileTypeBiz.queryFileType(fileTypeQuery);
		return resultMessage.getData();
	}

	@RequestMapping("get")
	@ResponseBody
	public FileType get(int id) {
		return fileTypeBiz.getFileType(id).getData();
	}

	@RequestMapping("getAll")
	@ResponseBody
	public List<FileType> getAll() {
		return fileTypeBiz.getAllFileType().getData();
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public Message<Integer> save(FileType fileType) {
		if (fileType.getId() == null) {
			fileType.setCreateUserid(1);
			return fileTypeBiz.createFileType(fileType);
		}
		else {
			fileType.setUpdateUserid(1);
			return fileTypeBiz.updateFileType(fileType);
		}
	}

	@RequestMapping("delete")
	@ResponseBody
	public Message<Integer> delete(Integer id) {
		return fileTypeBiz.deleteFileType(id,"1");
	}
}
