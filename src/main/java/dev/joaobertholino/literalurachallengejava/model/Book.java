package dev.joaobertholino.literalurachallengejava.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String title;
	private List<String> subjects;
	private List<Person> authors;
	private List<Person> translators;
	private List<String> bookshelves;
	private List<String> languages;
	private Boolean copyright;
	private String media_type;
	private Integer download_count;
}
