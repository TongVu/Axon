package com.axonactive.R3SpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class R3SpringBootDemoApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure (SpringApplicationBuilder App){
		return App.sources(R3SpringBootDemoApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(R3SpringBootDemoApplication.class, args);
	}

}
