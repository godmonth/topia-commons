package com.godmonth.topia.commons.data.page;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import com.godmonth.topia.commons.pagination.SortPageParam;
import com.godmonth.topia.commons.pagination.PageParam;
import com.godmonth.topia.commons.pagination.SortParam;

public class PageUtils {
	private PageUtils() {
	}

	public static PageRequest convert(SortPageParam pageParam,
			SortParam defaultSortParam) {
		SortParam sortParam = ObjectUtils
				.defaultIfNull(pageParam.getSortParam(), defaultSortParam);
		return convert((PageParam) pageParam, sortParam);
	}

	public static PageRequest convert(SortPageParam pageParam) {
		return convert((PageParam) pageParam, pageParam.getSortParam());
	}

	public static PageRequest convert(PageParam pageParam,
			SortParam sortParam) {
		Sort sort = null;
		if (sortParam != null) {
			Order order = new Order(
					Direction.valueOf(sortParam.getDirection().name()),
					sortParam.getProperty());
			sort = new Sort(order);
		}
		return new PageRequest(pageParam.getNumber(), pageParam.getSize(),
				sort);
	}

}
