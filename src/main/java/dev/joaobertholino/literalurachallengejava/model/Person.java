package dev.joaobertholino.literalurachallengejava.model;

import java.time.Year;

public record Person(
		String name,
		Year birth_year,
		Year death_year
) {
}
