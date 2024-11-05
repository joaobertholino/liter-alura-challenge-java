package dev.joaobertholino.literalurachallengejava.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Result implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	private Integer count;
	private String next;
	private String previous;
	private List<Book> results;
}
