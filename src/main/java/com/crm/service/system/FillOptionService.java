package com.crm.service.system;

import java.util.List;

import com.crm.model.Department;
import com.crm.model.Signet;

public interface FillOptionService {
	
	List<Signet> selectSignets();
	List<Department> selectDepartments();
}
