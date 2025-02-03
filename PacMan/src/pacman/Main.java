package pacman;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Pacman pacman = new Pacman();
        Tablero tablero = new Tablero(15, 19, pacman, null);
        pacman.setTablero(tablero);

        ArrayList<Fantasmas> fantasmasList = new ArrayList<>();
        
        tablero.setFantasmasList(fantasmasList);

        boolean dificultadValida = false;

        Scanner sc = new Scanner(System.in);

        System.out.println("""
                           Bienvenido al clásico juego del Pacman
                           
                           Elige la dificultad pulsando un número
                           
                           1. Fácil   2. Medio   3. Difícil  4. Hardcore
                           
                           """);

        int dificultad = sc.nextInt();

        tablero.crearTablero();

        if (dificultad == 1) {
            pacman.setVidasRestantes(3);
        } else if (dificultad == 2) {
            pacman.setVidasRestantes(2);
            tablero.setTiempo(130);
        } else if (dificultad == 3) {
            pacman.setVidasRestantes(1);
            tablero.setTiempo(110);
        } else {
            pacman.setVidasRestantes(1);
            tablero.setTiempo(90);
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

        pacman.start();

        if (dificultad == 4) {
            Fantasmas f4 = new Fantasmas(tablero);
            Fantasmas f5 = new Fantasmas(tablero);
            Fantasmas f6 = new Fantasmas(tablero);
            Fantasmas f7 = new Fantasmas(tablero);
            Fantasmas f8 = new Fantasmas(tablero);
            Fantasmas f9 = new Fantasmas(tablero);
            Fantasmas f10 = new Fantasmas(tablero);
            fantasmasList.add(f4);
            fantasmasList.add(f5);
            fantasmasList.add(f6);
            fantasmasList.add(f7);
            fantasmasList.add(f8);
            fantasmasList.add(f9);
            fantasmasList.add(f10);
        }

        // Añadir todos los fantasmas creados al ArrayList
        fantasmasList.add(f1);
        fantasmasList.add(f2);
        fantasmasList.add(f3);

        for (Fantasmas fantasma : fantasmasList) {
            fantasma.start();
        }

        while (!tablero.juegoTerminado()) {

            tablero.mostrarTablero();
            tablero.mostrarEstadisticas();
            System.out.println("");
            int tiempo = tablero.getTiempo();
            tiempo--;
            tablero.setTiempo(tiempo);

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

        if (tablero.getTiempo() == 0) {
            System.out.println("PERDISTE 😭 , EL TIEMPO LLEGO A 0");
        } else if (pacman.getVidasRestantes() == 0) {
            System.out.println("PERDISTE 😭 , TE QUEDASTE SIN VIDAS");
        } else if (pacman.getVidasRestantes() < 0) {
            System.out.println("Felicidades, has superado la modalidad " + dificultadPalabra);
        }

    }
}
