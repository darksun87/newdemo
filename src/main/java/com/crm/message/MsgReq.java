/**
 * xf9-mc-contract 
 * MessageRequest.java 
 * com.xf9.mc.contract.message 
 * TODO  
 * @author yazhong
 * @date   2015年8月14日 下午2:24:30 
 * @Copyright 2015, 唯创国际 幸福9号 All Rights Reserved. 
 * @version   1.0
 */

package com.crm.message;

/**
 * ClassName:MessageRequest <br/>
 * Function: 消息请求类 <br/>
 * Date: 2015年8月14日 下午2:24:30 <br/>
 * 
 * @author yazhong
 * @version 1.0
 * @since JDK 1.7
 * @see
 */
public class MsgReq {
    private Long id;               
    private Byte platformFrom;     // 消息来源，哪个平台，例如1.app 2.webAPI 3.mkt 4.dos
    private Byte platformTo;       // 消息将发送到哪个平台 1.app客户端 2.cms网站
    private Byte msgBizType;       // 消息业务类型，例如 1.通告信息，2.订单信息，3.生日提醒信息，4.退款信息，5.物流信息 6.意见反馈 7.积分提醒 8.营销活动
    private Byte msgType;          // 消息类型 1.文字
    private Byte msgSendType;      // 消息发送类型 1.点对点 2.群发
    private Long userId;           // 用户ID 群发时userID值为空
    private Long mobile;           // 手机号码
    private String email;          // Email地址
    private String title;          // 标题
    private String content;        // 内容
    private Long templateId;       // 消息模版id
    private String sendType;       // 发送类型，例如1.手机消息通知，2.邮件，3.短信，组合时采用1,2,3表示通知邮件短信都可以等等
    private Long schedule;         // 定时发送时间
    private Integer delaySeconds;  // 延迟发送时间
    private String comments;       // 备注
    private String operator;       // 操作者
    
    
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
    public String getOperator() {
        return operator;
    }
    public void setOperator(String operator) {
        this.operator = operator;
    }
    
    

  
}
