package com.crm.model;

import java.math.BigDecimal;

public class SignetApplyFile {

        public static final String ID = "ID";
        public static final String SIGNET_APPLYID = "印章申请ID";
        public static final String BEFORESIGNET = "用印前文件";
        public static final String AFTERSIGNET = "用印后文件";
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
	 * @Fields signetApplyid : 印章申请ID
	 */
	private Long signetApplyid;
	
	/**
	 * @Fields beforesignet : 用印前文件
	 */
	private String beforesignet;
	
	/**
	 * @Fields aftersignet : 用印后文件
	 */
	private Long aftersignet;
	
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