package dev.joaobertholino.literalurachallengejava.service;

import dev.joaobertholino.literalurachallengejava.model.Result;

public interface ResultService {
	Result getBooks(String authorYearStart, String languages);
	Result getAllBooks();
}
