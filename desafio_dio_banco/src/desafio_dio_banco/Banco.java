package desafio_dio_banco;

import java.util.List;

public class Banco {
	
	protected String nome;
	protected List<Conta> contas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
