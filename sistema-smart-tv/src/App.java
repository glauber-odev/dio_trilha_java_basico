public class App {
    public static void main(String[] args) throws Exception {
        
        SmartTv smartTv = new SmartTv();

        System.out.println("\nTV ligada : "+smartTv.ligada);
        System.out.println("Volume atual : "+smartTv.volume);
        System.out.println("Canal atual : "+smartTv.canal);

        smartTv.ligar();
        System.out.println("Novo status -> TV ligada "+smartTv.ligada);

        smartTv.desligar();
        System.out.println("Novo status -> TV ligada "+smartTv.ligada);
    }
}
