package com.godmonth.topia.commons.basic.rpc.utils;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.godmonth.topia.commons.basic.exception.ErrorCodeException;
import com.godmonth.topia.commons.rpc.BaseResponse;
import com.godmonth.topia.commons.rpc.BusinessCode;
import com.godmonth.topia.commons.rpc.SystemCode;

/**
 * 基础响应组件
 * 
 * @author shenyue
 *
 */
public class BaseResponseUtils {

	private static final Logger logger = LoggerFactory.getLogger(BaseResponseUtils.class);

	public static BaseResponse successBaseResponse() {
		return successBaseResponse(null);
	}

	public static BaseResponse successBaseResponse(String message) {
		return codeBaseResponse(SystemCode.SUCCESS, BusinessCode.SUCCESS.name(), message);
	}

	public static BaseResponse failureBaseResponse(String message) {
		return codeBaseResponse(SystemCode.FAILURE, null, message);
	}

	public static BaseResponse codeBaseResponse(SystemCode systemCode, String businessCode, String message) {
		BaseResponse br = new BaseResponse();
		br.setSystemCode(systemCode);
		br.setBusinessCode(businessCode);
		br.setMessage(message);
		return br;
	}

	public static BaseResponse errorCodeExceptionResponse(ErrorCodeException e) {
		BaseResponse br = new BaseResponse();
		br.setSystemCode(SystemCode.SUCCESS);
		br.setBusinessCode(e.getErrorCode());
		br.setMessage(e.getMessage());
		return br;
	}

	public static BaseResponse exceptionBaseResponse(Throwable throwable) {
		logger.error("", throwable);
		BaseResponse br = new BaseResponse();
		br.setSystemCode(SystemCode.FAILURE);
		br.setMessage(throwable.getMessage());
		br.setTrace(ExceptionUtils.getStackTrace(throwable));
		return br;
	}

}
