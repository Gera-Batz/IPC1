import java.util.Scanner;
public class JuegoHanoi {
    static Scanner scanner = new Scanner(System.in);
   public static void hanoi (){
       System.out.println("Bienvenido al juego de las torres de Hanoi");
       System.out.println("Puedes mover solamente un disco a la vez");
       System.out.println("ningun disco puede estar sobre una disco más pequeño");
       controlHanoi();
   }
   private static void controlHanoi(){
       int jugar;
       System.out.println("Quieres jugar? 1.SI 2.NO, cualquier numero para salir de la app");
       jugar = Integer.valueOf(scanner.next());
       if (jugar == 1) {
           inicioJuego();
       }else if (jugar == 2) {
           InicioJuegoyAhorcado.seleccionDeJuegos();
       }else{
           InicioJuegoyAhorcado.salirDelJuego();
       }
   }
   private static void inicioJuego(){
       int cantidadDiscos;
       System.out.println("De cuantos discos quieres las torres?");
       cantidadDiscos = Integer.valueOf(scanner.next());
       crearTorre(cantidadDiscos);
   }
   private static void crearTorre(int cantidadDiscos){
        String torrePrincipal[] = new String [10];
        String torre1[] = new String [cantidadDiscos];
        torrePrincipal[0] = "1";			
        torrePrincipal[1] = "22";	
	torrePrincipal[2] = "333";
	torrePrincipal[3] = "4444";
	torrePrincipal[4] = "55555";
	torrePrincipal[5] = "666666";
	torrePrincipal[6] = "7777777";
	torrePrincipal[7] = "88888888";
	torrePrincipal[8] = "999999999";
	torrePrincipal[9] = "1111111111";
        
        for (int i = 0; i < cantidadDiscos; i++) {
           torre1[i] = torrePrincipal[i];
            System.out.println(torre1[i]);
       }
        moverDisco(torre1, cantidadDiscos);
   }
   private static void moverDisco(String torre1[], int cantidadDiscos){
       int disco;
       int torreInicial;
       int torreFinal;
       boolean finalizarJuego = false;
       String torre2[] = new String[torre1.length];
       String torre3[] = new String[torre1.length];
       for (int i = 0; i < torre1.length; i++) {
           torre2[i] = "h";
           torre3[i] = "h";
       }

       do{
            System.out.println("Que disco quieres mover?");
            disco = Integer.valueOf(scanner.next())-1;
            System.out.println("En que torre esta?");
            torreInicial = Integer.valueOf(scanner.next());
            System.out.println("A que torre quieres moverlo?");
            torreFinal = Integer.valueOf(scanner.next());
            verificarDisco(torre1, torre2, torre3, disco, torreInicial, cantidadDiscos);
      
       } while (finalizarJuego != false);
       
   }
   private static void verificarDisco(String [] torre1, String [] torre2, String [] torre3, int disco, int torreInicial, int torreFinal){

       switch (torreInicial) {
           case 1:
               
               break;
         
       }
 
      imprimirTorres(torre1, torre2, torre3);
      
       
   }
   private static void imprimirTorres(String []torre1, String[] torre2, String [] torre3){
       for (int i = 0; i < torre1.length; i++) {
           System.out.println(""+torre1[i]);
       }
       System.out.println("Torre 2");
       for (int i = 0; i < torre1.length; i++) {
           System.out.println(""+ torre2[i]);
       }
       System.out.println("Torre 3");
       for (int i = 0; i < torre3.length; i++) {
           System.out.println(""+torre3[i]);
       }
   }
}
