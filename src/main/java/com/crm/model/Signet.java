package com.crm.model;

import java.math.BigDecimal;

public class Signet {

        public static final String ID = "ID";
        public static final String SIGNETNAME = "印章名称";
        public static final String CREATE_TIME = "创建时间";
        public static final String UPDATE_TIME = "修改时间";
        public static final String CREATE_USERID = "创建人";
        public static final String UPDATE_USERID = "修改人";
        public static final String STATUS = "状态";
        public static final String IS_DELETED = "是否删除";
    
	
	/**
	 * @Fields id : ID
	 */
	private Integer id;
	
	/**
	 * @Fields signetname : 印章名称
	 */
	private String signetname;
	
	/**
	 * @Fields createTime : 创建时间
	 */
	private Long createTime;
	
	/**
	 * @Fields updateTime : 修改时间
	 */
	private Long updateTime;
	
	/**
	 * @Fields createUserid : 创建人
	 */
	private Integer createUserid;
	
	/**
	 * @Fields updateUserid : 修改人
	 */
	private Integer updateUserid;
	
	/**
	 * @Fields status : 状态
	 */
	private Byte status;
	
	/**
	 * @Fields isDeleted : 是否删除
	 */
	private Byte isDeleted;
		
    
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
    
	public String getSignetname(){
		return signetname;
	}
	
	public void setSignetname(String signetname){
		this.signetname = signetname;
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