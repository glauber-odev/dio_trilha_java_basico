package dio.dio_spring_security_jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private dio.dio_spring_security_jwt.security.UserRepository repository;
	@Autowired
	private PasswordEncoder encoder;

	public void createUser(dio.dio_spring_security_jwt.model.User user) {
		String pass = user.getPassword();
		// criptografando antes de salvar no banco
		user.setPassword(encoder.encode(pass));
		repository.save(user);
	}
}
