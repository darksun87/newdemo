package com.crm.message;

import java.math.BigDecimal;
import java.io.Serializable;

public class TravelQueryInfo extends QueryInfo {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	
	private String reason;
	
	private String destation;
	
	private Long startTime;
	
	private Long endTime;
	
	private Long expectendTime;
	
	private Float expectcost;
	
	private Float cost;
	
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
    
	public String getReason(){
		return reason;
	}
	
	public void setReason(String reason){
		this.reason = reason;
	}
    
	public String getDestation(){
		return destation;
	}
	
	public void setDestation(String destation){
		this.destation = destation;
	}
    
	public Long getStartTime(){
		return startTime;
	}
	
	public void setStartTime(Long startTime){
		this.startTime = startTime;
	}
    
	public Long getEndTime(){
		return endTime;
	}
	
	public void setEndTime(Long endTime){
		this.endTime = endTime;
	}
    
	public Long getExpectendTime(){
		return expectendTime;
	}
	
	public void setExpectendTime(Long expectendTime){
		this.expectendTime = expectendTime;
	}
    
	public Float getExpectcost(){
		return expectcost;
	}
	
	public void setExpectcost(Float expectcost){
		this.expectcost = expectcost;
	}
    
	public Float getCost(){
		return cost;
	}
	
	public void setCost(Float cost){
		this.cost = cost;
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