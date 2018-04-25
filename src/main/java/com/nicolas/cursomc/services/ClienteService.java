package com.nicolas.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicolas.cursomc.domain.Categoria;
import com.nicolas.cursomc.domain.Cliente;
import com.nicolas.cursomc.repositories.ClienteRepository;
import com.nicolas.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = clienteRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
