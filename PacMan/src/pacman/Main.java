package pacman;

import pacman.Tablero;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("""
                           Bienvenido al clasico juego del Pacman
                           
                           Elige la dificultad pulsando un número
                           
                           1.Facil      2.Medio      3.Dificil
                           
                           """);
        
        int dificultad = sc.nextInt();
        
        String[][]tablero = crearTablero();
        mostrarTablero(tablero);
        
    }
 
public static String[][] crearTablero() {
    Tablero posiciones = new Tablero(15, 19);

    String tablero[][] = new String[posiciones.getPosicionX()][posiciones.getPosicionY()];

    
    for (int i = 0; i < posiciones.getPosicionX(); i++) {
        for (int j = 0; j < posiciones.getPosicionY(); j++) {
            tablero[i][j] = ".";
        }
    }


    for (int i = 0; i < posiciones.getPosicionX(); i++) {
        tablero[i][0] = "#"; 
        tablero[i][posiciones.getPosicionY() - 1] = "#"; 
    }

    for (int j = 0; j < posiciones.getPosicionY(); j++) {
        tablero[0][j] = "#"; 
        tablero[posiciones.getPosicionX() - 1][j] = "#"; 
    }

    
    for (int j = 4; j <= 14; j++) {
        tablero[2][j] = "#"; 
    }

    for (int i = 4; i <= 10; i++) {
        tablero[i][4] = "#"; 
        tablero[i][14] = "#"; 
    }

    for (int j = 6; j <= 12; j++) {
        tablero[7][j] = "#"; 
    }

    for (int i = 2; i <= 6; i++) {
        tablero[i][9] = "#"; 
    }

    return tablero; 
}

public static void mostrarTablero(String[][] tablero) {
    
    for (int i = 0; i < tablero.length; i++) {
        for (int j = 0; j < tablero[i].length; j++) {
            System.out.print(tablero[i][j]);
        }
        System.out.println();
    }
}






}
