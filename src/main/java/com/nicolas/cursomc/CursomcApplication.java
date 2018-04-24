package com.nicolas.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nicolas.cursomc.domain.Categoria;
import com.nicolas.cursomc.domain.Cidade;
import com.nicolas.cursomc.domain.Estado;
import com.nicolas.cursomc.domain.Produto;
import com.nicolas.cursomc.repositories.CategoriaRepository;
import com.nicolas.cursomc.repositories.CidadeRepository;
import com.nicolas.cursomc.repositories.EstadoRepository;
import com.nicolas.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	/* we just have the repository here, because we will populate
	 the BD when the application get started */
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	
	// method to be executed in the instantiation of the aplication
	//this method comes from the Interface CommandLineRunner
	@Override
	public void run(String... args ) {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador" , 2000.00);
		Produto p2 = new Produto(null, "Impressora" , 800.00);
		Produto p3 = new Produto(null, "Mouse" , 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat1.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().add(cat1);
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().add(cat1);
		
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade city1 = new Cidade(null, "Uberlândia", est1);
		Cidade city2 = new Cidade(null, "São Paulo", est2);
		Cidade city3 = new Cidade(null, "Campinas", est2);
		
		
		est1.getCidades().add(city1);
		est2.getCidades().addAll(Arrays.asList(city2,city3));
		
		
		// this line is different of the implementation in Spring Boot 1.5
		// there would be categoriaRepository.save(Arrays.asList(cat1,cat2));
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(city1,city2,city3));
		
	}
}
