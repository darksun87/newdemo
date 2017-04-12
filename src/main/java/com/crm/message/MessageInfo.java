package com.crm.message;

import java.io.Serializable;

public class MessageInfo<E> implements Serializable {

	/**   
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = -7122226153545621086L;
	
	private String message;
	private int status;
	private E data;

	public MessageInfo()
	{
		this.setStatus(10000);
		this.setMessage("成功");
	}

	public MessageInfo(int status2, String message2) {
		this.setStatus(status2);
		this.setMessage(message2);
	}

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
}
