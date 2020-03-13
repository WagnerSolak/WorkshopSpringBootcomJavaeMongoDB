package com.solak.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.solak.workshopmongo.domain.Post;
import com.solak.workshopmongo.services.PostService;

@RestController                   //para falar que a classe é um recurso rest usamos esta anotação
@RequestMapping(value="/posts")  // para falar qual é o caminho do endpoint, convenção (nome do recurso no plural)
public class PostResource {
	
	@Autowired
	private PostService service;
	

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id){ //@PathVariable para dizer que o id recebido é o mesmo da url
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
