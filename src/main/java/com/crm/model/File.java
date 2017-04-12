package com.crm.model;

import java.math.BigDecimal;

public class File {

        public static final String ID = "ID";
        public static final String FILE_TYPE_ID = "档案类型";
        public static final String FILENAME = "档案名称";
        public static final String FILEDESC = "档案描述";
        public static final String ATTACHMENT = "附件 ";
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
	 * @Fields fileTypeId : 档案类型
	 */
	private Long fileTypeId;
	
	/**
	 * @Fields filename : 档案名称
	 */
	private String filename;
	
	/**
	 * @Fields filedesc : 档案描述
	 */
	private String filedesc;
	
	/**
	 * @Fields attachment : 附件 
	 */
	private String attachment;
	
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