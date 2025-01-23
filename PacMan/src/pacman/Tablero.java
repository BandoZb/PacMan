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

        
        for (int i = 0; i < posicionY; i++) {
            tablero[i][0] = "#"; 
            tablero[i][posicionX - 1] = "#"; 
        }

        for (int j = 0; j < posicionX; j++) {
            tablero[0][j] = "#"; 
            tablero[posicionY - 1][j] = "#"; 
        }

        // Hueco pared izq
        tablero[posicionY / 2 - 1][0] = " "; 
        // Hueco pared derecha
        tablero[posicionY / 2 - 1][posicionX - 1] = " "; 
        

        
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



        

    }

    // Método para mostrar el tablero
    public void mostrarTablero() {
        for (int i = 0; i < posicionY; i++) {
            for (int j = 0; j < posicionX; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println();
        }
    }
    
}