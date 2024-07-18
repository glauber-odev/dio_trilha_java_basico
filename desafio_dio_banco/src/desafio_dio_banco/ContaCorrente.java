package desafio_dio_banco;

public class ContaCorrente extends Conta {
	
	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("******* EXTRATO CONTA CORRENTE *********");
		super.imprimirInfosComuns();
	}
}
