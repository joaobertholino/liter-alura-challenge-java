package dev.joaobertholino.literalurachallengejava.service;

import dev.joaobertholino.literalurachallengejava.config.FooRestTemplate;
import dev.joaobertholino.literalurachallengejava.model.Result;
import dev.joaobertholino.literalurachallengejava.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResultServiceImpl implements ResultService {
	@Value(value = "${gutendex.api.url}")
	private String serviceUrl;

	private final ResultRepository resultRepository;
	private final FooRestTemplate restTemplate;

	@Override
	@Cacheable(value = "all-books")
	public Result getAllBooks() {
		return this.restTemplate.getForObject(this.serviceUrl, Result.class);
	}

	@Override
	@Cacheable(value = "specified-books")
	public Result getBooks(String authorYearStart, String languages) {
		MultiValueMap<String, String> valueMap = new LinkedMultiValueMap<>();
		valueMap.add("author_year_start", authorYearStart);
		valueMap.add("languages", languages);

		String uri = UriComponentsBuilder.fromHttpUrl(this.serviceUrl)
				.queryParams(valueMap)
				.encode()
				.toUriString();

		Optional<Result> resultOptional = this.restTemplate.getForObjectAsOptional(uri, Result.class);
		Result resultToSaved = resultOptional.orElseThrow();

		return this.resultRepository.save(resultToSaved);
	}
}
