package desafiocarrinhocompras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
	
	
	private List<Item> itensLista;
	
	public CarrinhoDeCompras() {
		this.itensLista = new ArrayList<Item>();
	}

	public void adicionarItem(String nome, double preco, int quantidade){
		itensLista.add(new Item(nome, preco, quantidade));
	}
	
	public void removerItem(String nome) {
		List<Item> listaRemocao = new ArrayList<Item>();
		for(Item item : itensLista) {
			if(item.getNome().equalsIgnoreCase(nome)) {
				listaRemocao.add(item);
			}
		}
		itensLista.removeAll(listaRemocao);
	}
	
	public double calcularValorTotal() {
		double valorTotal = 0;
		for(Item item : itensLista) {
			valorTotal += item.getQuantidade() * item.getPreco();
		}
		return valorTotal;
	}
	
	public void exibirItens() {
		System.out.println(itensLista);
	}



	public static void main(String[] args) {
		CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
		carrinhoDeCompras.adicionarItem("Melão", 5.50, 2);
		carrinhoDeCompras.adicionarItem("Goiaba", 3.50, 1);
		carrinhoDeCompras.adicionarItem("Melancia", 10, 1);
		carrinhoDeCompras.exibirItens();
		System.out.println("\n O valor total foi: "+carrinhoDeCompras.calcularValorTotal());
		
		carrinhoDeCompras.removerItem("melancia");
		carrinhoDeCompras.exibirItens();
		System.out.println("\n O valor sem a melancia: "+carrinhoDeCompras.calcularValorTotal());

	}

}
