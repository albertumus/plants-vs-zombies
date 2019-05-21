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
public class Carabuco extends Enemigo implements EnemigoInterface {
    
    boolean moverC;
    int posCol; 
    int posFil;
    
    public Carabuco(boolean moverC, int posCol, int posFil) {
        super(7,1,4);
        this.moverC = moverC;
        this.posFil = posFil;
        this.posCol = posCol;
    }   

    public int getPosFil() {
        return posFil;
    }

    public void setPosFil(int posFil) {
        this.posFil = posFil;
    }

    public int getPosCol() {
        return posCol;
    }

    public void setPosCol(int posCol) {
        this.posCol = posCol;
    }

    public boolean isMoverC() {
        return moverC;
    }

    public void setMoverC(boolean moverC) {
        this.moverC = moverC;
    }
    
    public void mover() {
        
    }
    public void atacar(NPC p) {
        p.setVida(-1);
    }
    
    public void aparecer() {
        
    }
   
}
