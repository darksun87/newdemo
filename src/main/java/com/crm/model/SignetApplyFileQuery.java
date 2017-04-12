package com.crm.model;

import java.math.BigDecimal;

public class SignetApplyFileQuery extends Query {
			
	private Integer id;
			
	private Long signetApplyid;
			
	private String beforesignet;
			
	private Long aftersignet;
			
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
    
	public Long getSignetApplyid(){
		return signetApplyid;
	}
	public void setSignetApplyid(Long signetApplyid){
		this.signetApplyid = signetApplyid;
	}
    
	public String getBeforesignet(){
		return beforesignet;
	}
	public void setBeforesignet(String beforesignet){
		this.beforesignet = beforesignet;
	}
    
	public Long getAftersignet(){
		return aftersignet;
	}
	public void setAftersignet(Long aftersignet){
		this.aftersignet = aftersignet;
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