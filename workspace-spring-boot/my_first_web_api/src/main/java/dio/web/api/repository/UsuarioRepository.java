package dio.web.api.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import dio.web.api.controller.CampoObrigatorioException;
import dio.web.api.handler.BusinessException;
import dio.web.api.model.Usuario;

@Repository
public class UsuarioRepository {
	public void save(Usuario usuario) {
		if(usuario.getLogin()==null)
			throw new CampoObrigatorioException("O campo login é obrigatório");
		
		if(usuario.getPassword()==null)
			throw new CampoObrigatorioException("O campo password é obrigatório");
		
		if(usuario.getId()==null)
			System.out.println("SAVE - Imprimindo novo usuário");
		else
			System.out.println("UPDATE - Recebendo o usuário na camada de repositório");
		
		System.out.println(usuario);
	}
	
	public void deleteById(Integer id) {
		System.out.println(String.format("DELETE/id - Recebendo o id: %d para ", id));
		System.out.println(id);
	}
	
	public List<Usuario> findAll(){
		System.out.println("LIST - Listando os usuários do sistema.");
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario( "Jobson", "axlylz"));
		usuarios.add(new Usuario( "Mcalister", "oofkdau"));
		return usuarios;
	}
	public Usuario findById(Integer id) {
		System.out.println(String.format("DELETE/id - Recebendo o id: %d para ", id));
		return new Usuario("Gleyson", "password");		
	}
	public Usuario findByUsername(String username) {
		System.out.println(String.format("DELETE/username - Recebendo o id: %s para ", username));
		return new Usuario(username, "password");		
	}
}
