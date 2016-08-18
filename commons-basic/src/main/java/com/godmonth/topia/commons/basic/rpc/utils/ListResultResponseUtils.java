package com.godmonth.topia.commons.basic.rpc.utils;

import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.godmonth.topia.commons.rpc.BusinessCode;
import com.godmonth.topia.commons.rpc.ListResultResponse;
import com.godmonth.topia.commons.rpc.SystemCode;

/**
 * 包含处理结果列表的响应组件
 * 
 * @author shenyue
 *
 */
public class ListResultResponseUtils<T> {
	private static final Logger logger = LoggerFactory.getLogger(ListResultResponseUtils.class);

	public static <T> ListResultResponse<T> codeListResultResponse(List<T> resultList, SystemCode systemCode,
			String businessCode, String message) {
		ListResultResponse<T> rr = new ListResultResponse<T>();
		rr.setSystemCode(systemCode);
		rr.setMessage(message);
		rr.setBusinessCode(businessCode);
		rr.setResultList(resultList);
		return rr;
	}

	public static <T> ListResultResponse<T> successListResultResponse(List<T> resultList) {
		return codeListResultResponse(resultList, SystemCode.SUCCESS, BusinessCode.SUCCESS.name(), null);
	}

	public static <T> ListResultResponse<T> failureResultResponse(String message) {
		return codeListResultResponse(null, SystemCode.FAILURE, null, message);
	}

	public static <T> ListResultResponse<T> exceptionListResultResponse(Throwable throwable) {
		logger.error("", throwable);
		ListResultResponse<T> rr = new ListResultResponse<T>();
		rr.setSystemCode(SystemCode.FAILURE);
		rr.setMessage(throwable.getMessage());
		rr.setTrace(ExceptionUtils.getStackTrace(throwable));
		return rr;
	}

}
