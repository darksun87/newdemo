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

import com.crm.biz.CertificatePrintBiz;
import com.crm.model.CertificatePrint;
import com.crm.model.CertificatePrintQuery;
import com.crm.model.Message;
import com.crm.model.QueryResult;

@Controller
@RequestMapping("certificatePrint")
public class CertificatePrintController {

	@Resource
	private CertificatePrintBiz certificatePrintBiz;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("certificatePrint/index", modelMap);
	}

	@RequestMapping("query")
	@ResponseBody
	public QueryResult<CertificatePrint> query(CertificatePrintQuery certificatePrintQuery) {
		Message<QueryResult<CertificatePrint>> resultMessage = certificatePrintBiz.queryCertificatePrint(certificatePrintQuery);
		return resultMessage.getData();
	}

	@RequestMapping("get")
	@ResponseBody
	public CertificatePrint get(int id) {
		return certificatePrintBiz.getCertificatePrint(id).getData();
	}

	@RequestMapping("getAll")
	@ResponseBody
	public List<CertificatePrint> getAll() {
		return certificatePrintBiz.getAllCertificatePrint().getData();
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public Message<Integer> save(CertificatePrint certificatePrint) {
		if (certificatePrint.getId() == null) {
			certificatePrint.setCreateUserid(1);
			return certificatePrintBiz.createCertificatePrint(certificatePrint);
		}
		else {
			certificatePrint.setUpdateUserid(1);
			return certificatePrintBiz.updateCertificatePrint(certificatePrint);
		}
	}

	@RequestMapping("delete")
	@ResponseBody
	public Message<Integer> delete(Integer id) {
		return certificatePrintBiz.deleteCertificatePrint(id,"1");
	}
}
