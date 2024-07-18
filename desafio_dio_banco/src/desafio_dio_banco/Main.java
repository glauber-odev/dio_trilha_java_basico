package desafio_dio_banco;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {		
		Conta cc = new ContaCorrente(new Cliente("José Josefino"));
		cc.depositar(200);
		System.out.println(String.format("Parabéns, seu investimento retornou R$%.2f !!!",cc.investir(200)));
		cc.sacar(50);
		
		Conta poupanca = new ContaPoupanca(new Cliente("Ostebaldo McLaren"));
		poupanca.depositar(500);
		poupanca.depositar(734.551755456);
		poupanca.concederCredito(500);

		
		Cliente maria = new Cliente("Maria");
		Conta contaMaria = new ContaSalario(maria);
		contaMaria.transferir(100, poupanca);
		List<Conta> funcionarios = new ArrayList<Conta>();
		funcionarios.add(contaMaria);
		funcionarios.add(new Conta(new Cliente("Roger Presman")));
		funcionarios.add(new Conta(new Cliente("Leila Silveira")));
		Conta patrao = new Conta(new Cliente("Patrao"));
		patrao.pagarFuncionarios(2559.20, funcionarios);
		
		System.out.println(String.format("Saldo da Maria agora: R$%.2f",contaMaria.getSaldo()));
		
		cc.imprimirExtrato();
		System.out.print("\n");
		poupanca.imprimirExtrato();
		System.out.print("\n");
		contaMaria.imprimirExtrato();
		

	}

}
