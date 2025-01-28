package pacman;

import pacman.Tablero;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Pacman pacman = new Pacman();
        Tablero tablero = new Tablero(15,19,pacman);
        Scanner sc = new Scanner(System.in);

        System.out.println("""
                           Bienvenido al clasico juego del Pacman
                           
                           Elige la dificultad pulsando un número
                           
                           1.Facil      2.Medio      3.Dificil
                           
                           """);

        int dificultad = sc.nextInt();

        tablero.crearTablero();
        
        if(dificultad == 1){
            pacman.setVidasRestantes(3);
        }
        else if(dificultad == 2){
            pacman.setVidasRestantes(2);
        }
        else{
            pacman.setVidasRestantes(1);
        }
        
        
        /**
         * Aqui los fantasmas se crean, hay q añadirle un sleep de 500ms para q se 
         * mueva a la par del PacMan 
         */
        Fantasmas f1 = new Fantasmas(tablero,6,9);
        Fantasmas f2 = new Fantasmas(tablero);
        Fantasmas f3 = new Fantasmas(tablero);
        
        do{
            tablero.mostrarTablero();
            tablero.mostrarEstadisticas();
            
            
            
            
            
            
            
            
            
            
        /*
        }while(tablero.juegoTerminado()); para q funcione
        }while(tablero.getPuntuacion() == 200); para solo 1 vez
        */
        }while(tablero.juegoTerminado());
        
        String dificultadPalabra;
        if(dificultad == 1){
            dificultadPalabra = "facil";
        }
        else if(dificultad == 2){
            dificultadPalabra = "medio";
        }
        else{
            dificultadPalabra = "dificil";
        }
        
        System.out.println("Felicidades, has superado la modalidad "+dificultadPalabra);
        
        

    }



}
