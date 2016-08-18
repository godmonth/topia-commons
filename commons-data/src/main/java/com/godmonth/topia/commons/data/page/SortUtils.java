package com.godmonth.topia.commons.data.page;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import com.godmonth.topia.commons.pagination.SortParam;

public class SortUtils {
	private SortUtils() {
	}

	public static Sort convert(SortParam sortParam) {
		Sort sort = null;
		if (sortParam != null) {
			Order order = new Order(
					Direction.valueOf(sortParam.getDirection().name()),
					sortParam.getProperty());
			sort = new Sort(order);
		}
		return sort;
	}

}
