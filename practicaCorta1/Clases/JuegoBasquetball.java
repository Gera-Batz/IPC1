import java.util.Scanner;
public class JuegoBasquetball {
    private static int tiroLargo1;
    private static int tiroLargo2;
    private static int tiroCorto1;
    private static int tiroCorto2;
    private static int porcentajeTiroLargo1 = 65;
    private static int porcentajeTiroCorto1 = 80;
    private static int porcentajeTiroLargo2 = 65;
    private static int porcentajeTiroCorto2 = 80;
    private static int puntos1 = 0;
    private static int puntos2 = 0;
    
    
    static Scanner scanner = new Scanner(System.in);
    public static void controlJuegoBasquetball(){
        introduccion();
    }
    private static void introduccion(){    //Inicio del Juego y da las instrucciones
        System.out.println("Bienvenido a Basquetball");
        System.out.println("Sera un juego por turnos, cada uno de los dos jugadores podrá hacer tiros");
        System.out.println("y támbien movimientos defensivos");
        System.out.println("Por turno podrán hacer dos tipos de tiro:");
        System.out.println("1) Tiro largo, se hace desde 5 metros, obtienes 3 puntos si encestas");
        System.out.println("2) Tiro corto, se hace desde 3 metros, obtienes 2 puntos si encestas");
        System.out.println("si no quieren hacer algun tipo de tiro, podrán hacer 2 tipos de moviminetos defensivos");
        System.out.println("1) Dfensa cuerpo a cuerpo, reducirán la probabilidad de enceste, y la probabilidad de");
        System.out.println("hacer falta sera medianamente baja");
        System.out.println("2) Defensafuerte, la probabilidad de enceste del contrario sera muchisimo menor, pero");
        System.out.println("la probabilidad de realizar una falta sera alta");
        System.out.println("se hacen alguna falta, el jugador al que se la hallan hecho, tendrá");
        System.out.println("un 'tiro libre', obtendrá 2 puntos si encesta");
        jugarDeNuevo();
    }
    private static void jugarDeNuevo(){ //Pregunta al usuario si desea jugar
        int jugar;
        System.out.println("Quieres jugar? 1. Si, 2.No, cualquier otro numero para salir de la aplicación ");
        jugar = Integer.valueOf(scanner.next());
        if (jugar == 1) {
            solicitarNombres();
        }else if (jugar == 2) {
            InicioJuegoyAhorcado.seleccionDeJuegos();
        }else{
            InicioJuegoyAhorcado.salirDelJuego();
        }
    }
    private static void solicitarNombres(){ //Solicita Nombres
        String primerJugador;
        String segundoJugador;
        
        System.out.println("Necesitamos que nos indiquen los nombres de los jugadores");
        System.out.println("Ingresar el nombre del primer jugador");
        primerJugador = scanner.next();
        System.out.println("Ingresar el nombre del segundo Jugador");
        segundoJugador = scanner.next();
        System.out.println("Primer Jugador: "+primerJugador+", Segundo Jugador: "+segundoJugador);
        juegoBasquetball(primerJugador, segundoJugador);
    }
    private static void juegoBasquetball(String primerJugador, String segundoJugador){ //genera el primer turno
        int turno = (int)(Math.random()*2)+1;
        int cantidadTurnos = 0;
        int VUELTAS_TOTALES= 10;
        switch (turno) {
            case 1:
                System.out.println(""+primerJugador+" tiene el balón");
                break;
            case 2:
                System.out.println(""+segundoJugador+"tiene el balon");
                break;
        }
        do {
            if (turno == 1) {                                                       //verifica a que jugador le toca 
                controlTurno(primerJugador, turno, segundoJugador);
                turno = turno +1;
            }else{
                controlTurno(primerJugador, turno, segundoJugador);
                turno = turno - 1;
            }
            cantidadTurnos = cantidadTurnos + 1;
        } while (cantidadTurnos != VUELTAS_TOTALES);                                //termina el juego despues de cierta cantidad de turnos para cada jugador
        System.out.println(""+primerJugador+" obtuvo: "+puntos1+" puntos");
        System.out.println(""+segundoJugador+" obtuvo: "+puntos2+" puntos");
        if (puntos1 > puntos2) {                                                    //verifica quien gano
            System.out.println(""+primerJugador+" es el ganador");
        }else if (puntos2 > puntos1) {
            System.out.println(""+segundoJugador+" es el ganador");
        }else{
            System.out.println("empate");
        }
        jugarDeNuevo();
        
    }
    private static void controlTurno(String nombreJugador1, int numeroJugador, String nombreJugador2){  //Controla las acciones de cada jugador en su turno
        int hacer;
        int tipoTiroDefensa;
        if (numeroJugador == 1) {
            System.out.println("Turno de: "+nombreJugador1);
            System.out.println("Que deseas hacer: 1. Tiro, 2. Defensa");                                //Pregunta entre tiro y defensa
            hacer = Integer.valueOf(scanner.next());
            switch (hacer) {
                case 1:
                    System.out.println("1. Tiro Largo");                                                //Pregunta si quiere tiro largo o corto
                    System.out.println("2. Tiro Corto");
                    tipoTiroDefensa = Integer.valueOf(scanner.next());
                    if (tipoTiroDefensa == 1) {                                                         //verifica que escogio el jugador 1
                        System.out.println("Tiro Largo realizado");
                        tiroLargo1 = (int)(Math.random()*100)+1;                                        //Genera el numero aleatorio para saber si encesta o no el jugador
                        if (tiroLargo1 <= porcentajeTiroLargo1) {
                            System.out.println("Has encestado");
                            puntos1 = puntos1 + 3;                                                      //Sumas los puntos del jugador 1
                        }else{
                            System.out.println("No has encestado");
                        }
                    }else{
                        System.out.println("Tiro corto realizado");
                        tiroCorto1 = (int)(Math.random()*100)+1;
                        if (tiroCorto1 <= porcentajeTiroCorto1) {
                            System.out.println("Has encestado");
                            puntos1 = puntos1 + 2;                                                      //Suma los puntos del jugador 1
                            
                        }else{
                            System.out.println("No has encestado");
                        }
                    }
                    System.out.println(""+nombreJugador1+" tiene "+puntos1+" puntos");
                    porcentajeTiroLargo1 = 65;                                                          //Reinicio de los porcentajes de enceste
                    porcentajeTiroCorto1 = 80;
                    break;
                case 2:
                    System.out.println("1. Cuerpo a Cuerpo");                                           //Pregunta si quiere defensa cuerpo a cuerpo o fuerte
                    System.out.println("2. Fuerte");
                    tipoTiroDefensa = Integer.valueOf(scanner.next());
                    if (tipoTiroDefensa == 1) {                                                         //Verifica que escogio el jugador 1
                        System.out.println("Defensa cuerpo a cuerpo realizada");

                        int falta = (int)(Math.random()*100)+1;                                         //Aleatorio para saber si la defensa es limpia o hay falta
                        if (falta <= 35) {
                            System.out.println("Has hecho falta, "+nombreJugador2+"tienes tiro libre");
                            System.out.println(""+nombreJugador2+" realiza su tiro libre");
                            int tiroLibre = (int)(Math.random()*100)+1;                                 //Aleatroio para saber si el contrario encesta su tiro libre
                            if (tiroLibre <=90) {                                                       //verifica si hubo falta
                                System.out.println("TiroLibre encestado");
                                puntos2 = puntos2 + 2;
                            }else{
                                System.out.println("Tiro libre fallado");
                            }
                        }else{
                            System.out.println("Defensa Limpia");
                            porcentajeTiroLargo2 = porcentajeTiroLargo2 - 15;                           //Nuevos valores de los porcentajes de tiro
                            porcentajeTiroCorto2 = porcentajeTiroCorto2 -15;
                        }
                    }else{
                        System.out.println("Defensa fuerte realizada");

                        int falta = (int)(Math.random()*100)+1;                                        //Aleatorio para saber si realiza falta o no
                        if (falta <= 65) {
                            System.out.println("Has hecho falta, "+nombreJugador2+"tienes tiro libre");
                            System.out.println(""+nombreJugador2+" realiza su tiro libre");
                            int tiroLibre = (int)(Math.random()*100)+1;
                            if (tiroLibre <=90) {                                                       //Verifica si el contrario encesto el tiro libre
                                System.out.println("Tiro Libre encestado");
                                puntos2 = puntos2 + 2;
                            }else{
                                System.out.println("Tiro libre fallado");
                            }
                        }else{
                            System.out.println("Defensa Limpia");
                            porcentajeTiroLargo2 = porcentajeTiroLargo2 -30;                            //Nuevos valores de los porcentajes de tiro
                            porcentajeTiroCorto2 = porcentajeTiroCorto2 -30;
                        }
                    }
                    break;
            }
        }else{
            System.out.println("Turno de: "+nombreJugador2);
            System.out.println("Que deseas hacer: 1. Tiro, 2. Defensa");
            hacer = Integer.valueOf(scanner.next());
            switch (hacer) {
                case 1:
                    System.out.println("1. Tiro Largo");                                                //Escogen que tipo de tiro hacer
                    System.out.println("2. Tiro Corto");
                    tipoTiroDefensa = Integer.valueOf(scanner.next());
                    if (tipoTiroDefensa == 1) {
                        System.out.println("Tiro Largo realizado");
                        tiroLargo2 = (int)(Math.random()*100)+1;
                        if (tiroLargo2 <= porcentajeTiroLargo2) {
                            System.out.println("Has encestado");
                            puntos2 = puntos2 + 3;
                        }else{
                            System.out.println("No has encestado");
                        }
                    }else{
                        System.out.println("Tiro Largo realizado");
                        tiroCorto2 = (int)(Math.random()*100)+1;
                        if (tiroCorto2 <= porcentajeTiroCorto2) {
                            System.out.println("Has encestado");
                            puntos2 = puntos2 + 2;
                        }else{
                            System.out.println("No has encestado");
                        }
                    }
                    System.out.println(""+nombreJugador2+" tiene "+puntos2+" puntos");
                    porcentajeTiroLargo2 = 65;                                                          //porcentajes originales de tiro del jugador
                    porcentajeTiroCorto2 = 80;
                    break;
                case 2:
                    System.out.println("1. Cuerpo a Cuerpo");
                    System.out.println("2. Fuerte");
                    tipoTiroDefensa = Integer.valueOf(scanner.next());
                    if (tipoTiroDefensa == 1) {                                                         //Escoge tipo de defensa
                        System.out.println("Defensa cuerpo a cuerpo realizada");

                        int falta = (int)(Math.random()*100)+1;
                        if (falta <= 35) {                                                              //verifica si hubo falta
                            System.out.println("Has hecho falta, "+nombreJugador1+"tienes tiro libre");
                            System.out.println(""+nombreJugador1+" realiza su tiro libre");
                            int tiroLibre = (int)(Math.random()*100)+1;
                            if (tiroLibre <=90) {                                                       //verifica si fue encestado el tiro libre del contrario
                                System.out.println("TiroLibre encestado");
                                puntos1 = puntos1 + 2;
                            }else{
                                System.out.println("Tiro libre fallado");
                            }
                        }else{
                            System.out.println("Defensa Limpia");
                            porcentajeTiroLargo1 = porcentajeTiroLargo1 - 15;                           //cambio de los porcentajes de defensa
                            porcentajeTiroLargo1 = porcentajeTiroLargo1 -15;
                        }
                    }else{
                        System.out.println("Defensa fuerte realizada");

                        int falta = (int)(Math.random()*100)+1;
                        if (falta <= 65) {                                                              //verifica si hay falta
                            System.out.println("Has hecho falta, "+nombreJugador1+"tienes tiro libre");
                            System.out.println(""+nombreJugador1+" realiza su tiro libre");
                            int tiroLibre = (int)(Math.random()*100)+1;
                            if (tiroLibre <=90) {                                                       //verifica si fue encestado el tiro libre del contrario
                                System.out.println("Tiro Libre encestado");
                                puntos1 = puntos1 + 2;
                            }else{
                                System.out.println("Tiro libre fallado");
                            }
                        }else{
                            System.out.println("Defensa Limpia");
                            porcentajeTiroLargo1 = porcentajeTiroLargo1 -30;                            //nuevos valores de los porcentajes de tiro del contrario
                            porcentajeTiroCorto1 = porcentajeTiroCorto1 -30;
                        }
                    }
                    break;
            }
        
        
        }
    }
    
}
