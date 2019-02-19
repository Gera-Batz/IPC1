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
public class JuegoCartas {
    static Scanner scanner = new Scanner(System.in);
    public static void juegoCartas() {              //inicio del juego
        System.out.println("Bienvenido al CASINO 'IPC'");
        juegoNuevo();
            
    }
    private static void instrucciones() {           //Instrucciones del Juego
        System.out.println("Instrucciones:");
        System.out.println("Antes de empezar a jugar, tienes que apostar");
        System.out.println("Tú indicas cuanto traes de efectivo");
        System.out.println("El casino estara dando cartas al azar, y");
        System.out.println("si la carta por la que tu apuestas esta en el ");
        System.out.println("rango de las que salieron anteriomente, tu ganas");
        System.out.println("la cantidad que apostaste.");
        System.out.println("El juego termina hasta que te quedes sin dinero");
        System.out.println("Buena suerte");
        juegoNuevo();
    }
    private static void juegoNuevo() {              //Pregunta si quiere volver a jugar o hacer otra cosa
        int jugarDeNuevo;
        System.out.println("Quieres jugar?");
        System.out.println("1. Si 2. No 3. Instrucciones 4. Salir de la aplicacion");
        jugarDeNuevo = Integer.valueOf(scanner.next());
        switch (jugarDeNuevo) {
            case 1:
                controlJuego();
                break;
            case 2:
                System.out.println("Gracias por visitarnos");
                InicioJuegoyAhorcado.seleccionDeJuegos();
                break;
            case 3:  
                instrucciones();
                break;
            case 4:
                InicioJuegoyAhorcado.salirDelJuego();
                break;
        }
        
    }
    private static void controlJuego() {            //Control del juego
        int efectivo;
        int primerCarta;
        int segundaCarta;
        int tercerCarta;
        int apuesta;
        boolean apuestaCorrecta = false;
        System.out.println("Con cuanto efectivo empezaras a jugar?");   //Recepción del efectivo para jugar
        efectivo = Integer.valueOf(scanner.next());
        while (efectivo > 0) {                                          //ciclo para jugar hasta que se le acabe el dinero
            System.out.println("Efectivo actual: "+efectivo);
            do {                                                        //ciclo para crear las cartas
                primerCarta = (int)(Math.random()*11)+1;                //Random hasta 11 porque o puede ser 12 la primer carta
                segundaCarta = (int)(Math.random()*13)+1;               //Random de 1 a 1
            } while (primerCarta > segundaCarta);                       //el ciclo termina hasta que la segunda carta sea mayor que la primera
            
            tercerCarta = (int)(Math.random()*13)+1;                    //Random para saber que carta es la que sale despues de apostar
            System.out.println("Las cartas son:");
            System.out.println("Primer Carta: "+tipoDeCarta(primerCarta)+" Segunda Carta: "+ tipoDeCarta(segundaCarta));
            do {                                                        //ciclo para saber cuanto apostara el ususario
                System.out.println("Cuanto Apostaras?");
                apuesta = Integer.valueOf(scanner.next());
                if (apuesta > efectivo) {
                    System.out.println("vuelva a intentarlo");
                    apuestaCorrecta = false;
                }else {
                    apuestaCorrecta = true;
                }
            } while (apuestaCorrecta != true);                          //ciclo hasta que laapuesta sea correcta
            System.out.println("Apostaste: Q"+apuesta);
            System.out.println("La carta es: "+tipoDeCarta(tercerCarta));
            if (tercerCarta >= primerCarta && tercerCarta <= segundaCarta) {    //verifica si el usuario aposto bien o no
                System.out.println("Has ganado");                               
                efectivo = efectivo + apuesta;                                  //suma lo que fue apostado
            }else{
                efectivo = efectivo - apuesta;                                  //resta lo que fue apostado
                System.out.println("Has apostado mal");
            }
        }
        juegoNuevo();
    }
    
    private static String tipoDeCarta(int carta){  //retorna un string, dependiendo del valor que se le envie por parametros
        switch (carta) {
            case 1:
                return "A";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "10";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
        }
        return "no valido";
    }
    
}
