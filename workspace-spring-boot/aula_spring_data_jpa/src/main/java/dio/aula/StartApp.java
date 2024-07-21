package dio.aula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import dio.aula.model.User;
import dio.aula.repository.UserRepository;

@Component
public class StartApp implements CommandLineRunner {
	private User user = new User();
	@Autowired
	private UserRepository repository;
	@Override
	public void run(String... args) throws Exception {
		user.setName("Marquinhos");
		user.setUsername("marquinh0$");
		user.setPassword("77777");
		
		repository.save(user);
		
		for(User u: repository.findAll()) {
			System.out.println(u);
		}
	}

}
