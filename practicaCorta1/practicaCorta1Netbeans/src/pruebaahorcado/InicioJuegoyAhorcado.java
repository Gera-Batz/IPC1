/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaahorcado;


import java.util.Scanner;

/**
 *
 * @author gera-batz
 */
public class InicioJuegoyAhorcado {

    /**
     * @param args the command line arguments
     */
    static Scanner scanner = new Scanner(System.in);
    static int opciones;
    public static void main(String[] args) {        // Verifica si envian un parametro desde el inicio
                                                                                                            
        if (args.length < 1) {
            System.out.println("Bienvenido a la librería de Juegos");
            seleccionDeJuegos();  
        }else{
            parametroEnviado(args[0]);
        }

    }
    private static void parametroEnviado(String juego){ //Recibe el parametro enviado y redirige el programa ha donde es solicitado
        switch (juego) {
            case "Ahorcado":
                controlJuegoAhorcado();
                break;
            case "Basquetball":
                JuegoBasquetball.controlJuegoBasquetball();
                break;
            case "Cartas":
                JuegoCartas.juegoCartas();
                break;
            case "Hanoi":
                JuegoHanoi.hanoi();
                break;
           
        }
    }
    
    private static void controlJuegoAhorcado(){
        
        System.out.println("Juego del Ahorcado");
        System.out.println("Que quieres hacer?");
        System.out.println("1. Jugar");
        System.out.println("2. Instrucciones");
        System.out.println("3. Menu de Juegos");
        System.out.println("3. Salir");
        opciones = scanner.nextInt();
        switch(opciones){
            case 1:
                System.out.println("Ingrese la palabra a ser buscada, solo letras minusculas");
                String palabraOculta = scanner.next();

                juegoAhorcado(palabraOculta);
                break;
            case 2:
                System.out.println("La idea es encontrar la palabra indicada al inicio,");
                System.out.println("el juego le indicara si es correcta o no la letra ingresada.");
                System.out.println("En caso de que sea correcta, la letra sera colocada en su");
                System.out.println("posición, si no es correcta, se ira dibujando a una persona");
                System.out.println("con una soga colocada en el cuello, poco a poco.");
                System.out.println("El juego termina en el momento en que se descubra la palabra");
                System.out.println("o sea ahorcada la persona, Buena suerte...!!!");
                controlJuegoAhorcado();
                break;
            case 3:
                seleccionDeJuegos();
                break;
            case 4:
                salirDelJuego();
                break;
        
        }
    }
    private static void juegoAhorcado(String palabraEncontrar){ //Recibe la palabra a encontrar
        char [] letras = palabraEncontrar.toCharArray(); //Convierte la palabra en un arreglo de tipo Char
        char [] guionesBajos = new char[letras.length];  
        char encontrandoPalabra;
        int error = 0;
        int errorFigura = 0;
        int verificarPalabra = 0;
        boolean victoria = false;
        
        
        for (int i = 0; i < letras.length; i++) {       //llena el arreglo con guiones bajos
            guionesBajos[i] = '_';
        }
        
        System.out.println(guionesBajos);
        
        do{
            System.out.println("Ingrese la letra que usted crea que esta en la palabra");
            encontrandoPalabra = scanner.next().charAt(0);
            for (int i = 0; i < letras.length; i++) {       //verifica si la letra que ingresa el usuario esta en la palabra a encontrar
                if (encontrandoPalabra == letras[i]) {
                    guionesBajos[i] = encontrandoPalabra;
                    verificarPalabra = verificarPalabra + 1;
                }else{
                    error = error+1;                        //contador para los errores cometidos
                }               
            }
            if (verificarPalabra == letras.length) {        //verifica si la palabra fue encontrada
                victoria = true;
                System.out.println("ha ganado");
            }else{
                victoria = false;
                if (error == letras.length) {               //verifica si fallo
                    errorFigura = errorFigura + 1;
                    switch(errorFigura){                    //muestra las figuras del Ahorcado
                    case 1:
                        FigurasAhorcados.error1();
                        break;
                    case 2:
                        FigurasAhorcados.error2();
                        break;
                    case 3:
                        FigurasAhorcados.error3();
                        break;
                    case 4:
                        FigurasAhorcados.error4();
                        break;
                    case 5:
                        FigurasAhorcados.error5();
                        break;
                    case 6:
                        FigurasAhorcados.error6();
                        victoria = true;
                        System.out.println("Has perdido");
                        
                        break;
                    }
                }
            }
            
           
        
        System.out.println(guionesBajos);
        error = 0;
        }while(victoria == false);
        controlJuegoAhorcado();
    }
    public static void salirDelJuego(){         // Finaliza la aplicación
        System.exit(0);
    }
    public static void seleccionDeJuegos(){    //Selecciona el juego que quiere el usuario
        int opcionJugar;
        System.out.println("Que juego quieres?");
        System.out.println("1. Ahorcado");
        System.out.println("2. Basquetball");
        System.out.println("3. Juego de Cartas");
        System.out.println("4. Hanoi");
        System.out.println("5. No jugar");
        opcionJugar = scanner.nextInt();
        switch(opcionJugar){
            case 1:
                    controlJuegoAhorcado();
                break;
            case 2:
                    JuegoBasquetball.controlJuegoBasquetball();
                break;
            case 3:
                    JuegoCartas.juegoCartas();
                break;
            case 4:
                    JuegoHanoi.hanoi();
                break;
            case 5:
                    salirDelJuego();
                break;
        }
    } 
}
