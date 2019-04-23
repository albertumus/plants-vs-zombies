/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoPrincipal;
import NPC.*;

/**
 *
 * @author C732S
 */
public class Casilla {
    
    private boolean ocupado;
    private NPC npc;
    
    public Casilla() {
        this.ocupado = false;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public NPC getNpc() {
        return npc;
    }

    public void setNpc(NPC npc) {
        this.npc = npc;
    }
    
    @Override
    public String toString() {
        String casillaString = "    |";
        
        if (this.ocupado) {
            if (this.npc instanceof Zombie) {
                casillaString = String.format("Z(%d)|", this.npc.getVida());
            } else if (this.npc instanceof LanzaGuisantes) {
                casillaString = String.format("L(%d)|", this.npc.getVida());
            } else if (this.npc instanceof Girasol) {
                casillaString = String.format("G(%d)|", this.npc.getVida());
            } else {
                casillaString = "O()|";
            }
        }
            
        return casillaString;
    }
    
}
