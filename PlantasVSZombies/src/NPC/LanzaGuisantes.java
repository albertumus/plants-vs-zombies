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
    private int posFila;
    
    public LanzaGuisantes(int posFila) {
        super(2, 50, 1, 1);
        this.alcance = 1;
        this.posFila = posFila;
    }
    
    public void accion(Zombie z) {
        z.setVida(-2);
    }
   

    public int getPosFila() {
        return posFila;
    }

    public void setPosFila(int posFila) {
        this.posFila = posFila;
    }

    public int getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }
    
}
