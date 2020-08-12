package com.parvanpajooh.bill.exceptions;

/**
 * @author mehrdad
 * @author ali
 */
public enum ErrorCode{
	UNKNOWN(0),
//	OBJECT_EXIST(10010),
//	OBJECT_NOT_FOUND(10009),
//	ACCESS_DENIDE(10012),
//	SAVE_ERROR(10006),

	BILL_INVALID_CHARGEID(5001),
	BILL_PAYMENT_ERROR(5002),
	CLIENT_INVALID_CAPTCHA(4001),
	INVALID_CAPTCHA_STATE(4003),
	INVALID_CAPTCHA_VALUE(4004),
	FAILED_CREATE_CAPTCHA(5003),
	;



	/**
	 * 
	 */
	private final int value;

	/**
	 * 
	 * @param value
	 */
	ErrorCode(int value) {
		this.value = value;
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public static ErrorCode fromValue(int value) {
		
		for (ErrorCode thisValue : values()) {
			if (thisValue.value == value) {
				return thisValue;
			}
		}

		// you may return a default value
		return getDefault();
		// or throw an exception
		// throw new IllegalArgumentException("Invalid LanguageIso6391: " + value);
	}
	
	/**
	 * 
	 * @return
	 */
	public int toValue() {
		return value;
	}

	/**
	 * 
	 * @return
	 */
	public static ErrorCode getDefault() {
		return UNKNOWN;
	}
}