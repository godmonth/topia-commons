package com.godmonth.topia.commons.basic.exception;

import org.apache.commons.lang3.ArrayUtils;

public class CustomeValidate {
	private CustomeValidate() {
	}

	public static void notNull(Object object, String errorCode, String message, final Object... values) {
		if (object == null) {
			if (ArrayUtils.isNotEmpty(values)) {
				message = String.format(message, values);
			}
			throw new ErrorCodeException(errorCode, message);
		}
	}

	public static void isTrue(boolean condition, String errorCode, String message, final Object... values) {
		if (!condition) {
			if (ArrayUtils.isNotEmpty(values)) {
				message = String.format(message, values);
			}
			throw new ErrorCodeException(errorCode, message);
		}
	}
}
