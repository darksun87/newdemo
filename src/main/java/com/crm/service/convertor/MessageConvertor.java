package com.crm.service.convertor;

import com.crm.message.MessageInfo;
import com.crm.model.Message;

public abstract class MessageConvertor {

	public static <E> MessageInfo<E> toMessageInfo(Message<?> message) {
		MessageInfo<E> messageInfo = new MessageInfo<E>();
		messageInfo.setStatus(message.getStatus());
		messageInfo.setMessage(message.getMessage());
		return messageInfo;
	}
}
