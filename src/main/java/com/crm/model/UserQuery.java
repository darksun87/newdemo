package com.crm.model;

import java.math.BigDecimal;

public class UserQuery extends Query {
			
	private Integer id;
			
	private String realname;
			
	private Long departmentid;
			
	private String loginname;
			
	private String password;
			
	private Long createTime;
			
	private Long updateTime;
			
	private Integer createUserid;
			
	private Integer updateUserid;
			
	private Byte status;
			
	private Byte isDeleted;
		
    
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
    
	public String getRealname(){
		return realname;
	}
	public void setRealname(String realname){
		this.realname = realname;
	}
    
	public Long getDepartmentid(){
		return departmentid;
	}
	public void setDepartmentid(Long departmentid){
		this.departmentid = departmentid;
	}
    
	public String getLoginname(){
		return loginname;
	}
	public void setLoginname(String loginname){
		this.loginname = loginname;
	}
    
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
    
	public Long getCreateTime(){
		return createTime;
	}
	public void setCreateTime(Long createTime){
		this.createTime = createTime;
	}
    
	public Long getUpdateTime(){
		return updateTime;
	}
	public void setUpdateTime(Long updateTime){
		this.updateTime = updateTime;
	}
    
	public Integer getCreateUserid(){
		return createUserid;
	}
	public void setCreateUserid(Integer createUserid){
		this.createUserid = createUserid;
	}
    
	public Integer getUpdateUserid(){
		return updateUserid;
	}
	public void setUpdateUserid(Integer updateUserid){
		this.updateUserid = updateUserid;
	}
    
	public Byte getStatus(){
		return status;
	}
	public void setStatus(Byte status){
		this.status = status;
	}
    
	public Byte getIsDeleted(){
		return isDeleted;
	}
	public void setIsDeleted(Byte isDeleted){
		this.isDeleted = isDeleted;
	}
    }