package com.godmonth.topia.commons.basic.exception;

import com.godmonth.topia.commons.rpc.error.ErrorCode;

public class ErrorCodeValidate {
	private ErrorCodeValidate() {
	}

	public static <T> T notNull(T object, ErrorCode errorCode, final Object... values) {
		CustomeValidate.notNull(object, errorCode.getCode(), errorCode.getTemplate(), values);
		return object;
	}

	public static void isTrue(boolean condition, ErrorCode errorCode, final Object... values) {
		CustomeValidate.isTrue(condition, errorCode.getCode(), errorCode.getTemplate(), values);
	}
}
