package com.vencore.microservicetemplate.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import com.vencore.microservicetemplate.controller.AnagramController;
import com.vencore.microservicetemplate.model.Anagram;
import com.vencore.microservicetemplate.model.Reverse;
import com.vencore.microservicetemplate.service.AnagramService;

public class AnagramControllerTest {
	@Rule
	public TestRule controllerRule = new TestRule() {
		@Override
		public Statement apply(Statement base, Description description) {
			return new Statement() {
				@Override
				public void evaluate() throws Throwable {
					registrar = new AnagramService();
					controller = new AnagramController(registrar);
					base.evaluate();
				}
			};
		}
	};

	private AnagramController controller;
	private AnagramService registrar;

	@Test
	public void testGetAnagram() {
		Anagram anagram143 = Anagram.builder().text("anagram").seed(143L).result("nraamag").build();
		Anagram anagram227 = Anagram.builder().text("anagram").seed(227L).result("anragam").build();
		assertEquals(anagram143, controller.getAnagram("anagram", 143L));
		assertEquals(anagram227, controller.getAnagram("anagram", 227L));
	}

	@Test
	public void testGetReverse() {
		Reverse result = Reverse.builder().text("sdrawkcab").result("backwards").build();
		assertEquals(result, controller.getReverse("sdrawkcab"));
	}


}
