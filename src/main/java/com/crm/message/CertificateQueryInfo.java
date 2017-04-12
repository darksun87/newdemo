package com.crm.message;

import java.math.BigDecimal;
import java.io.Serializable;

public class CertificateQueryInfo extends QueryInfo {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	
	private String certificatename;
	
	private Long scanfile;
	
	private Long checktime;
	
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
    
	public String getCertificatename(){
		return certificatename;
	}
	
	public void setCertificatename(String certificatename){
		this.certificatename = certificatename;
	}
    
	public Long getScanfile(){
		return scanfile;
	}
	
	public void setScanfile(Long scanfile){
		this.scanfile = scanfile;
	}
    
	public Long getChecktime(){
		return checktime;
	}
	
	public void setChecktime(Long checktime){
		this.checktime = checktime;
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