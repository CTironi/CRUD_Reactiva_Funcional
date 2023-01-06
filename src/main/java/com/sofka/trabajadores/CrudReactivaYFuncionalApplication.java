package com.sofka.trabajadores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class CrudReactivaYFuncionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudReactivaYFuncionalApplication.class, args);
	}

}
