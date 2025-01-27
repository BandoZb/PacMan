package pacman;

import pacman.Pacman;
import pacman.Fantasmas;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Tablero {

    private int posicionX;
    private int posicionY;
    private String[][] tablero;

    private Pacman pacman = new Pacman();
    private Fantasmas f1 = new Fantasmas();
    private Fantasmas f2 = new Fantasmas();
    private Fantasmas f3 = new Fantasmas();

    private String objetivo = "O";
    private int tiempo = 90;
    private int puntuacion = 0;
    
    private final Semaphore semaforoTablero = new Semaphore(1);
        
    private String direccionPacman = "ARRIBA"; 
    
    public Tablero(int posicionY, int posicionX) {
        this.posicionY = posicionY;
        this.posicionX = posicionX;
        this.tablero = new String[posicionY][posicionX];
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
        fantasmasRandoms();

        // Creacion PacMan
        tablero[13][9] = pacman.getNombre();

    }

    public void mostrarTablero() {
        for (int i = 0; i < posicionY; i++) {
            for (int j = 0; j < posicionX; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void fantasmasRandoms() {

        Random random = new Random();

        boolean interruptorRandom1 = false;
        boolean interruptorRandom2 = false;

        tablero[6][9] = f3.getNombre();

        do {

            if (!interruptorRandom1) {
                int posXrandomf1 = random.nextInt(15) + 1;
                int posYrandomf1 = random.nextInt(19) + 1;

                if (tablero[posXrandomf1][posYrandomf1].equals("|") || tablero[posXrandomf1][posYrandomf1].equals("_") || tablero[posXrandomf1][posYrandomf1].equals(objetivo) || tablero[posXrandomf1][posYrandomf1].equals(pacman.getNombre())) {
                    interruptorRandom1 = false;
                } else {
                    interruptorRandom1 = true;
                    tablero[posXrandomf1][posYrandomf1] = f1.getNombre();
                }
            }

            if (!interruptorRandom2) {
                int posXrandomf2 = random.nextInt(15) + 1;
                int posYrandomf2 = random.nextInt(19) + 1;

                if (tablero[posXrandomf2][posYrandomf2].equals("|") || tablero[posXrandomf2][posYrandomf2].equals("_") || tablero[posXrandomf2][posYrandomf2].equals(objetivo) || tablero[posXrandomf2][posYrandomf2].equals(pacman.getNombre())) {
                    interruptorRandom2 = false;
                } else {
                    interruptorRandom2 = true;
                    tablero[posXrandomf2][posYrandomf2] = f2.getNombre();
                }
            }

        } while (!interruptorRandom1 || !interruptorRandom2);
    }
    


    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    
    public boolean juegoTerminado(){
        return ((pacman.getObjetivosConsumidos() == 4) || (tiempo == 0) || (pacman.getVidasRestantes() == 0) || ( puntuacion == 180));
    } 
    
    public void mostrarEstadisticas(){
        System.out.println("");
        System.out.println("Puntuacion : "+puntuacion);
        System.out.println("Tiempo : "+tiempo);
        System.out.println("Vidas : "+pacman.getVidasRestantes());
    }
    
        public void setDireccionPacman(String direccionPacman) {
        this.direccionPacman = direccionPacman;
    }

}
