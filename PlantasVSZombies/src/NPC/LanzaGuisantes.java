/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NPC;

/**
 *
 * @author admin
 */
public class LanzaGuisantes extends Planta implements PlantaInterface {
    
    private int alcance;
    
    public LanzaGuisantes() {
        super(3, 50, 1, 1);
        this.alcance = 1;
    }
    
    public void accion() {
        
    }
    
    public void colocar() {
        
    }

    public int getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }
    
    
}
