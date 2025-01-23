package pacman;

import pacman.Tablero;

public class Main {

    public static void main(String[] args) {

        crearTablero();

        
    }
 
    public static void crearTablero() {

        Tablero posicones = new Tablero(15, 19);

        String tablero[][] = new String[posicones.getPosicionX()][posicones.getPosicionY()];

        for (int i = 0; i < posicones.getPosicionX(); i++) {
            for (int j = 0; j < posicones.getPosicionY(); j++) {
                tablero[i][j] = " ";
            }
        }

        for (int i = 0; i < posicones.getPosicionX(); i++) {
            tablero[i][0] = "|";
        }

        for (int j = 0; j < posicones.getPosicionY(); j++) {
            tablero[0][j] = "_ ";
        }

        for (int i = 0; i < posicones.getPosicionX(); i++) {
            for (int j = 0; j < posicones.getPosicionY(); j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println();
        }
    }

}
