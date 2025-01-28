
package pacman;


public class Fantasmas extends Thread {
   private String nombre = "F";
   private int posX;
   private int posY;
   
   @Override
   public void run() {
       
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

   
    
}
