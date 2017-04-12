package com.crm.model.dict;

public enum MessageStatus{
	OK(10000, "成功"),
	SYS_ERROR(10001, "系统繁忙,请稍后重试"),
	SAME_DATA_EXISTS(10002, "%s"),
	DATA_NOT_EXISTS(10003, "%s"),
	PARAM_NOT_VALID(10004, "参数不合法"),

	// common message
	FIELD_NOT_ALLOWED_EMPTY(10010, "%s不能为空"),
	FIELD_VALUE_MUST_LARGE_THAN(10011, "%s必须大于%2$.2f"),
	FIELD_VALUE_MUST_LESS_THAN(10012, "%s必须小于%2$.2f"),
	FIELD_NOT_EMAIL(10013, "%s格式错误"),
	FIELD_NOT_MOBILE(10014, "%s格式错误"),
	FIELD_NOT_ID_NUM(10015, "%s格式错误"),
	FIELD_NOT_DATE(10016, "%s格式错误"),
	FIELD_LENGTH_MUST_LESS(10017, "%s必须小于%d"),
	FIELD_LENGTH_MUST_MORE(10018, "%s必须大于%d"),
	FIELD_LENGTH_MUST_BETWEEN(10019, "%s长度必须大于%d和小于%d"),
	FILED_NOT_IN_ENUM_VALUES(10020, "不支持的%s"),

	// api invoke error
	API_INVLID_SIGN(10100, "签名错误"),
	API_INVLID_FROM(10101, "没有权限访问"),
	API_INVLID_DATA(10102, "请求数据错误"),
	API_NOT_SUPPORT_METHOD(10103, "只接受Post请求"),
	API_INVLID_DATA_FORMAT(10104, "数据格式不符合要求"),
	API_INVLID_API(10105, "api【%s】不存在"),

	//字典code 数据
	SALE_CHANNEL_CODE(115,"销售渠道表"),
	ONLINE_SUPPLIED_BY_CODE(116,"电商发货方式表"),
	STORE_SUPPLIED_BY_CODE(118,"便利店发货方式表"),
	SUPPORT_SHIPPING_CODE(117,"配送方式表"),
	SUPPORTSHIPPINGAREA_SHIPPING_CODE(121,"商品配送范围表"),
	
	//联系人code 数据
	FINANCIAL_CONTACT(1037,"财务联系人"),
	SALES_CONTACT(1038,"销售联系人"),
	LOGISTICS_CONTACT(1039,"物流联系人"),
	
	SKUMERCHANT_D_ONLY(1101,"商品只能有一个供应商"),
	
	SKUMERCHANT_SAME(1102,"商品与供应商关系以存在"),
	
	ITEM_SAME(1201,"商品选型已存在"),
	;

	private int status;
	private String message;

	MessageStatus(
			int status, String message) {
		this.setStatus(status);
		this.setMessage(message);
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
}
