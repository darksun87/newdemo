package com.crm.model;

import java.math.BigDecimal;

public class RolePermissionQuery extends Query {
			
	private Integer id;
			
	private Long roleid;
			
	private String url;
			
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
    
	public Long getRoleid(){
		return roleid;
	}
	public void setRoleid(Long roleid){
		this.roleid = roleid;
	}
    
	public String getUrl(){
		return url;
	}
	public void setUrl(String url){
		this.url = url;
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