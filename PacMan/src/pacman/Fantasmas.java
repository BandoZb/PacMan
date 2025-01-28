
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
        fantasmasRandoms();
    }
    
    public Fantasmas(Tablero tablero, int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.tablero = tablero;
        tablero.getTablero()[posX][posY] = getNombre();
    }
   
   
   @Override
   public void run() {
       while(!tablero.juegoTerminado()){
            moverFantasma(posX, posY);
            try {        
            sleep(500);
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
    
    public void moverFantasma(int posX, int posY){
        int movimiento = random.nextInt(3) + 1;
        
        int posXnew = posX;
        int posYnew = posY;
        switch(movimiento){
            case 1:
                posX--;
                break;
            case 2:
                posY++;
                break;
            case 3:
                posX++;
                break;
            case 4:
                posY--;
                break;
        }
        
        if(tablero.esMovimientoValido(posYnew, posXnew, nombre)){
            posX = posXnew;
            posY = posYnew;
        }
}
    
    public void fantasmasRandoms() {

        Random random = new Random();
        
        String [][]matriz = tablero.getTablero();
        boolean interruptorRandom1 = false;
        boolean interruptorRandom2 = false;

        //matriz[6][9] = f3.getNombre();

        do {

            if (!interruptorRandom1) {
                int posXrandomf1 = random.nextInt(14) + 1;
                int posYrandomf1 = random.nextInt(18) + 1;

                if (matriz[posXrandomf1][posYrandomf1].equals("F") || matriz[posXrandomf1][posYrandomf1].equals("|") || matriz[posXrandomf1][posYrandomf1].equals("_") || matriz[posXrandomf1][posYrandomf1].equals(tablero.getObjetivos()) || matriz[posXrandomf1][posYrandomf1].equals("P")) {
                    interruptorRandom1 = false;
                } else {
                    interruptorRandom1 = true;
                    matriz[posXrandomf1][posYrandomf1] = getNombre();
                    setPosX(posXrandomf1);
                    setPosY(posYrandomf1);
                }
            }


        } while (!interruptorRandom1);
    }
}