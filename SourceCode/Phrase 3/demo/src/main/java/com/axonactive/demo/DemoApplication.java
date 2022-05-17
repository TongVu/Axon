package com.axonactive.demo;

import com.axonactive.demo.entity.Department;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@EntityScan(basePackageClasses=Department.class)
@RestController
public class DemoApplication  extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);

//		Department department = new Department();
//		department.setName("test");
//		department.setLocation(Location.CANTHO);
//
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		EntityTransaction entityManagerTransaction = entityManager.getTransaction();
//		entityManagerTransaction.begin();
//		entityManager.persist(department);
//		entityManagerTransaction.commit();
//		entityManager.close();
//		entityManagerFactory.close();


	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

}
