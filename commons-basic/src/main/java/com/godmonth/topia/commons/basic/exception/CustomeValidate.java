package com.godmonth.topia.commons.basic.exception;

public class CustomeValidate {
	private CustomeValidate() {
	}

	public static void notNull(Object object, String errorCode, String message, final Object... values) {
		if (object == null) {
			throw new ErrorCodeException(errorCode, String.format(message, values));
		}
	}

	public static void isTrue(boolean condition, String errorCode, String message, final Object... values) {
		if (!condition) {
			throw new ErrorCodeException(errorCode, String.format(message, values));
		}
	}
}
