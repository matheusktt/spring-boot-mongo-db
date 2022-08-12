package com.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshopmongo.domain.User;
import com.workshopmongo.repository.UserRepository;

//Servico injetavel em outras classes
@Service
public class UserService {

//	Instanciar um objeto automaticamente
	@Autowired
	private UserRepository repo;
	
//	responsavel por retornar todos os usuarios
	public List<User> findAll(){
		return repo.findAll();
	}
}