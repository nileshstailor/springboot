package com.crud.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCrudApplication {
	/**
	 * @author Ajit Soman
	 * @since 24 April 2017. 
	 * 
	 * Created for helping other to understand CRUD opertaion
	 * I you have reached till here i would suggest you to not to copy paste 
	 * code but to understand those and write on your own.
	 * 
	 * This basic CRUD is crated in respose to stackoverflow answer:
	 * http://stackoverflow.com/questions/43585467/fetching-updated-objects-from-database-using-jparepository-findall-method/43586612#43586612
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudApplication.class, args);
	}
}
