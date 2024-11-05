package dev.joaobertholino.literalurachallengejava.service;

import dev.joaobertholino.literalurachallengejava.model.Result;

public interface BookService {
	Result getBook(String authorYearStart, String languages);
}
