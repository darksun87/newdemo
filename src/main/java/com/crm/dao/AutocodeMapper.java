package com.crm.dao;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.crm.model.Autocode;
import com.crm.model.AutocodeQuery;

public interface AutocodeMapper {
	
	int deleteByPrimaryKey(Integer id);
	
	
    int insert(Autocode autocode);

    Autocode selectByPrimaryKey(Integer id);

	Autocode selectByPrimaryKeyForUpdate(Integer id);
	
    List<Autocode> selectAll();

	List<Autocode> queryAutocode(AutocodeQuery autocodeQuery);
			
    int updateByPrimaryKey(Autocode autocode);
	
			
	int changeStatus(
		@Param("id")Integer id,
		@Param("status")Boolean status,
		@Param("updateUserid")String updateUserid,
		@Param("updateTime")Long updateTime);
		

}