package com.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshopmongo.domain.User;
import com.workshopmongo.repository.UserRepository;
import com.workshopmongo.services.exception.ObjectNotFoundException;

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
	
	public User findById(String id) {
		User user = repo.findAllById(id);
		if (user == null) {
			throw new ObjectNotFoundException("Object not found");
		}
		return user;
	}
}