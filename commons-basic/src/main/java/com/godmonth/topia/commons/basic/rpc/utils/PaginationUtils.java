package com.godmonth.topia.commons.basic.rpc.utils;

import java.util.List;

import com.godmonth.topia.commons.pagination.Pagination;
import com.google.common.base.Function;
import com.google.common.collect.Lists;

import jodd.bean.BeanCopy;

public class PaginationUtils {
	public static <F, T> Pagination<T> transform(Pagination<F> page, Function<F, T> function) {
		if (page == null) {
			return null;
		}
		Pagination<T> pagination = new Pagination<T>();
		BeanCopy.beans(page, pagination).exclude("items").copy();
		List<F> items = page.getItems();
		if (items != null) {
			List<T> transform = Lists.transform(items, function);
			pagination.setItems(transform);
		}
		return pagination;
	}
}
