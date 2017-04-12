package com.crm.message;

import java.math.BigDecimal;
import java.io.Serializable;

public class LogQueryInfo extends QueryInfo {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	
	private String module;
	
	private String logcontent;
	
	private String result;
	
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
    
	public String getModule(){
		return module;
	}
	
	public void setModule(String module){
		this.module = module;
	}
    
	public String getLogcontent(){
		return logcontent;
	}
	
	public void setLogcontent(String logcontent){
		this.logcontent = logcontent;
	}
    
	public String getResult(){
		return result;
	}
	
	public void setResult(String result){
		this.result = result;
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