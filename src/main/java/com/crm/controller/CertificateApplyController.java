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

import com.crm.biz.CertificateApplyBiz;
import com.crm.model.CertificateApply;
import com.crm.model.CertificateApplyQuery;
import com.crm.model.Message;
import com.crm.model.QueryResult;

@Controller
@RequestMapping("certificateApply")
public class CertificateApplyController {

	@Resource
	private CertificateApplyBiz certificateApplyBiz;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("certificateApply/index", modelMap);
	}

	@RequestMapping("query")
	@ResponseBody
	public QueryResult<CertificateApply> query(CertificateApplyQuery certificateApplyQuery) {
		Message<QueryResult<CertificateApply>> resultMessage = certificateApplyBiz.queryCertificateApply(certificateApplyQuery);
		return resultMessage.getData();
	}

	@RequestMapping("get")
	@ResponseBody
	public CertificateApply get(int id) {
		return certificateApplyBiz.getCertificateApply(id).getData();
	}

	@RequestMapping("getAll")
	@ResponseBody
	public List<CertificateApply> getAll() {
		return certificateApplyBiz.getAllCertificateApply().getData();
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public Message<Integer> save(CertificateApply certificateApply) {
		if (certificateApply.getId() == null) {
			certificateApply.setCreateUserid(1);
			return certificateApplyBiz.createCertificateApply(certificateApply);
		}
		else {
			certificateApply.setUpdateUserid(1);
			return certificateApplyBiz.updateCertificateApply(certificateApply);
		}
	}

	@RequestMapping("delete")
	@ResponseBody
	public Message<Integer> delete(Integer id) {
		return certificateApplyBiz.deleteCertificateApply(id,"1");
	}
}
