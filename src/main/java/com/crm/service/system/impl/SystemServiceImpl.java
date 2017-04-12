package com.crm.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.ResourceMapper;
import com.crm.model.Resource;
import com.crm.service.system.SystemService;

@Service(value = "systemService")
public class SystemServiceImpl implements SystemService{
	
	@Autowired
	private ResourceMapper resourceMapper;
	
	@Override
	public List<Resource> selectMenuByPid(Integer pid){
		List<Resource> results = resourceMapper.selectByPid(pid);
		for(Resource resource : results){
			resource.setChildResources(selectMenuByPid(resource.getId()));
		}
		return results;
	}
	
}
