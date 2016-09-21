package com.godmonth.topia.commons.data.page;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.godmonth.topia.commons.pagination.Direction;
import com.godmonth.topia.commons.pagination.SortParam;

public class SortUtils {
	private SortUtils() {
	}

	public static List<SortParam> convert(Sort sort) {
		if (sort == null) {
			return null;
		}
		List<SortParam> sortParamList = new ArrayList<>();

		for (Order order : sort) {
			Direction valueOf = Direction.valueOf(order.getDirection().name());
			sortParamList.add(new SortParam(valueOf, order.getProperty()));
		}
		return sortParamList;
	}
}
