package pacman;

import pacman.Tablero;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Tablero tablero = new Tablero(15,19);
        Scanner sc = new Scanner(System.in);

        System.out.println("""
                           Bienvenido al clasico juego del Pacman
                           
                           Elige la dificultad pulsando un número
                           
                           1.Facil      2.Medio      3.Dificil
                           
                           """);

        int dificultad = sc.nextInt();

        tablero.crearTablero();
        
        
        /**
         * Pacman aqui nace, hay q añadirle un Sleep de 500ms si quiero q se mueva
         * cada medio segundo
         */
        Pacman pacman = new Pacman();
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
        Fantasmas f1 = new Fantasmas();
        Fantasmas f2 = new Fantasmas();
        Fantasmas f3 = new Fantasmas();
        
        do{
            
            f1.start();
            f2.start();
            f3.start();
            pacman.start();
            
            
            
            tablero.mostrarTablero();
            tablero.mostrarEstadisticas();
            
            
            
            
        /*
        }while(tablero.juegoTerminado());
        */
        }while(tablero.getPuntuacion() == 200);
        
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
