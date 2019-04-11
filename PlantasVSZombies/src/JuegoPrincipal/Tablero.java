/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoPrincipal;
import NPC.*;

/**
 *
 * @author admin
 */
public class Tablero {
    
    private int cols;
    private int fils;
    private int soles;
    private int turno;
    private String dificultad;
    private NPC[][] lNPC;
    
    public Tablero(int cols, int fils) {
        this.cols = cols;
        this.fils = fils;
        this.dificultad = "FACIL";
        this.soles = 50;
        this.turno = 0;
        this.lNPC = new NPC[this.fils][this.cols];
    }

    public int getCols() {
        return cols;
    }

    public int getFils() {
        return fils;
    }

    public int getSoles() {
        return soles;
    }

    public int getTurno() {
        return turno;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void getlNPC() {
        for(NPC lnpc[] : this.lNPC) {
            for(NPC npc : lnpc) {
                System.out.println(npc.getVida());
            }
        }
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public void setFils(int fils) {
        this.fils = fils;
    }

    public void setSoles(int soles) {
        this.soles = soles;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public void setlNPC(NPC[][] lNPC) {
        this.lNPC = lNPC;
    }
    
    public void pintarTablero() {
        
        System.out.println("(Teclear ayuda para lista de comandos. <Enter> para terminar el turno.");
        System.out.println("> N " + this.cols + " " + this.fils + " " + this.dificultad);
        
        for(int i = 0; i<this.fils; i++) {
            System.out.print("\n|");
            for(int k=1;k<(this.cols*4);k++){
            System.out.print("-");
            }
            System.out.println("|");
            System.out.print("|");
            for(int j = 0; j<this.cols; j++) {
                System.out.print("   |");
            }
        }
        System.out.print("\n|");
        for(int k=1;k<(this.cols*4);k++){
            System.out.print("-");
        }
        System.out.println("|");
        System.out.println("Tienes " + this.soles + " soles y es el turno " + this.turno);
        System.out.println("(Teclear ayuda ('s') para lista de comandos. <Enter> para terminar el turno.)");
    }
    
    
}
   
