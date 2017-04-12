package com.crm.message;

import java.math.BigDecimal;
import java.io.Serializable;

public class AutocodeInfo implements Serializable {

	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

			
	/**
	 * @Fields id : 
	 */
	private Integer id;
			
	/**
	 * @Fields name : 
	 */
	private String name;
			
	/**
	 * @Fields password : 
	 */
	private String password;
			
	/**
	 * @Fields createTime : 
	 */
	private Long createTime;
			
	/**
	 * @Fields updateTime : 
	 */
	private Long updateTime;
			
	/**
	 * @Fields createUserid : 
	 */
	private Integer createUserid;
			
	/**
	 * @Fields updateUserid : 
	 */
	private Integer updateUserid;
			
	/**
	 * @Fields status : 
	 */
	private Boolean status;
			
	/**
	 * @Fields isDelated : 
	 */
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