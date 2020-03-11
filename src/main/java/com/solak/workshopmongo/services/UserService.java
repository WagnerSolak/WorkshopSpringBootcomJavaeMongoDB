package com.solak.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solak.workshopmongo.domain.User;
import com.solak.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired  // injeção de dependência do spring, instanciando o objeto auto
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}

}
