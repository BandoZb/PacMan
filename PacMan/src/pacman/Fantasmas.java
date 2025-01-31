package pacman;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

public class Fantasmas extends Thread {
    private String nombre = "F";
    private int posX;
    private int posY;
    private Tablero tablero;
    private Random random; 

    
    public Fantasmas(Tablero tablero) {
        this.tablero = tablero;
        this.random = new Random(); 
        fantasmasRandoms();
    }

    
    public Fantasmas(Tablero tablero, int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.tablero = tablero;
        this.random = new Random(); 
        tablero.getTablero()[posX][posY] = getNombre();
    }

    @Override
    public void run() {
        while (!tablero.juegoTerminado()) {
            moverFantasma(posX, posY);
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Fantasmas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void moverFantasma(int posX, int posY) {
        int movimiento = random.nextInt(4) + 1; // Generar un número entre 1 y 4 para elegir a donde se movera el fantasma
        
        int posXnew = posX;
        int posYnew = posY;

        switch (movimiento) {
            case 1: // Movimiento hacia arriba
                posXnew--;
                break;
            case 2: // Movimiento hacia la derecha
                posYnew++;
                break;
            case 3: // Movimiento hacia abajo
                posXnew++;
                break;
            case 4: // Movimiento hacia la izquierda
                posYnew--;
                break;
        }
             
        
        // Validar el nuevo movimiento antes de actualizar las coordenadas
        if (tablero.esMovimientoValido(posXnew, posYnew, nombre)) {
                
            
            if(tablero.getTablero()[posXnew][posYnew].equals(" ")){
                tablero.getTablero()[posXnew][posYnew] = getNombre();
                tablero.getTablero()[posX][posY] = " ";
            }
            else{
                tablero.getTablero()[posXnew][posYnew] = getNombre();
                tablero.getTablero()[posX][posY] = ".";
            }
            
            setPosX(posXnew);
            setPosY(posYnew);
           
            
        }
    }

    public void fantasmasRandoms() {
        String[][] matriz = tablero.getTablero();
        boolean posicionEncontrada = false;

        while (!posicionEncontrada) {
            int posXrandom = random.nextInt(14) + 1;
            int posYrandom = random.nextInt(18) + 1;

            if (!matriz[posXrandom][posYrandom].equals("F") &&
                !matriz[posXrandom][posYrandom].equals("|") &&
                !matriz[posXrandom][posYrandom].equals("_") &&
                !matriz[posXrandom][posYrandom].equals(tablero.getObjetivos()) &&
                !matriz[posXrandom][posYrandom].equals("P")) {
                
                matriz[posXrandom][posYrandom] = getNombre();
                setPosX(posXrandom);
                setPosY(posYrandom);
                posicionEncontrada = true;
            }
        }
    }
}
