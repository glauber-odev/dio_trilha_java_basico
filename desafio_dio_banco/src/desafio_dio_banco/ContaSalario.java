package desafio_dio_banco;

public class ContaSalario extends Conta{

	public ContaSalario(Cliente cliente) {
		super(cliente);
	}
	
	@Override
	public void imprimirExtrato() {
		System.out.println("******* EXTRATO CONTA SALARIO *********");
		super.imprimirInfosComuns();
	}
	
}
