
package pacman;


public class Pacman extends Thread{
    
   private String nombre = "P";
   private int ObjetivosConsumidos;
   private int vidasRestantes;
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

    public int getVidasRestantes() {
        return vidasRestantes;
    }

    public void setVidasRestantes(int vidasRestantes) {
        this.vidasRestantes = vidasRestantes;
    }

    public int getObjetivosConsumidos() {
        return ObjetivosConsumidos;
    }

    public void setObjetivosConsumidos(int ObjetivosConsumidos) {
        this.ObjetivosConsumidos = ObjetivosConsumidos;
    }
    
 
   
    
    
}
