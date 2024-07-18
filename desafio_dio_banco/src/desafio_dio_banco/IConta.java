package desafio_dio_banco;

import java.util.List;

public interface IConta {
	
	void sacar(double valor);
	void depositar(double valor);
	void transferir(double valor, Conta contaDestino);
	void imprimirExtrato();
	void concederCredito(double valor);
	double investir(double valor);
	void pagarFuncionarios(double salario, List<Conta> funcionarios);

}
