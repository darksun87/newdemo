package com.crm.model;

import java.math.BigDecimal;

public class CertificateApply {

        public static final String ID = "ID";
        public static final String APPLYREASON = "申请理由";
        public static final String CERTIFICATEID = "证照ID";
        public static final String GM_TIME = "总经理审批时间";
        public static final String GM_RESULT = "总经理审批结果";
        public static final String GM_SUGGEST = "总经理审批意见";
        public static final String REVERT_TIME = "归还时间";
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
	 * @Fields applyreason : 申请理由
	 */
	private String applyreason;
	
	/**
	 * @Fields certificateid : 证照ID
	 */
	private Long certificateid;
	
	/**
	 * @Fields gmTime : 总经理审批时间
	 */
	private Long gmTime;
	
	/**
	 * @Fields gmResult : 总经理审批结果
	 */
	private String gmResult;
	
	/**
	 * @Fields gmSuggest : 总经理审批意见
	 */
	private String gmSuggest;
	
	/**
	 * @Fields revertTime : 归还时间
	 */
	private Long revertTime;
	
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
    
	public String getApplyreason(){
		return applyreason;
	}
	
	public void setApplyreason(String applyreason){
		this.applyreason = applyreason;
	}
    
	public Long getCertificateid(){
		return certificateid;
	}
	
	public void setCertificateid(Long certificateid){
		this.certificateid = certificateid;
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
    
	public Long getRevertTime(){
		return revertTime;
	}
	
	public void setRevertTime(Long revertTime){
		this.revertTime = revertTime;
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