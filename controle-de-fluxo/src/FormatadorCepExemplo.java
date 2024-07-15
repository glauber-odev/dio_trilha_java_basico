public class FormatadorCepExemplo {

    public static void main(String[] args) {
        try {
            //String cepFormatado = formatarCep("237650649999");
            String cepFormatado = formatarCep("23765064");
            System.out.println(cepFormatado);
        } catch (CepInvalidoException e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
            System.out.println("O CEP não correponde com as regras de negócio");
        }
        
    }
    static String formatarCep(String cep) throws CepInvalidoException{
        if(cep.length() != 8)
            throw new CepInvalidoException();

            return "23.765-064";
            
    }

    static String chama(String cepInserido){
        return cepInserido;
    }

}
