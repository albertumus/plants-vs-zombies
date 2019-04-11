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
public class Enemigo extends NPC {
    
    private int danio;
    private int velocidad;
    
    public Enemigo(int vida,int danio, int velocidad) {
        super(vida);
        this.danio = danio;
        this.velocidad = velocidad;
    }

    public int getDanio() {
        return danio;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
    

}
