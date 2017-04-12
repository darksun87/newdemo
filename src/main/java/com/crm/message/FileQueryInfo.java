package com.crm.message;

import java.math.BigDecimal;
import java.io.Serializable;

public class FileQueryInfo extends QueryInfo {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	
	private Long fileTypeId;
	
	private String filename;
	
	private String filedesc;
	
	private String attachment;
	
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
    
	public Long getFileTypeId(){
		return fileTypeId;
	}
	
	public void setFileTypeId(Long fileTypeId){
		this.fileTypeId = fileTypeId;
	}
    
	public String getFilename(){
		return filename;
	}
	
	public void setFilename(String filename){
		this.filename = filename;
	}
    
	public String getFiledesc(){
		return filedesc;
	}
	
	public void setFiledesc(String filedesc){
		this.filedesc = filedesc;
	}
    
	public String getAttachment(){
		return attachment;
	}
	
	public void setAttachment(String attachment){
		this.attachment = attachment;
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