package com.godmonth.topia.commons.data.rpc;

import org.springframework.data.domain.Page;

import com.godmonth.topia.commons.pagination.Pagination;
import com.godmonth.topia.commons.pagination.SortPageParam;
import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class PageTransformer {

	public static <IN, OUT> Pagination<OUT> transform(Page<IN> page, Function<IN, OUT> function) {
		if (page == null) {
			return null;
		}
		Pagination<OUT> pagination = new Pagination<OUT>();
		pagination.setTotalElements(page.getTotalElements());
		pagination.setTotalPages(page.getTotalPages());
		pagination.setItems(Lists.transform(page.getContent(), function));
		pagination.setSortPageParam(new SortPageParam(page.getNumber(), page.getSize()));
		return pagination;
	}
}
