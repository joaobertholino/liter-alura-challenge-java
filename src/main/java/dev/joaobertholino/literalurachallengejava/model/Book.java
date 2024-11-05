package dev.joaobertholino.literalurachallengejava.model;

import java.util.List;

public record Book(
		Integer id,
		String title,
		List<String> subjects,
		List<Person> authors,
		List<Person> translators,
		List<String> bookshelves,
		List<String> languages,
		Boolean copyright,
		String media_type,
		Integer download_count
) {
}
