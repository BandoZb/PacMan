package pacman;

import pacman.Pacman;
import pacman.Fantasmas;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Tablero {

    private int posicionX;
    private int posicionY;
    private String[][] tablero;

    

    private String objetivo = "O";
    private int tiempo = 90;
    private int puntuacion = 0;
    private Pacman pacman = new Pacman();
    private final Semaphore semaforoTablero = new Semaphore(1);

    private String direccionPacman = "ARRIBA";

    public Tablero(int posicionY, int posicionX, Pacman pacman) {
        this.posicionY = posicionY;
        this.posicionX = posicionX;
        this.pacman = pacman;
        this.tablero = new String[posicionY][posicionX];
    }

    public Pacman getPacman() {
        return pacman;
    }

    public void setPacman(Pacman pacman) {
        this.pacman = pacman;
    }
    

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public String getObjetivos() {
        return objetivo;
    }

    public void setObjetivos(String objetivos) {
        this.objetivo = objetivo;
    }

    public String[][] getTablero() {
        return tablero;
    }

    public void setTablero(String[][] tablero) {
        this.tablero = tablero;
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

        // Objetivos
        tablero[2][1] = objetivo;
        tablero[2][15] = objetivo;
        tablero[13][2] = objetivo;
        tablero[13][15] = objetivo;

        // Creacion Fantasmas
        // fantasmasRandoms();

        // Creacion PacMan
        tablero[13][9] = pacman.getNombre();
        pacman.setPosX(13);
        pacman.setPosY(9);

    }

    public void mostrarTablero() {
        for (int i = 0; i < posicionY; i++) {
            for (int j = 0; j < posicionX; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }


    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public boolean juegoTerminado() {
        return ((pacman.getObjetivosConsumidos() == 4) || (tiempo == 0) || (pacman.getVidasRestantes() == 0) || (puntuacion == 180));
    }

    public void mostrarEstadisticas() {
        System.out.println("");
        System.out.println("Puntuacion : " + puntuacion);
        System.out.println("Tiempo : " + tiempo);
        System.out.println("Vidas : " + pacman.getVidasRestantes());
    }

    public void setDireccionPacman(String direccionPacman) {
        this.direccionPacman = direccionPacman;
    }

    public boolean esMovimientoValido(int y, int x, String personaje) {
        boolean esValido = false;
        if ((x >= 0) && (x < tablero[0].length) && (y >= 0) && (x < tablero[0].length) && (y < tablero.length)) {

            if ((personaje.equals("pacman") && tablero[y][x].equals("F"))) {
                pacmanAtrapado();
            } else if (((tablero[y][x].equals(".") || tablero[y][x].equals(" ") || tablero[y][x].equals("O")))) {
                esValido = true;
            }
        }
        return esValido;

    }

    private void pacmanAtrapado() {
        System.out.println("Pacman fue atrapado");
        if (pacman.getVidasRestantes() == 0) {

        } else {
            System.out.println("");
            System.out.println("Reset del mapa");
        }
    }

    public void moverPacman() {
        int posX = pacman.getPosX();
        int posY = pacman.getPosY();
        int posXnew = posX;
        int posYnew = posY;

        switch (direccionPacman) {
            case "ARRIBA":
                posX--;
            case "DERECHA":
                posY++;
            case "ABAJO":
                posX++;
            case "IZQUIERDA":
                posY--;

        }

        if (esMovimientoValido(posXnew, posYnew, pacman.getNombre())) {
            if (tablero[posXnew][posYnew].equals(objetivo)) {
                int objetivosConsumidos = pacman.getObjetivosConsumidos();
                objetivosConsumidos++;
                pacman.setObjetivosConsumidos(objetivosConsumidos);

            } else if (tablero[posXnew][posYnew].equals(".")) {
                puntuacion++;
            } else if (tablero[posXnew][posYnew] == tablero[posicionY / 2 - 1][0]) {
                pacman.setPosX(6);
                pacman.setPosY(18);

            } else if (tablero[posXnew][posYnew] == tablero[posicionY / 2 - 1][posicionX - 1]) {
                pacman.setPosX(6);
                pacman.setPosY(0);

            }

        }

    }
    
    
}
