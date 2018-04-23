package com.nicolas.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nicolas.cursomc.domain.Categoria;
import com.nicolas.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	/* we just have the repository here, because we will populate
	 the BD when the application get started */
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	
	// method to be executed in the instantiation of the aplication
	//this method comes from the Interface CommandLineRunner
	@Override
	public void run(String... args ) {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		// this line is different of the implementation in Spring Boot 1.5
		// there would be categoriaRepository.save(Arrays.asList(cat1,cat2));
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		
	}
}
