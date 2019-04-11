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
public class Planta extends NPC {
    
    private int coste;
    private int frecuencia;
    private int danio;
    
    public Planta(int vida, int coste, int frecuencia, int danio) {
        super(vida);
        this.coste = coste;
        this.frecuencia = frecuencia;
        this.danio = danio;
    }

    public int getCoste() {
        return coste;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public int getDanio() {
        return danio;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }
    
    
    
}
