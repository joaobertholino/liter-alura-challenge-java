package dev.joaobertholino.literalurachallengejava.controller;

import dev.joaobertholino.literalurachallengejava.model.Result;
import dev.joaobertholino.literalurachallengejava.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
	private final BookService bookService;

	@GetMapping("all")
	public ResponseEntity<Result> getAllBooks() {
		return ResponseEntity.ok(this.bookService.getAllBooks());
	}

	@GetMapping("/get")
	public ResponseEntity<Result> getBooks(@RequestParam String authorYearStart, @RequestParam String languages) {
		return ResponseEntity.ok(this.bookService.getBooks(authorYearStart, languages));
	}
}
