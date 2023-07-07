package com.commerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * CommerceApplication
 * 
 * @author RenzoChia
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.commerce"})
public class CommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommerceApplication.class, args);
	}

}
