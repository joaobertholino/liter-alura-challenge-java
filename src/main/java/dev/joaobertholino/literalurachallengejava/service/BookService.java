package dev.joaobertholino.literalurachallengejava.service;

import dev.joaobertholino.literalurachallengejava.model.Result;

public interface BookService {
	Result getBooks(String authorYearStart, String languages);
	Result getAllBooks();
}
