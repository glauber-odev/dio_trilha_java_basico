package dio.primeirospassos.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix="remetente")
public class Remetente {
	private String nome;
	private String email;
	private List<Long> telefones;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Long> getTelefones() {
		return telefones;
	}
	
	public void setTelefones(List<Long> telefone) {
		this.telefones = telefone;
	}
	
}
