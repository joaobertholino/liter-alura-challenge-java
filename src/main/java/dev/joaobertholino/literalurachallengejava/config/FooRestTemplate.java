package dev.joaobertholino.literalurachallengejava.config;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class FooRestTemplate extends RestTemplate {
	public <T> Optional<T> getForObjectAsOptional(String url, Class<T> responseType) throws RestClientException {
		return Optional.ofNullable(super.getForObject(url, responseType));
	}
}
