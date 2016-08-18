package com.godmonth.topia.commons.pagination;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * 排序参数
 * 
 * @author shenyue
 *
 */
public class SortParam {
	/**
	 * 方向
	 */
	private Direction direction;
	/**
	 * 排序属性
	 */
	private String property;

	public SortParam() {
	}

	public SortParam(Direction direction, String property) {
		this.direction = direction;
		this.property = property;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("property", this.property)
				.append("direction", this.direction).toString();
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof SortParam)) {
			return false;
		}
		SortParam rhs = (SortParam) object;
		return new EqualsBuilder().append(this.property, rhs.property)
				.append(this.direction, rhs.direction).isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(988764291, -1465349121)
				.append(this.property).append(this.direction).toHashCode();
	}

}
