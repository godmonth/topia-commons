package com.godmonth.topia.commons.data.page;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import com.godmonth.topia.commons.pagination.PageParam;
import com.godmonth.topia.commons.pagination.SortPageParam;
import com.godmonth.topia.commons.pagination.SortParam;
import com.google.common.collect.Lists;

public class PageUtils {
	private PageUtils() {
	}

	public static PageRequest convert(SortPageParam pageParam) {
		return convert((PageParam) pageParam, pageParam.getSortParamList());
	}

	public static PageRequest convert(PageParam pageParam, SortParam sortParam) {
		return convert(pageParam, Lists.newArrayList(sortParam));
	}

	public static PageRequest convert(PageParam pageParam, List<SortParam> sortParamList) {
		Sort sort = null;

		if (CollectionUtils.isNotEmpty(sortParamList)) {
			List<Order> orderList = new ArrayList<>();
			for (SortParam sortParam : sortParamList) {
				Order order = new Order(Direction.valueOf(sortParam.getDirection().name()), sortParam.getProperty());
				orderList.add(order);
			}
			sort = new Sort(orderList);
		}
		return new PageRequest(pageParam.getNumber(), pageParam.getSize(), sort);
	}

}
