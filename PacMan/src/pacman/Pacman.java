
package pacman;


public class Pacman extends Thread{
    
   private String nombre = "P";
   private int ObjetivosConsumidos;
   private int vidasRestantes;
   
   
   @Override
   public void run() {
       
       
   }

    public String getNombre() {
        return nombre;
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
