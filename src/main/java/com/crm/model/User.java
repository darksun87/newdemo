package com.crm.model;

import java.math.BigDecimal;

public class User {

	public static final String ID = "ID";
	public static final String REALNAME = "真实姓名";
	public static final String DEPARTMENTID = "部门";
	public static final String LOGINNAME = "登录名";
	public static final String PASSWORD = "密码";
	public static final String CREATE_TIME = "创建时间";
	public static final String UPDATE_TIME = "修改时间";
	public static final String CREATE_USERID = "创建人";
	public static final String UPDATE_USERID = "修改人";
	public static final String STATUS = "状态";
	public static final String IS_DELETED = "是否删除";
	public static final String DEPARTMENTNAME = "部门";

	/**
	 * @Fields id : ID
	 */
	private Integer id;

	/**
	 * @Fields realname : 真实姓名
	 */
	private String realname;

	/**
	 * @Fields departmentid : 部门
	 */
	private Long departmentid;

	/**
	 * @Fields loginname : 登录名
	 */
	private String loginname;

	/**
	 * @Fields password : 密码
	 */
	private String password;

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
	/**
	 * @Fields departmentname : 部门
	 */
	private String departmentname;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Long getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(Long departmentid) {
		this.departmentid = departmentid;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getCreateUserid() {
		return createUserid;
	}

	public void setCreateUserid(Integer createUserid) {
		this.createUserid = createUserid;
	}

	public Integer getUpdateUserid() {
		return updateUserid;
	}

	public void setUpdateUserid(Integer updateUserid) {
		this.updateUserid = updateUserid;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Byte getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Byte isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
}