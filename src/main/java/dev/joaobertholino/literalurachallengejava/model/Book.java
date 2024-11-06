package dev.joaobertholino.literalurachallengejava.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_book")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID bookId;
	private Integer id;
	private String title;

	@ElementCollection
	private List<String> subjects;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Person> authors;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Person> translators;

	@ElementCollection
	private List<String> bookshelves;

	@ElementCollection
	private List<String> languages;
	private Boolean copyright;
	private String mediaType;
	private Integer downloadCount;
}
