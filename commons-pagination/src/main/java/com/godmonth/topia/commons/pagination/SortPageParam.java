package com.godmonth.topia.commons.pagination;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 分页参数
 * 
 * @author shenyue
 *
 */
public class SortPageParam extends PageParam {

	/**
	 * 排序
	 */
	private SortParam sortParam;

	public SortPageParam() {
	}

	/**
	 * 
	 * @param number
	 * @param size
	 */
	public SortPageParam(int number, int size) {
		super(number, size);
	}

	public SortPageParam(int number, int size, SortParam sortParam) {
		super(number, size);
		this.sortParam = sortParam;
	}

	public SortParam getSortParam() {
		return sortParam;
	}

	public void setSortParam(SortParam sortParam) {
		this.sortParam = sortParam;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof SortPageParam)) {
			return false;
		}
		SortPageParam rhs = (SortPageParam) object;
		return new EqualsBuilder().appendSuper(super.equals(object))
				.append(this.sortParam, rhs.sortParam).isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-757353235, 2131736175)
				.appendSuper(super.hashCode()).append(this.sortParam)
				.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.appendSuper(super.toString())
				.append("sortParam", this.sortParam).toString();
	}

}
