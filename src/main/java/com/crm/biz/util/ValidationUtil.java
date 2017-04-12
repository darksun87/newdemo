package com.crm.biz.util;

import java.math.BigDecimal;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

import com.crm.model.Message;
import com.crm.model.dict.MessageStatus;
import com.ibm.icu.util.Calendar;

public abstract class ValidationUtil {

	public static boolean isNullOrEmpty(Message<?> message, String fieldName, String value) {
		if (hasText(value)) {
			return false;
		}
		message.setMessageStatus(MessageStatus.FIELD_NOT_ALLOWED_EMPTY, fieldName);
		return true;
	}

	public static boolean isNotNullOrEmpty(Message<?> message, String fieldName, String value) {
		return !isNullOrEmpty(message, fieldName, value);
	}

	public static boolean isEmptyOrLessThan(
			Message<?> message,
			String fieldName,
			String value,
			int minLength) {
		return validate(message, fieldName, value, minLength, 0);
	}

	public static boolean isLessThan(
			Message<?> message,
			String fieldName,
			String value,
			int minLength) {
		return validate(message, fieldName, true, value, minLength, 0);
	}

	public static boolean isLessThan(
			Message<?> message,
			String fieldName,
			BigDecimal value,
			double minValue) {

		if (value == null) {
			return true;
		}
		if (value.floatValue() < minValue) {
			message.setMessageStatus(MessageStatus.FIELD_VALUE_MUST_LARGE_THAN, fieldName);
			return false;
		}
		return true;
	}

	public static boolean isMoreThan(
			Message<?> message,
			String fieldName,
			BigDecimal value,
			double maxValue) {

		if (value == null) {
			return true;
		}
		if (value.floatValue() > maxValue) {
			message.setMessageStatus(MessageStatus.FIELD_VALUE_MUST_LARGE_THAN,
					fieldName);
			return false;
		}
		return true;
	}

	public static boolean isLessThan(
			Message<?> message,
			String fieldName,
			Integer value,
			int minValue) {

		if (value == null) {
			return true;
		}
		if (value.intValue() < minValue) {
			message.setMessageStatus(MessageStatus.FIELD_VALUE_MUST_LARGE_THAN,
					fieldName);
			return false;
		}
		return true;
	}

	public static boolean isMoreThan(
			Message<?> message,
			String fieldName,
			Integer value,
			int maxValue) {

		if (value == null) {
			return true;
		}
		if (value.intValue() > maxValue) {
			message.setMessageStatus(MessageStatus.FIELD_VALUE_MUST_LARGE_THAN,
					fieldName);
			return false;
		}
		return true;
	}

	public static boolean isLessThan(
			Message<?> message,
			String fieldName,
			Long value,
			long minValue) {

		if (value == null) {
			return true;
		}
		if (value.longValue() < minValue) {
			message.setMessageStatus(MessageStatus.FIELD_VALUE_MUST_LARGE_THAN,
					fieldName);
			return false;
		}
		return true;
	}

	public static boolean isMoreThan(
			Message<?> message,
			String fieldName,
			Long value,
			long maxValue) {

		if (value == null) {
			return true;
		}
		if (value.longValue() > maxValue) {
			message.setMessageStatus(MessageStatus.FIELD_VALUE_MUST_LARGE_THAN,
					fieldName);
			return false;
		}
		return true;
	}

	public static boolean isEmptyOrMoreThan(
			Message<?> message,
			String fieldName,
			String value,
			int maxLength) {
		return validate(message, fieldName, value, 0, maxLength);
	}

	public static boolean isMoreThan(
			Message<?> message,
			String fieldName,
			String value,
			int maxLength) {
		return validate(message, fieldName, true, value, 0, maxLength);
	}

	public static boolean isEmptyOrNotInRange(
			Message<?> message,
			String fieldName,
			String value,
			int minLength,
			int maxLength) {
		return validate(message, fieldName, value, minLength, maxLength);
	}

	public static boolean isNotInRange(
			Message<?> message,
			String fieldName,
			String value,
			int minLength,
			int maxLength) {
		return validate(message, fieldName, true, value, minLength, maxLength);
	}

	public static boolean validate(
			Message<?> message,
			String fieldName,
			String value,
			int minLength,
			int maxLength)
	{
		return validate(message, fieldName, false, value, minLength, maxLength);
	}

	public static boolean validate(
			Message<?> message,
			String fieldName,
			Boolean isAllowEmpty,
			String value,
			int minLength,
			int maxLength) {

		if (isAllowEmpty) {
			if (!hasText(value)) {
				return false;
			}
		} else if (isNullOrEmpty(message, fieldName, value)) {
			return true;
		}
		int length = value.length();
		if (minLength > 0 && maxLength < 1 && length < minLength) {
			message.setMessageStatus(MessageStatus.FIELD_LENGTH_MUST_MORE, fieldName, minLength);
			return true;
		}
		if (maxLength > 0 && minLength < 1 && length > maxLength) {
			message.setMessageStatus(MessageStatus.FIELD_LENGTH_MUST_LESS, fieldName, maxLength);
			return true;
		}
		if (maxLength > 0 && minLength > 0 && (length > maxLength || length < minLength)) {
			message.setMessageStatus(MessageStatus.FIELD_LENGTH_MUST_BETWEEN, fieldName, minLength, maxLength);
			return true;
		}
		return false;
	}

	private final static Pattern emailPattern = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");

	/**
	 * 是否是合法的邮箱地址
	 * 
	 * @param message
	 * @param fieldName
	 * @param value
	 * @return boolean
	 * @throws null
	 * @author dolphin
	 * @since JDK 1.7
	 * @date 2015年9月24日 下午1:39:29
	 */
	public static boolean isValidEmail(Message<?> message, String fieldName, String value) {

		if (isNullOrEmpty(message, fieldName, value)) {
			return false;
		}
		if (emailPattern.matcher(value).find()) {
			return true;
		}
		message.setMessageStatus(MessageStatus.FIELD_NOT_EMAIL, fieldName);
		return false;
	}

	private final static Pattern mobilePattern = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");

	/**
	 * 是否是合法的手机号
	 * 
	 * @param message
	 * @param fieldName
	 * @param value
	 * @return boolean
	 * @throws null
	 * @author dolphin
	 * @since JDK 1.7
	 * @date 2015年9月24日 下午1:39:11
	 */
	public static boolean isValidMobile(Message<?> message, String fieldName, String value) {
		if (mobilePattern.matcher(value).matches()) {
			return true;
		}
		message.setMessageStatus(MessageStatus.FIELD_NOT_MOBILE, fieldName);
		return false;
	}

	private final static Pattern idNumPattern = Pattern.compile("(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])");

	/**
	 * 是否是合法的身份号码
	 * 
	 * @param message
	 * @param fieldName
	 * @param value
	 * @return boolean
	 * @throws null
	 * @author dolphin
	 * @since JDK 1.7
	 * @date 2015年9月24日 下午1:38:39
	 */
	public static boolean isValidIDNumber(Message<?> message, String fieldName, String value) {
		if (idNumPattern.matcher(value).matches()) {
			return true;
		}
		message.setMessageStatus(MessageStatus.FIELD_NOT_ID_NUM, fieldName);
		return false;
	}

	/**
	 * 是否为空，用于判断非字符串变量
	 * 
	 * @param message
	 * @param fieldName
	 * @param obj
	 * @return boolean
	 * @throws null
	 * @author dolphin
	 * @since JDK 1.7
	 * @date 2015年9月24日 下午1:37:21
	 */
	public static boolean isNull(Message<?> message, String fieldName, Object obj) {
		if (obj == null) {
			message.setMessageStatus(MessageStatus.FIELD_NOT_ALLOWED_EMPTY, fieldName);
			return true;
		}
		return false;
	}

	/**
	 * 是否是合法的日期
	 * 
	 * @param message
	 * @param fieldNameGOODSIMAGE_DELETE_NOT
	 * @param dateInMs
	 * @return boolean
	 * @throws null
	 * @author dolphin
	 * @since JDK 1.7
	 * @date 2015年9月24日 下午1:36:59
	 */
	public static boolean isValidDate(Message<?> message, String fieldName, long dateInMs) {
		try {
			if (dateInMs <= 0) {
				message.setMessageStatus(MessageStatus.FIELD_NOT_ALLOWED_EMPTY, fieldName);
				return false;
			}
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(dateInMs);
			return true;
		} catch (Exception e) {
			message.setMessageStatus(MessageStatus.FIELD_NOT_DATE, fieldName);
			return false;
		}

	}

	public static boolean hasText(String value) {
		return StringUtils.hasText(value);
	}

}
