package com.crm.model;

import java.math.BigDecimal;

public class SignetApplyQuery extends Query {
			
	private Integer id;
			
	private String applyreason;
			
	private Long signetid;
			
	private Long dgmTime;
			
	private String dgmResult;
			
	private String dgmSuggest;
			
	private Long gmTime;
			
	private String gmResult;
			
	private String gmSuggest;
			
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
    
	public String getApplyreason(){
		return applyreason;
	}
	public void setApplyreason(String applyreason){
		this.applyreason = applyreason;
	}
    
	public Long getSignetid(){
		return signetid;
	}
	public void setSignetid(Long signetid){
		this.signetid = signetid;
	}
    
	public Long getDgmTime(){
		return dgmTime;
	}
	public void setDgmTime(Long dgmTime){
		this.dgmTime = dgmTime;
	}
    
	public String getDgmResult(){
		return dgmResult;
	}
	public void setDgmResult(String dgmResult){
		this.dgmResult = dgmResult;
	}
    
	public String getDgmSuggest(){
		return dgmSuggest;
	}
	public void setDgmSuggest(String dgmSuggest){
		this.dgmSuggest = dgmSuggest;
	}
    
	public Long getGmTime(){
		return gmTime;
	}
	public void setGmTime(Long gmTime){
		this.gmTime = gmTime;
	}
    
	public String getGmResult(){
		return gmResult;
	}
	public void setGmResult(String gmResult){
		this.gmResult = gmResult;
	}
    
	public String getGmSuggest(){
		return gmSuggest;
	}
	public void setGmSuggest(String gmSuggest){
		this.gmSuggest = gmSuggest;
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