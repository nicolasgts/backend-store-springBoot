package com.nicolas.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicolas.cursomc.domain.Categoria;
import com.nicolas.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	// with the annotation Autowired the Spring will do what we called of Independence Injection
	// He will create (or use a already created) a instance of this object
	@Autowired
	private CategoriaRepository categoriaRepo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = categoriaRepo.findById(id);
		return obj.orElse(null);
	}
}
