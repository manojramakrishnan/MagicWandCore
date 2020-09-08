package com.magicwand.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 * 
 * @author Manoj Ramakrishnan
 * @implNote This class is the main entry point of the application
 * @version 1.0
 * {@code done: on 05-08-2020}
 */
@SpringBootApplication
@ComponentScan("com.magicwand.*")
@EntityScan(basePackages = {"com.magicwand.entity"})
@EnableJpaRepositories(basePackages = {"com.magicwand.repository"})
public class MagicWandApp {

	public static void main(String[] args) {
		SpringApplication.run(MagicWandApp.class, args);
	}

}
