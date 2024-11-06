package dev.joaobertholino.literalurachallengejava.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Year;
import java.util.UUID;

@Entity
@Table(name = "tb_person")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String name;
	private Year birthYear;
	private Year deathYear;
}
