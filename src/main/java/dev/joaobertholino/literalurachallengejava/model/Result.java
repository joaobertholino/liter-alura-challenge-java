package dev.joaobertholino.literalurachallengejava.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_result")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Result implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private Integer count;
	private String next;
	private String previous;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Book> results;
}
