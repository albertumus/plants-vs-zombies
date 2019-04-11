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
public class NPC {
    private int vida;
    private int posCol;
    private int posFil;
    
    public NPC(int vida) {
        this.vida = vida;
        this.posCol = 0;
        this.posFil = 0;
    }

    public int getVida() {
        return vida;
    }

    public int getPosCol() {
        return posCol;
    }

    public int getPosFil() {
        return posFil;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setPosCol(int posCol) {
        this.posCol = posCol;
    }

    public void setPosFil(int posFil) {
        this.posFil = posFil;
    }
    
    
}
