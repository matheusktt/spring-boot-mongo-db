package com.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshopmongo.domain.User;
import com.workshopmongo.dto.UserDTO;
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
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);

	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}