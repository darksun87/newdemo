package com.crm.model;

import java.math.BigDecimal;

public class Travel {

        public static final String ID = "ID";
        public static final String REASON = "出差原因";
        public static final String DESTATION = "目的地";
        public static final String START_TIME = "开始时间";
        public static final String END_TIME = "实际结束时间";
        public static final String EXPECTEND_TIME = "预计结束时间";
        public static final String EXPECTCOST = "预计花费";
        public static final String COST = "实际花费";
        public static final String GM_TIME = "总经理审批时间";
        public static final String GM_RESULT = "总经理审批结果";
        public static final String GM_SUGGEST = "总经理审批意见";
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
	 * @Fields reason : 出差原因
	 */
	private String reason;
	
	/**
	 * @Fields destation : 目的地
	 */
	private String destation;
	
	/**
	 * @Fields startTime : 开始时间
	 */
	private Long startTime;
	
	/**
	 * @Fields endTime : 实际结束时间
	 */
	private Long endTime;
	
	/**
	 * @Fields expectendTime : 预计结束时间
	 */
	private Long expectendTime;
	
	/**
	 * @Fields expectcost : 预计花费
	 */
	private Float expectcost;
	
	/**
	 * @Fields cost : 实际花费
	 */
	private Float cost;
	
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