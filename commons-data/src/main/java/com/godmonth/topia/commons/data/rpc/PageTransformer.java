package com.godmonth.topia.commons.data.rpc;

import org.springframework.data.domain.Page;

import com.godmonth.topia.commons.data.page.SortUtils;
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
		pagination.setSortPageParam(
				new SortPageParam(page.getNumber(), page.getSize(), SortUtils.convert(page.getSort())));
		return pagination;
	}

	public static <T> Pagination<T> transform(Page<T> page) {
		if (page == null) {
			return null;
		}
		Pagination<T> pagination = new Pagination<T>();
		pagination.setTotalElements(page.getTotalElements());
		pagination.setTotalPages(page.getTotalPages());
		pagination.setItems(page.getContent());
		pagination.setSortPageParam(
				new SortPageParam(page.getNumber(), page.getSize(), SortUtils.convert(page.getSort())));
		return pagination;
	}
}
