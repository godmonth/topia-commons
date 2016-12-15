package com.godmonth.topia.commons.basic.rpc.utils;

import java.util.List;

import com.godmonth.topia.commons.pagination.Pagination;
import com.godmonth.topia.commons.pagination.SortPageParam;
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

	public static <T> Pagination<T> list2Page(List<T> rawList, SortPageParam spp) {
		int totalElements = rawList.size();
		int totalPages = totalElements / spp.getSize() + totalElements % spp.getSize() > 0 ? 1 : 0;
		int fromIndex = Math.min(totalElements, spp.getNumber() * spp.getSize());
		int toIndex = Math.min(totalElements, fromIndex + spp.getSize());
		List<T> subList = rawList.subList(fromIndex, toIndex);
		Pagination<T> pagination = new Pagination<>();
		pagination.setSortPageParam(spp);
		pagination.setTotalElements(totalElements);
		pagination.setTotalPages(totalPages);
		pagination.setItems(subList);
		return pagination;
	}
}
