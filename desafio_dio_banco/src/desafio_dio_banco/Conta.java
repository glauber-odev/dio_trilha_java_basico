package desafio_dio_banco;

import java.util.List;

public class Conta implements IConta {

	protected static final int AGENCIA_PADRAO = 0001;
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	protected double valorCreditado;
	
	private static int SEQUENCIAL = 1;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}
	
	@Override
	public void sacar(double valor) {
		saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
		
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}
	
	@Override
	public void imprimirExtrato() {
		System.out.println(String.format("Seu saldo: R$%2.f",this.getSaldo()));
		
	}
	
	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s",this.cliente.getNome()));
		System.out.println(String.format("Agência: %s",this.getAgencia()));
		System.out.println(String.format("Numero: %d",this.getNumero()));
		System.out.println(String.format("Saldo: R$%.2f",this.getSaldo()));
	}
	
	@Override
	public void concederCredito(double valor) {
		this.valorCreditado += valor;
		this.saldo += valor;
	}
	
	@Override
	public double investir(double valor) {
		//adiciona um valor que pode ser até 10% a mais do que o valor original
		valor *= (0.10 * Math.random());
		this.saldo += valor;
		return valor;
	}
	
	@Override
	public void pagarFuncionarios(double salario, List<Conta> funcionarios) {
		funcionarios.stream().forEach(n -> n.depositar(salario));
		System.out.println("Funcionários pagos com sucesso!");
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	
}
