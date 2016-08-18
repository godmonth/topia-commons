package com.godmonth.topia.commons.basic.rpc.utils;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.godmonth.topia.commons.basic.exception.ErrorCodeException;
import com.godmonth.topia.commons.rpc.BusinessCode;
import com.godmonth.topia.commons.rpc.ResultResponse;
import com.godmonth.topia.commons.rpc.SystemCode;

/**
 * 包含处理数据的响应组件
 * 
 * @author shenyue
 *
 */
public class ResultResponseUtils {
	private static final Logger logger = LoggerFactory.getLogger(ResultResponseUtils.class);

	public static <T> ResultResponse<T> codeResultResponse(T result, SystemCode systemCode, String businessCode,
			String message) {
		ResultResponse<T> rr = new ResultResponse<T>();
		rr.setSystemCode(systemCode);
		rr.setBusinessCode(businessCode);
		rr.setMessage(message);
		rr.setResult(result);
		return rr;
	}

	public static <T> ResultResponse<T> successResultResponse(T result) {
		return codeResultResponse(result, SystemCode.SUCCESS, BusinessCode.SUCCESS.name(), null);
	}

	public static <T> ResultResponse<T> failureResultResponse(String message) {
		return codeResultResponse(null, SystemCode.FAILURE, null, message);
	}

	public static <T> ResultResponse<T> errorCodeExceptionResultResponse(ErrorCodeException e) {
		ResultResponse<T> rr = new ResultResponse<T>();
		rr.setSystemCode(SystemCode.SUCCESS);
		rr.setBusinessCode(e.getErrorCode());
		rr.setMessage(e.getMessage());
		return rr;
	}

	public static <T> ResultResponse<T> exceptionResultResponse(Throwable throwable) {
		logger.error("", throwable);
		ResultResponse<T> rr = new ResultResponse<T>();
		rr.setSystemCode(SystemCode.FAILURE);
		rr.setMessage(throwable.getMessage());
		rr.setTrace(ExceptionUtils.getStackTrace(throwable));
		return rr;
	}

}
