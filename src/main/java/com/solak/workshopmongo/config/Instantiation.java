package com.solak.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.solak.workshopmongo.domain.User;
import com.solak.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	// injetar o UserRepository
	@Autowired
	private UserRepository userRepository;
			
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bon Grey", "bob@gmail.com");
		User valdisney = new User(null, "Valdisney Silva", "val@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob, valdisney));
	}

}
