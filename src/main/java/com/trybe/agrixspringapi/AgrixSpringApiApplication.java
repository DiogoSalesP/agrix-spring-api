package com.trybe.agrixspringapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.trybe.agrixspringapi.model.entity")
@EnableJpaRepositories("com.trybe.agrixspringapi.model.repository")
@ComponentScan("com.trybe.agrixspringapi")
public class AgrixSpringApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgrixSpringApiApplication.class, args);
	}

}
