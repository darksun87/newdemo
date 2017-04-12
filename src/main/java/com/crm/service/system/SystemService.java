package com.crm.service.system;

import java.util.List;

import com.crm.model.Resource;

public interface SystemService {
	
	List<Resource> selectMenuByPid(Integer pid);
}
