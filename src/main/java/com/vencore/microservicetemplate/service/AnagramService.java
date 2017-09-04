package com.vencore.microservicetemplate.service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.vencore.microservicetemplate.model.Anagram;
import com.vencore.microservicetemplate.model.Reverse;

@Service
public class AnagramService {

	public Anagram getAnagram(String text, long seed) {
		Random rng = new Random(seed);
		Set<Integer> indices = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			int ix = 0;
			while (indices.contains(ix = rng.nextInt(text.length()))) {
				// Nothing required, the condition does it all
			}
			indices.add(ix);
			sb.append(text.charAt(ix));
		}
		return Anagram.builder().text(text).seed(seed).result(sb.toString()).build();
	}

	private static String reverse(String text) {
		return (text.length() <= 1) ? text : (reverse(text.substring(1)) + text.substring(0, 1));
	}

	public Reverse getReverse(String text) {
		return Reverse.builder().text(text).result(reverse(text)).build();

	}

}
