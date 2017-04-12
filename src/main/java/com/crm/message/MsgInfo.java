/**
 * xf9-mc-contract 
 * MsgInfo.java 
 * com.xf9.mc.contract.message 
 * TODO  
 * @author yazhong
 * @date   2015年8月17日 下午5:59:49 
 * @Copyright 2015, 唯创国际 幸福9号 All Rights Reserved. 
 * @version   1.0
 */

package com.crm.message;

public class MsgInfo {
    private Long id;
    private Byte platformFrom;
    private Byte platformTo;
    private Byte msgBizType;
    private Byte msgType;
    private Byte msgSendType;
    private Long userId;
    private Long mobile;
    private String email;
    private String title;
    private String content;
    private Long templateId;
    private String sendType;
    private Byte status;
    private Byte isDeleted;
    private Long schedule;
    private Integer delaySeconds;
    private String comments;
    private Byte markMsgRead;
    private Long createTime;
    private Long updateTime;
    private String createUser;
    private String updateUser;
    private String notifyFlag;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Byte getPlatformFrom() {
        return platformFrom;
    }
    public void setPlatformFrom(Byte platformFrom) {
        this.platformFrom = platformFrom;
    }
    public Byte getPlatformTo() {
        return platformTo;
    }
    public void setPlatformTo(Byte platformTo) {
        this.platformTo = platformTo;
    }
    public Byte getMsgBizType() {
        return msgBizType;
    }
    public void setMsgBizType(Byte msgBizType) {
        this.msgBizType = msgBizType;
    }
    public Byte getMsgType() {
        return msgType;
    }
    public void setMsgType(Byte msgType) {
        this.msgType = msgType;
    }
    public Byte getMsgSendType() {
        return msgSendType;
    }
    public void setMsgSendType(Byte msgSendType) {
        this.msgSendType = msgSendType;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getMobile() {
        return mobile;
    }
    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Long getTemplateId() {
        return templateId;
    }
    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }
    public String getSendType() {
        return sendType;
    }
    public void setSendType(String sendType) {
        this.sendType = sendType;
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
    public Long getSchedule() {
        return schedule;
    }
    public void setSchedule(Long schedule) {
        this.schedule = schedule;
    }
    public Integer getDelaySeconds() {
        return delaySeconds;
    }
    public void setDelaySeconds(Integer delaySeconds) {
        this.delaySeconds = delaySeconds;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    public Byte getMarkMsgRead() {
        return markMsgRead;
    }
    public void setMarkMsgRead(Byte markMsgRead) {
        this.markMsgRead = markMsgRead;
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
    public String getCreateUser() {
        return createUser;
    }
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    public String getUpdateUser() {
        return updateUser;
    }
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
    public String getNotifyFlag() {
        return notifyFlag;
    }
    public void setNotifyFlag(String notifyFlag) {
        this.notifyFlag = notifyFlag;
    }
  
}
