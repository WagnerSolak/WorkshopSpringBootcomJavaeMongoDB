package com.solak.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solak.workshopmongo.domain.Post;
import com.solak.workshopmongo.repository.PostRepository;
import com.solak.workshopmongo.services.exception.ObjectNotFoundException;


@Service
public class PostService {
	
	@Autowired  // injeção de dependência do spring, instanciando o objeto auto
	private PostRepository repo;
	
	
	
	public Post findById(String id){
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

	}
	
	

}
