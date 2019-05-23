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
    
    int moverC;
    int posCol; 
    int posFil;
    
    public Carabuco(int posCol, int posFil) {
        super(7,1,4);
        this.moverC = 0;
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

    public int getMoverC() {
        return moverC;
    }

    public void setMoverC(int moverC) {
        this.moverC += moverC;
    }


    public void mover() {
        
    }
    public void atacar(NPC p) {
        p.setVida(-1);
    }
    
    public void aparecer() {
        
    }
   
}
