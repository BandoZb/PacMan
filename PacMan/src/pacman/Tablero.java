package pacman;

public class Tablero {

    private int posicionX;
    private int posicionY;
    private String[][] tablero;

    public Tablero(int posicionY, int posicionX) {
        this.posicionY = posicionY;
        this.posicionX = posicionX;
        this.tablero = new String[posicionY][posicionX];
    }

    public void crearTablero() {

        for (int i = 0; i < posicionY; i++) {
            for (int j = 0; j < posicionX; j++) {
                tablero[i][j] = ".";
            }
        }
        
        // Huecos del la zona de los fantasmas
        
        for (int i = 7; i < 12; i++) {
            tablero[6][i] = " "; 
        }
        

        for (int i = 0; i < posicionY; i++) {
            tablero[i][0] = "|";
            tablero[i][posicionX - 1] = "|";
        }

        for (int j = 0; j < posicionX; j++) {
            tablero[0][j] = "_";
            tablero[posicionY - 1][j] = "_";
        }

        // Hueco pared izq
        tablero[posicionY / 2 - 1][0] = " ";
        // Hueco pared derecha
        tablero[posicionY / 2 - 1][posicionX - 1] = " ";

        for (int j = 4; j <= 14; j++) {
            tablero[2][j] = "_";
        }

        for (int i = 4; i <= 10; i++) {
            tablero[i][4] = "|";
            tablero[i][14] = "|";
        }

        for (int j = 6; j <= 12; j++) {
            tablero[7][j] = "_";
        }

        //Rellenos paredes de dentro
        tablero[3][2] = "|";
        tablero[4][2] = "|";
        tablero[5][2] = "|";
        tablero[6][6] = "|";
        tablero[5][6] = "_";
        tablero[5][7] = "_";
        tablero[5][10] = "_";
        tablero[5][11] = "_";

        tablero[5][12] = "_";
        tablero[6][12] = "|";
        tablero[12][2] = "_";
        tablero[12][3] = "_";
        tablero[12][4] = "_";
        tablero[11][6] = "_";
        tablero[11][7] = "_";
        tablero[11][8] = "_";
        tablero[10][8] = "_";

        tablero[12][10] = "|";
        tablero[13][10] = "|";
        tablero[9][9] = "|";
        tablero[10][9] = "|";

        tablero[12][13] = "|";
        tablero[11][16] = "|";
        tablero[10][16] = "|";
        tablero[3][16] = "|";
        tablero[4][16] = "|";

        tablero[2][6] = ".";
        tablero[2][7] = ".";
        tablero[2][11] = ".";
        tablero[2][12] = ".";

    }

    public void mostrarTablero() {
        for (int i = 0; i < posicionY; i++) {
            for (int j = 0; j < posicionX; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

}
