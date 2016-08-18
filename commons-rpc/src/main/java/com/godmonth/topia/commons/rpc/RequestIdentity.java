package com.godmonth.topia.commons.rpc;

import org.hibernate.validator.constraints.NotBlank;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 请求标识
 * 
 * @author shwh1
 *
 */
public class RequestIdentity {
	/**
	 * 请求来源
	 */
	@NotBlank
	private String sourceCode;

	/**
	 * 请求号
	 */
	@NotBlank
	private String requestNo;

	public RequestIdentity() {
	}

	public RequestIdentity(String sourceCode, String requestNo) {
		this.sourceCode = sourceCode;
		this.requestNo = requestNo;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public String getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("sourceCode", this.sourceCode)
				.append("requestNo", this.requestNo).toString();
	}

}
