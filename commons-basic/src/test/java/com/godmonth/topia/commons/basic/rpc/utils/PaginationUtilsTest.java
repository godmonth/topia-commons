package com.godmonth.topia.commons.basic.rpc.utils;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.godmonth.topia.commons.pagination.Pagination;
import com.godmonth.topia.commons.pagination.SortPageParam;

public class PaginationUtilsTest {
	@Test
	public void list2Page() {
		List<String> list = new ArrayList<>();
		SortPageParam spp = new SortPageParam();
		spp.setNumber(1);
		spp.setSize(10);
		Pagination<String> list2Page = PaginationUtils.list2Page(list, spp);
		System.out.println(list2Page);
	}
}
