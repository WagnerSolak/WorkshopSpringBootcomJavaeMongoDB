package com.solak.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.solak.workshopmongo.domain.Post;
import com.solak.workshopmongo.domain.User;
import com.solak.workshopmongo.dto.AuthorDTO;
import com.solak.workshopmongo.repository.PostRepository;
import com.solak.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	// injetar o UserRepository
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
			
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bon Grey", "bob@gmail.com");
		User valdisney = new User(null, "Valdisney Silva", "val@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob, valdisney));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom Dia", "Acordei feliz hoje só!", new AuthorDTO(maria));
		
		
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
