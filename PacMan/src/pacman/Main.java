package pacman;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Pacman pacman = new Pacman();
        Tablero tablero = new Tablero(15, 19, pacman);
        pacman.setTablero(tablero);

        boolean dificultadValida = false;
        
            
                Scanner sc = new Scanner(System.in);
                
            
                
        
        System.out.println("""
                           Bienvenido al clásico juego del Pacman
                           
                           Elige la dificultad pulsando un número
                           
                           1. Fácil      2. Medio      3. Difícil
                           
                           """);

        
                int dificultad = sc.nextInt();
                
        
        

        tablero.crearTablero();

        if (dificultad == 1) {
            pacman.setVidasRestantes(3);
        } else if (dificultad == 2) {
            pacman.setVidasRestantes(2);
        } else {
            pacman.setVidasRestantes(1);
        }

        Fantasmas f1 = new Fantasmas(tablero, 6, 9);
        Fantasmas f2 = new Fantasmas(tablero);
        Fantasmas f3 = new Fantasmas(tablero);

        PedirDireccion pedirDireccion = new PedirDireccion(tablero);
        

        try {
            System.out.println("The game starts in : 3");
            System.out.println("");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Juego interrumpido: " + e.getMessage());
        }

        try {
            System.out.println("The game starts in : 2");
            System.out.println("");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Juego interrumpido: " + e.getMessage());
        }

        try {
            System.out.println("The game starts in : 1");
            System.out.println("");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Juego interrumpido: " + e.getMessage());
        }
        
        pedirDireccion.start();

        f1.start();
        f2.start();
        f3.start();
        pacman.start();

        while (!tablero.juegoTerminado()) {

            tablero.mostrarTablero();
            tablero.mostrarEstadisticas();
            System.out.println("");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Juego interrumpido: " + e.getMessage());
            }
        }

        String dificultadPalabra = switch (dificultad) {
            case 1 ->
                "fácil";
            case 2 ->
                "medio";
            default ->
                "difícil";
        };

        System.out.println("Felicidades, has superado la modalidad " + dificultadPalabra);
    }
}
