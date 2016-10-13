package com.godmonth.topia.commons.data.rpc;

import java.util.Arrays;

import org.springframework.data.domain.PageImpl;
import org.testng.annotations.Test;

import com.godmonth.topia.commons.pagination.Pagination;

public class PageTransformerTest {

	@Test
	public void transform() {
		PageImpl<String> s = new PageImpl<>(Arrays.asList("a", "b"));
		System.out.println(s);
		Pagination<?> pagination = PageTransformer.transform(s);
		System.out.println(pagination);
	}
}
