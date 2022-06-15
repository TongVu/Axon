package com.axonactive.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void test_Java8_functionality_Demo_Ok(){

		String encrtypedPassWord = new BCryptPasswordEncoder().encode("123");
		System.out.println(encrtypedPassWord);

//		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
//		for (String feature : features) {
//			System.out.println(feature);
//		}

		System.out.println("==============================");
//		Consumer<String> con = n -> System.out.println(n);
//		features.forEach(con);

		System.out.println("==============================");
//
//		features.forEach(f -> System.out.println(f));
//
//		features.forEach(System.out::println);
		//features.stream().filter(f -> f.equals("Lambdas")).forEach(System.out::println);
	}
}
