/**
 * xf9-mc-contract 
 * Message.java 
 * com.xf9.mc.contract.dict 
 * TODO  
 * @author yazhong
 * @date   2015年8月14日 下午4:16:06 
 * @Copyright 2015, 唯创国际 幸福9号 All Rights Reserved. 
 * @version   1.0
 */

package com.crm.message;

import com.crm.model.dict.MessageStatus;

public class Message<E> {

    public Message() {
        status = MessageStatus.OK.getStatus();
        message = MessageStatus.OK.getMessage();
    }

    public Message(MessageStatus messgeStatus) {
        status = messgeStatus.getStatus();
        message = messgeStatus.getMessage();
    }

    private String message;
    private int status;
    private E data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;

    }

    public void setStatus(int status) {
        this.status = status;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public void setMessageStatus(MessageStatus code, Object... args) {
        this.setStatus(code.getStatus());
        if (args.length == 0) {
            this.setMessage(code.getMessage());
        } else {
            this.setMessage(String.format(code.getMessage(), args));
        }
    }

    public static <T> Message<T> getMessage(MessageStatus code, Object... args) {
        Message<T> message = new Message<T>();
        message.setStatus(code.getStatus());
        if (args.length == 0) {
            message.setMessage(code.getMessage());
        } else {
            message.setMessage(String.format(code.getMessage(), args));
        }
        return message;
    }
}
