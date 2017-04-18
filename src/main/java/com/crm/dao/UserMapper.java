package com.crm.dao;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.crm.model.User;
import com.crm.model.UserQuery;

public interface UserMapper {
	
	int deleteByPrimaryKey(Integer id);
	
		
	int logicalDeleteByPrimaryKey(
        		@Param("id")Integer id,
        		@Param("updateUserid")String updateUserid,
        		@Param("updateTime")Long updateTime);
	
    int insert(User user);

    User selectByPrimaryKey(Integer id);

	User selectByPrimaryKeyForUpdate(Integer id);
	
    List<User> selectAll();
    List<User> checkUser(
    		@Param("loginname")String loginname,
    		@Param("password")String password);
    List<User> getUserByLoginname(
    		@Param("loginname")String loginname);

	List<User> queryUser(UserQuery userQuery);
			
    int updateByPrimaryKey(User user);
	
			
	int changeStatus(
		@Param("id")Integer id,
		@Param("status")Byte status,
		@Param("updateUserid")String updateUserid,
		@Param("updateTime")Long updateTime);
		

}