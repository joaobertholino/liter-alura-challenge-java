package dev.joaobertholino.literalurachallengejava.service;

import dev.joaobertholino.literalurachallengejava.model.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
	@Value(value = "${gutendex.api.url}")
	private String serviceUrl;

	private final RestTemplate restTemplate;

	@Override
	public Result getAllBooks() {
		return this.restTemplate.getForObject(this.serviceUrl, Result.class);
	}

	@Override
	@Cacheable(value = "get-book")
	public Result getBooks(String authorYearStart, String languages) {
		MultiValueMap<String, String> valueMap = new LinkedMultiValueMap<>();
		valueMap.add("author_year_start", authorYearStart);
		valueMap.add("languages", languages);

		String uri = UriComponentsBuilder.fromHttpUrl(this.serviceUrl)
				.queryParams(valueMap)
				.encode()
				.toUriString();

		return this.restTemplate.getForObject(uri, Result.class);
	}
}
