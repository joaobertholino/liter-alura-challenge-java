package dev.joaobertholino.literalurachallengejava.model;

import java.util.List;

public record Result(
		Integer count,
		String next,
		String previous,
		List<Book> results
) {
}
