package com.solak.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.solak.workshopmongo.domain.User;
import com.solak.workshopmongo.dto.UserDTO;
import com.solak.workshopmongo.services.UserService;

@RestController                   //para falar que a classe é um recurso rest usamos esta anotação
@RequestMapping(value="/users")  // para falar qual é o caminho do endpoint, convenção (nome do recurso no plural)
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET)      // = usar @GetMapping
	public ResponseEntity<List<UserDTO>>  findAll(){
		//forma manual de teste
//		User maria = new User("1", "Maria Brown", "maria@gmail.com"); 
//		User alex  = new User("2", "Alex Green", "alex@gmail.com"); 
//		
//		List<User> list = new ArrayList<User>();
//		list.addAll(Arrays.asList(maria, alex));
//		return ResponseEntity.ok().body(list);       //ok: instancia o ResponseEntity já com a resposta
		
		List<User> list = service.findAll();
		// antes do DTO
		//return ResponseEntity.ok().body(list);      // devolvo a list na resposta da requisição
		
		//com DTO
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
