/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoPrincipal;
import NPC.*;
import java.util.*;
import java.io.*;
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
    private ArrayList<LanzaGuisantes> lLanzaGuisantes;
    private ArrayList<Zombie> lZombie;
    private int nGirasoles;
    private int nZombies;
    private int ZombiesInstanciados = 0;
    private int ZombiesMatados = 0;
    private int[] turnoZombies;
    private int turnoInificialZombies;
    
    // Condiciones para la colocacion
    private boolean puedeColocarGirasol;
    private boolean puedeColocarLanzaGuisantes;
    private boolean puedeColocarNuez;
    
    public Tablero(String dificultad) {
        this.cols = 7;
        this.fils = 7;
        this.dificultad = dificultad;
        this.soles = 50;
        this.puedeColocarGirasol = true;
        this.puedeColocarLanzaGuisantes = true;
        this.puedeColocarNuez = true;
        this.nZombies = this.setZombiesDificultad();
        this.lZombie = new ArrayList<Zombie>();
        this.lLanzaGuisantes = new ArrayList<LanzaGuisantes>();
        this.turno = 0;
        this.nGirasoles = 0;
        this.turnoInificialZombies = this.turnoInicialZombies();
        this.repartoZombies(); 
        this.casillasTablero = new Casilla[this.fils][this.cols];
         for(int i = 0; i<this.fils; i++) {
            for(int j = 0; j<this.cols; j++) {
                this.casillasTablero[i][j] = new Casilla();
            }
        }
         
    }
    public int turnoInicialZombies() {
        int turnoInicial = 0;
        switch(this.dificultad) {
            case "facil":
                turnoInicial = 10;
                break;
            case "media":
                turnoInicial = 7;
                break;
                
            case "alta":
                turnoInicial = 5;
                break;
                
            case "imposible":
                turnoInicial = 5;
                break;
        } 
        return turnoInicial;
    }
    
    public int setZombiesDificultad() {
        int numeroZombies = 0;
        switch(dificultad) {
            case "facil":
                numeroZombies = 5;
                break;
            case "media":
                numeroZombies = 15;
                break;
                
            case "dificil":
                numeroZombies = 25;
                break;
                
            case "imposible":
                numeroZombies = 50;
                break;
        } 
        return numeroZombies;
    }
    
    public int getZombiesMatados() {

        return ZombiesMatados;
    }

    public int getTurnoInificialZombies() {
        return turnoInificialZombies;
    }

    public void setTurnoInificialZombies(int turnoInificialZombies) {
        this.turnoInificialZombies = turnoInificialZombies;
    }

    public void setZombiesMatados(int ZombiesMatados) {
        this.ZombiesMatados += ZombiesMatados;
    }

    public ArrayList<Zombie> getlZombie() {
        return lZombie;
    }

    public void setlZombie(ArrayList<Zombie> lZombie) {
        this.lZombie = lZombie;
    }

    public int getZombiesInstanciados() {
        return ZombiesInstanciados;
    }

    public void setZombiesInstanciados(int ZombiesInstanciados) {
        this.ZombiesInstanciados = ZombiesInstanciados;
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

    public ArrayList<LanzaGuisantes> getlLanzaGuisantes() {
        return lLanzaGuisantes;
    }

    public void setlLanzaGuisantes(ArrayList<LanzaGuisantes> lLanzaGuisantes) {
        this.lLanzaGuisantes = lLanzaGuisantes;
    }

    public boolean isPuedeColocarNuez() {
        return puedeColocarNuez;
    }

    public void setPuedeColocarNuez(boolean puedeColocarNuez) {
        this.puedeColocarNuez = puedeColocarNuez;
    }


    public int getnZombies() {
        return nZombies;
    }

    public void setnZombies(int nZombies) {
        this.nZombies = nZombies;
    }

    public int[] getTurnoZombies() {
        return turnoZombies;
    }

    public void setTurnoZombies(int[] turnoZombies) {
        this.turnoZombies = turnoZombies;
    }
    /**
    *Muestra los comandos del juego
    *@param None
    *@return None
    * */
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
    
    public void colocarNuez(int fil, int col) {
        try {
            if (this.soles >= 50 && this.puedeColocarNuez && col != this.cols-1) {
                if (!this.casillasTablero[fil][col].isOcupado()) {
                   Nuez n = new Nuez();
                   this.casillasTablero[fil][col].setOcupado(true);
                   this.casillasTablero[fil][col].setNpc(n);
                   this.soles -= 50;
                   this.puedeColocarNuez = false;
                   this.pintarTablero();
                } else {
                    throw new PlantaExpception("No puedes colocar una Nuez");
                }
            } else {
              throw new PlantaExpception("No puedes colocar una Nuez");
            }  
        } catch (PlantaExpception e) {
           System.out.println(e);
        }
    }
    
    /**
    *Coloca un gorasol en una posicion determinada siempre que se pueda
    *@param int => Posicion dentro de los limites del tablero
    *@param int => Posicion dentro de los limites del tablero
    *@return None
    * */
    public void colocarGirasol(int fil, int col) {
        try {
            if (this.soles >= 20 && this.puedeColocarGirasol && col != this.cols-1) {
                if (!this.casillasTablero[fil][col].isOcupado()) {
                   Girasol g = new Girasol();
                   this.casillasTablero[fil][col].setOcupado(true);
                   this.casillasTablero[fil][col].setNpc(g);
                   this.soles -= 20;
                   this.nGirasoles += 1;
                   this.puedeColocarGirasol = false;
                   repartoZombies();
                   this.pintarTablero();
                } else {
                    throw new PlantaExpception("No puedes colocar un Girasol");
                }
            } else {
              throw new PlantaExpception("No puedes colocar un Girasol");
            }  
        } catch (PlantaExpception e) {
           System.out.println(e);
        }
    }
        /**
    *Coloca un lanzaguisantes en una posicion determinada siempre que se pueda
    *@param int => Posicion dentro de los limites del tablero
    *@param int => Posicion dentro de los limites del tablero
    *@return None
    * */
    public void colocarLanzaGuisantes(int fil, int col) {
        try {
        if (this.soles >= 50 && this.puedeColocarLanzaGuisantes && col != this.cols-1) {
             if (!this.casillasTablero[fil][col].isOcupado()) {
               LanzaGuisantes l = new LanzaGuisantes(fil);
               this.casillasTablero[fil][col].setOcupado(true);
               this.casillasTablero[fil][col].setNpc(l);
               this.soles -= 50;
               this.lLanzaGuisantes.add(l);
               this.puedeColocarLanzaGuisantes = false;
               this.pintarTablero();
            } else {
                throw new PlantaExpception("No puedes colocar un LanzaGuisantes");
            }
        } else {
            throw new PlantaExpception("No puedes colocar un LanzaGuisantes");
        }
        } catch (PlantaExpception e) {
            System.out.println(e);
        }
    }
    /**
    *Recorre la lista de los guisantes y uno a uno dispara un guisantes
    *a los largo de la fila, impactando contra el primer zombie que encuentre
    *@param None
    *@return None
    * */
    public void dispararLanzaGuisantes() {
        for(LanzaGuisantes l : this.lLanzaGuisantes) {
            int fila = l.getPosFila();
            boolean enc = false;
            int maxPos = this.cols-1;
            int posCol = 0;
            while(!enc && posCol < maxPos) {
                if (this.casillasTablero[fila][posCol].isOcupado() & this.casillasTablero[fila][posCol].getNpc() instanceof Zombie) {
                    if (this.casillasTablero[fila][posCol].getNpc().getVida() > 0) {
                        this.casillasTablero[fila][posCol].getNpc().setVida(-1);
                    } else {
                        this.lZombie.remove(this.casillasTablero[fila][posCol].getNpc());
                        this.ZombiesMatados += 1;
                        System.out.println("Has madado un zombie");
                        System.out.println(this.ZombiesMatados);
                        this.casillasTablero[fila][posCol].setOcupado(false); 
                        this.casillasTablero[fila][posCol].setNpc(null);                
                    }
                    
                    enc = true;
                }
                posCol++;
            }
        }
    }
    /**
    *Crea una instancia de un zombie en una fila random
    *@param None
    *@return None
    * */
    public void instanciarZombie() {
        int posFil = (int)(Math.random()*(this.fils));
        int i = 0;
        
        while (i < this.fils) {
            
            if (!this.casillasTablero[posFil][this.cols-1].isOcupado()) {
                boolean moverC = false;
                
                if(this.turno % 2 == 0) {
                    moverC = true;
                } 
                
                Zombie z = new Zombie(moverC, this.cols-1, posFil);
                
                this.casillasTablero[posFil][this.cols-1].setOcupado(true);
                this.casillasTablero[posFil][this.cols-1].setNpc(z);
                this.ZombiesInstanciados += 1;
                this.lZombie.add(z);
                i = this.fils+99;
            }
            i++;        
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
    /**
    *Se reparten aleatoriamente los turnos en los que salen zombies
    *@param None
    *@return None
    * */
    public void repartoZombies() {
        this.turnoZombies = new int[this.nZombies];
        for (int i=0;i<this.nZombies;i++) {
           int random = (int)(Math.random()*(30-this.turnoInificialZombies)+this.turnoInificialZombies);
           this.turnoZombies[i] = random;
        }
    }
    /**
    *Seale un zombie a jugar al tablero de juego, nunca son titulares, como Bale
    *@param int[] turnosZombies => turnos en los que salen los zombies
    * @param int turno => turno actual
    *@return None
    * */
    public boolean saleZombie(int[] turnosZombies, int turno) {
        boolean saleZombieC = false;
        for (int i : turnosZombies) {
            if (i == turno) {
                saleZombieC = true;
            }
        }
        return saleZombieC;
    }
    
    public int zombiesaInstanciar() {
        int numeroZombies = 0;
        for (int i : this.turnoZombies) {
            if(this.turno == i ) {
                numeroZombies +=1;
            }
        }
        
        return numeroZombies;
    }
    
    /**
    *Se mueve el zombie o ataca
    *@param None
    *@return None
    * */
    public void moverZombies() {
        if (this.lZombie.size()>=1) {
            for (Zombie z : this.lZombie) {
                int posZFil = z.getPosFil();
                int posZCol = z.getPosCol();
                if(z.isMoverC() == (this.turno % 2 == 0)) {
                    if (!this.casillasTablero[posZFil][posZCol-1].isOcupado()) {
                        this.casillasTablero[posZFil][posZCol-1].setOcupado(true);
                        this.casillasTablero[posZFil][posZCol-1].setNpc(z);
                        this.casillasTablero[posZFil][posZCol].setOcupado(false);
                        z.setPosCol(posZCol-1);
                    } else if (this.casillasTablero[posZFil][posZCol-1].getNpc() instanceof Planta) {
                        z.atacar(this.casillasTablero[posZFil][posZCol-1].getNpc());
                    }
                } else if (this.casillasTablero[posZFil][posZCol-1].isOcupado() & this.casillasTablero[posZFil][posZCol-1].getNpc() instanceof Planta) {
                    z.atacar(this.casillasTablero[posZFil][posZCol-1].getNpc());
                    if(this.casillasTablero[posZFil][posZCol-1].getNpc().getVida() <=0) {
                        if(this.casillasTablero[posZFil][posZCol-1].getNpc() instanceof LanzaGuisantes) {
                            this.lLanzaGuisantes.remove(this.casillasTablero[posZFil][posZCol-1].getNpc());
                        }
                        this.casillasTablero[posZFil][posZCol-1].setOcupado(false);
                    }
                }
            } 
        }

    }
    /**
    *Se pinta el tablero
    *@param None
    *@return None
    * */
    public String pintarTablero() {
        
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter, true);
        
        for(int i = 0; i<this.fils; i++) {
            writer.println("|--------------------------|");
            writer.print("| ");
            for(int j = 0; j<this.cols; j++) {
                writer.print(this.casillasTablero[i][j].toString());
            }
            writer.println("");
        }
        writer.println("|--------------------------|");
        
        return stringWriter.toString();
    }
}
   