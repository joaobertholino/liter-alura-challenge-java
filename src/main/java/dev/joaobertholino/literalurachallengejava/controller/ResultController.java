package dev.joaobertholino.literalurachallengejava.controller;

import dev.joaobertholino.literalurachallengejava.model.Result;
import dev.joaobertholino.literalurachallengejava.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class ResultController {
	private final ResultService resultService;

	@GetMapping("all")
	public ResponseEntity<Result> getAllBooks() {
		return ResponseEntity.ok(this.resultService.getAllBooks());
	}

	@GetMapping("/get")
	public ResponseEntity<Result> getBooks(@RequestParam String authorYearStart, @RequestParam String languages) {
		return ResponseEntity.ok(this.resultService.getBooks(authorYearStart, languages));
	}
}
