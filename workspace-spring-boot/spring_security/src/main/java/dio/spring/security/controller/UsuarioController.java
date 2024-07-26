package dio.spring.security.controller;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dio.spring.security.model.Usuario;
import dio.spring.security.repository.UsuarioRepository;

@RestController
@RequestMapping("/users")
public class UsuarioController {
//	@Autowired
//	private UsuarioRepository repository;
//	@GetMapping
//	public List<Usuario> getUsers(){
//		return repository.findAll();
//	}
//	
//	@GetMapping("/{username}")
//	public Usuario getOne(@PathVariable("username") String username) {
//		return repository.findByUsername(username);
//		
//	}
//	
//	@DeleteMapping("/{id}")
//	public void deleteUser(@PathVariable("id") Integer id) {
//		repository.deleteById(id);
//	}
//	
//	@PostMapping
//	public void createUser(@RequestBody Usuario usuario) {
//		repository.save(usuario);
//	}
//	
//	@PutMapping
//	public void putUser(@RequestBody Usuario usuario ) {
//		repository.save(usuario);
//	}
//	
}
