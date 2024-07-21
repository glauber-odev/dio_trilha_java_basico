package dio.primeirospassos.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SistemaMensagem implements CommandLineRunner{
	@Value("${nome:Sem nome}")
	private String nome;
	@Value("${email:No-reply@dio}")
	private String email;
	@Value("${telefones}")
	private List<Long> telefone = new ArrayList<>(Arrays.asList(new Long[]{58925892L}));
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Mensagem enviada por: "+nome+
				"\nE-mail: "+email+
				"\nCom telefone para contato: "+telefone);
		System.out.println("Seu cadastro foi aprovado!");
		
	}

}
