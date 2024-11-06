package dev.joaobertholino.literalurachallengejava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LiterAluraChallengeJavaApplication {
	public static void main(String[] args) {
		SpringApplication.run(LiterAluraChallengeJavaApplication.class, args);
	}
}
