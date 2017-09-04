package com.vencore.microservicetemplate;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.model.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.vencore.microservicetemplate.model.Anagram;
import com.vencore.microservicetemplate.model.Reverse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MicroserviceTemplateApplicationIT {
	@Rule
	public TestRule controllerRule = new TestRule() {
		@Override
		public Statement apply(Statement base, Description description) {
			return new Statement() {
				@Override
				public void evaluate() throws Throwable {
					base.evaluate();
				}
			};
		}
	};

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testGetReverse() {
		Reverse result = Reverse.builder().text("sdrawkcab").result("backwards").build();
		assertEquals(result, restTemplate.getForObject("/anagram/sdrawkcab", Reverse.class));
	}

	@Test
	public void testGetAnagram() {
		Anagram anagram143 = Anagram.builder().text("anagram").seed(143L).result("nraamag").build();
		Anagram anagram227 = Anagram.builder().text("anagram").seed(227L).result("anragam").build();
		assertEquals(anagram143, restTemplate.getForObject("/anagram/anagram/143", Anagram.class));
		assertEquals(anagram227, restTemplate.getForObject("/anagram/anagram/227", Anagram.class));
	}

}
