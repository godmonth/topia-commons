package com.godmonth.topia.commons.data.rpc;

import java.util.ArrayList;

import org.springframework.data.domain.Page;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.godmonth.topia.commons.pagination.Pagination;
import com.godmonth.topia.commons.pagination.SortPageParam;

public class PageTransformer {

	public static <IN, OUT> Pagination<OUT> transform(Page<IN> page, Function<IN, OUT> function) {
		Pagination<OUT> pagination = new Pagination<OUT>();
		if (page != null) {
			pagination.setTotalElements(page.getTotalElements());
			pagination.setTotalPages(page.getTotalPages());
			pagination.setItems(Lists.transform(page.getContent(), function));
		} else {
			pagination.setTotalElements(0);
			pagination.setTotalPages(0);
			pagination.setItems(new ArrayList<OUT>());
		}
		pagination.setSortPageParam(new SortPageParam(page.getNumber(), page.getSize()));
		return pagination;
	}
}
