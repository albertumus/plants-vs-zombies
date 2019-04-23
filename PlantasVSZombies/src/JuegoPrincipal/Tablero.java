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
    private Casilla[][] casillasTablero;
    private LanzaGuisantes[] lLanzaGuisantes;
    private int nGirasoles;
    private int nZombies;
    
    // Condiciones para la colocacion
    private boolean puedeColocarGirasol;
    private boolean puedeColocarLanzaGuisantes;
    
    public Tablero(int cols, int fils) {
        this.cols = cols;
        this.fils = fils;
        this.dificultad = "FACIL";
        this.soles = 50;
        this.puedeColocarGirasol = true;
        this.puedeColocarLanzaGuisantes = true;
        this.turno = 0;
        this.nGirasoles = 0;
        this.casillasTablero = new Casilla[this.fils][this.cols];
         for(int i = 0; i<this.fils; i++) {
            for(int j = 0; j<this.cols; j++) {
                this.casillasTablero[i][j] = new Casilla();
            }
        }
         
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

    public void setCols(int cols) {
        this.cols = cols;
    }

    public void setFils(int fils) {
        this.fils = fils;
    }

    public void setSoles(int soles) {
        this.soles += soles;
    }

    public void setTurno(int turno) {
        this.turno += turno;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public int getnGirasoles() {
        return nGirasoles;
    }

    public void setnGirasoles(int nGirasoles) {
        this.nGirasoles = nGirasoles;
    }
    
    public String mostrarComandos() {
        return 
"        N <filas> <columnas> <Dificultad>: Nueva partida (Dificultad: BAJA, MEDIA,\n" +
"        ALTA, IMPOSIBLE).\n" +
"        G <fila> <columna>: colocar girasol. Únicamente se podrá añadir un nuevo\n" +
"        Girasol por turno y si tiene el número suficiente de soles. No podrá añadir un\n" +
"        Girasol en una casilla ocupada por otra planta o por un zombi.\n" +
"        L <fila> <columna>: colocar LanzaGuisantes. Únicamente se podrá añadir un\n" +
"        nuevo LanzaGuisantes por turno y si tiene el número suficiente de soles. No\n" +
"        podrá añadir un LanzaGuisantes en una casilla ocupada por otra planta o por un\n" +
"        zombi.\n" +
"        S: Salir de la aplicación.\n" +
"        <Enter> (Ahora 'E'): Pasar Turno\n";
    }
    
    public void colocarGirasol(int fil, int col) {
        if (this.soles >= 20 && this.puedeColocarGirasol) {
            if (!this.casillasTablero[fil][col].isOcupado()) {
               Girasol g = new Girasol();
               this.casillasTablero[fil][col].setOcupado(true);
               this.casillasTablero[fil][col].setNpc(g);
               this.soles -= 20;
               this.nGirasoles += 1;
               this.puedeColocarGirasol = false;
               this.pintarTablero();
            } else {
                System.out.println("No puedes colocar un Lanza Guisantes");
            }
        }
    }
    
    public void colocarLanzaGuisantes(int fil, int col) {
        if (this.soles >= 50 && this.puedeColocarLanzaGuisantes) {
             if (!this.casillasTablero[fil][col].isOcupado()) {
               LanzaGuisantes l = new LanzaGuisantes();
               this.casillasTablero[fil][col].setOcupado(true);
               this.casillasTablero[fil][col].setNpc(l);
               this.soles -= 50;
               this.puedeColocarLanzaGuisantes = false;
               this.pintarTablero();
            } else {
                System.out.println("No puedes colocar un Lanza Guisantes");
            }
        }
    }

    public boolean isPuedeColocarGirasol() {
        return puedeColocarGirasol;
    }

    public void setPuedeColocarGirasol(boolean puedeColocarGirasol) {
        this.puedeColocarGirasol = puedeColocarGirasol;
    }

    public boolean isPuedeColocarLanzaGuisantes() {
        return puedeColocarLanzaGuisantes;
    }

    public void setPuedeColocarLanzaGuisantes(boolean puedeColocarLanzaGuisantes) {
        this.puedeColocarLanzaGuisantes = puedeColocarLanzaGuisantes;
    }

    public Casilla[][] getCasillasTablero() {
        return casillasTablero;
    }

    public void setCasillasTablero(Casilla[][] casillasTablero) {
        this.casillasTablero = casillasTablero;
    }
    
    public void pintarTablero() {
        
        System.out.println("(Teclear ayuda para lista de comandos. <Enter> para terminar el turno.");
        System.out.println("> N " + this.cols + " " + this.fils + " " + this.dificultad);
        
        for(int i = 0; i<this.fils; i++) {
            System.out.print("\n|");
            for(int k=1;k<(this.cols*5);k++){
            System.out.print("-");
            }
            System.out.println("|");
            System.out.print("|");
            for(int j = 0; j<this.cols; j++) {
                System.out.print(this.casillasTablero[i][j].toString());
            }
            System.out.print("<- Zombies coming...");
        }
        System.out.print("\n|");
        for(int k=1;k<(this.cols*5);k++){
            System.out.print("-");
        }
        System.out.println("|");
        System.out.println("Tienes " + this.soles + " soles y es el turno " + this.turno);
        System.out.println("(Teclear ayuda para lista de comandos. <Enter> para terminar el turno.)");
    }
}
   
