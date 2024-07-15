public class CaixaEletronico {

    public static void main(String[] args){
        double saldo = 25.0;
        double valorSolicitado = 177.0;

        if(valorSolicitado < saldo)
            saldo = saldo - valorSolicitado;
        else
            System.out.println("Ops, Saldo insuficiente");

        System.out.println("Valor do saldo mais R$5,00 é "+(saldo+5));
    }

}
