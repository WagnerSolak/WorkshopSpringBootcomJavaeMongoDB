package com.solak.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solak.workshopmongo.domain.User;
import com.solak.workshopmongo.dto.UserDTO;
import com.solak.workshopmongo.repository.UserRepository;
import com.solak.workshopmongo.services.exception.ObjectNotFoundException;


@Service
public class UserService {
	
	@Autowired  // injeção de dependência do spring, instanciando o objeto auto
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id){
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	//para manutenção para acesso a dados
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}

}
