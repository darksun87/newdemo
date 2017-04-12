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

import com.crm.biz.CertificateBiz;
import com.crm.model.Certificate;
import com.crm.model.CertificateQuery;
import com.crm.model.Message;
import com.crm.model.QueryResult;

@Controller
@RequestMapping("certificate")
public class CertificateController {

	@Resource
	private CertificateBiz certificateBiz;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("certificate/index", modelMap);
	}

	@RequestMapping("query")
	@ResponseBody
	public QueryResult<Certificate> query(CertificateQuery certificateQuery) {
		Message<QueryResult<Certificate>> resultMessage = certificateBiz.queryCertificate(certificateQuery);
		return resultMessage.getData();
	}

	@RequestMapping("get")
	@ResponseBody
	public Certificate get(int id) {
		return certificateBiz.getCertificate(id).getData();
	}

	@RequestMapping("getAll")
	@ResponseBody
	public List<Certificate> getAll() {
		return certificateBiz.getAllCertificate().getData();
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public Message<Integer> save(Certificate certificate) {
		if (certificate.getId() == null) {
			certificate.setCreateUserid(1);
			return certificateBiz.createCertificate(certificate);
		}
		else {
			certificate.setUpdateUserid(1);
			return certificateBiz.updateCertificate(certificate);
		}
	}

	@RequestMapping("delete")
	@ResponseBody
	public Message<Integer> delete(Integer id) {
		return certificateBiz.deleteCertificate(id,"1");
	}
}
