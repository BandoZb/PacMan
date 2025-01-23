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
        tablero.mostrarTablero();

    }



}
