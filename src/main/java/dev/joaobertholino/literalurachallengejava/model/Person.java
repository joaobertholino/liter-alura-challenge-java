package dev.joaobertholino.literalurachallengejava.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Year;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	private String name;
	private Year birth_year;
	private Year death_year;
}
