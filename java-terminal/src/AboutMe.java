public class AboutMe {

    public static void main(String[] args){

        String nome = args[0];
        String sobrenome = args[1];
        int idade = Integer.valueOf(args[2]);
        double altura = Double.valueOf(args[3]);

        System.out.println("Minhas características\n-------------------");
        System.out.println("Nome: "+nome);
        System.out.println("Sobrenome: "+sobrenome);
        System.out.println("Idade: "+idade);
        System.out.println("Altura: "+altura);
        System.out.println("\n-------------------");
    }

}
