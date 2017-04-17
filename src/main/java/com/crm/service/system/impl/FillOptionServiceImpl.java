package com.crm.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.DepartmentMapper;
import com.crm.dao.SignetMapper;
import com.crm.model.Department;
import com.crm.model.Signet;
import com.crm.service.system.FillOptionService;

@Service(value = "fillOptionService")
public class FillOptionServiceImpl implements FillOptionService{
	
	@Autowired
	private SignetMapper signetMapper;
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Override
	public List<Signet> selectSignets(){
		List<Signet> results = signetMapper.selectAll();
		return results;
	}

	@Override
	public List<Department> selectDepartments() {
		List<Department> results = departmentMapper.selectAll();
		return results;
	}
	
}
