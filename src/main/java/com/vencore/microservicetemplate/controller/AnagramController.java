package com.vencore.microservicetemplate.controller;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vencore.microservicetemplate.model.Anagram;
import com.vencore.microservicetemplate.model.Reverse;
import com.vencore.microservicetemplate.service.AnagramService;

@RestController()
@RequestMapping("/anagram")
public class AnagramController {
	private AnagramService service;

	@Autowired
	public AnagramController(AnagramService service) {
		this.service = service;
	}

	@GetMapping("/{text}/{seed}")
	public Anagram getAnagram(@NotBlank @PathVariable("text") String text, @NotBlank @PathVariable("seed") Long seed) {
		return service.getAnagram(text, seed);
	}

	@GetMapping("/{text}")
	public Reverse getReverse(@NotBlank @PathVariable("text") String text) {
		return service.getReverse(text);
	}

}
