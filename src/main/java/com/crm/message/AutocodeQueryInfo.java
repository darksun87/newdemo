package com.crm.message;

import java.math.BigDecimal;
import java.io.Serializable;

public class AutocodeQueryInfo extends QueryInfo {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	
	private String name;
	
	private String password;
	
	private Long createTime;
	
	private Long updateTime;
	
	private Integer createUserid;
	
	private Integer updateUserid;
	
	private Boolean status;
	
	private Byte isDelated;
		
    
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
    
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
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
    
	public Boolean getStatus(){
		return status;
	}
	
	public void setStatus(Boolean status){
		this.status = status;
	}
    
	public Byte getIsDelated(){
		return isDelated;
	}
	
	public void setIsDelated(Byte isDelated){
		this.isDelated = isDelated;
	}
    }