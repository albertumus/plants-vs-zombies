/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoPrincipal;
import java.util.*;
import NPC.*;

/**
 *
 * @author admin
 */
public class testGame {
    
    public static Scanner userInput = new Scanner(System.in);
    
    public static void main (String[] args) {
        
        
        boolean play = true;
        Tablero tableroJuego = new Tablero(0,0,"facil");
        boolean crearNuevoTablero = false;
        while(!crearNuevoTablero) {
            try {
            System.out.print("Teclea el tamaño de filas deseado: ");
            String filsOriginal = userInput.next().toLowerCase();
            System.out.print("Teclea el tamaño de columnas deseado: ");
            String colsOriginal = userInput.next().toLowerCase();
            String dificultad = "";
                while(dificultad.matches("")) {
                    System.out.print("Teclea la dificultad: ");
                    String[] dificultadOriginal = userInput.next().toLowerCase().split("");
                    try {
                        if (dificultadOriginal[0].matches("f") || dificultadOriginal[0].matches("m") || dificultadOriginal[0].matches("a") || dificultadOriginal[0].matches("i")) {
                            switch(dificultadOriginal[0]) {
                                case "f": 
                                    dificultad = "facil";
                                    break;
                                case "m":
                                    dificultad = "media";
                                     break;
                                case "a":
                                    dificultad = "alta";
                                    break;
                                case "i":
                                    dificultad = "imposible";
                                    break;
                                }
                        } else {
                            throw new ExcepcionJuego("La dificultad introducida no existe");
                            }
                    } catch (ExcepcionJuego e) {
                                System.out.println(e);
                    }
                }
            tableroJuego = new Tablero(Integer.parseInt(filsOriginal),Integer.parseInt(colsOriginal),dificultad);
            crearNuevoTablero = true;
            } catch(Exception e) {
                System.out.println(e);
            }
        }


        while (play) {
            
            boolean saleZombieC = tableroJuego.saleZombie(tableroJuego.getTurnoZombies(), tableroJuego.getTurno());
            int numeroZombiesSalen = tableroJuego.zombiesaInstanciar();
            for(int j=0;j<numeroZombiesSalen;j++) {
                if(saleZombieC) {
                    tableroJuego.instanciarZombie();
                }   
            }
            
            tableroJuego.pintarTablero();
            boolean turno = true;
            while (turno) {
                System.out.print("Teclea el comando deseado: ");
                String entradaUsuario = userInput.next().toLowerCase();

                String[] entradaUsuarioValores = entradaUsuario.split("");
                String comando = entradaUsuarioValores[0];
                try {
                    switch(comando) {
                    case "n":
                        try {
                            if (entradaUsuarioValores[3].matches("f") || entradaUsuarioValores[3].matches("m") || entradaUsuarioValores[3].matches("a") || entradaUsuarioValores[3].matches("i")) {
                                String dificultad = "";
                                switch(entradaUsuarioValores[3]) {
                                    case "f": 
                                        dificultad = "facil";
                                        break;
                                    case "m":
                                        dificultad = "media";
                                        break;
                                    case "a":
                                        dificultad = "alta";
                                        break;
                                    case "i":
                                        dificultad = "imposible";
                                        break;
                                }

                                tableroJuego = new Tablero(Integer.parseInt(entradaUsuarioValores[1]),Integer.parseInt(entradaUsuarioValores[2]),dificultad);
                                turno = false;
                            } else {
                                throw new ExcepcionJuego("La dificultad introducida no existe");
                            }
                        } catch (ExcepcionJuego e) {
                            System.out.println(e);
                        }
                        break;
                    case "l":
                        tableroJuego.colocarLanzaGuisantes(Integer.parseInt(entradaUsuarioValores[1]), Integer.parseInt(entradaUsuarioValores[2]));
                        break;
                    case "g":
                        tableroJuego.colocarGirasol(Integer.parseInt(entradaUsuarioValores[1]),  Integer.parseInt(entradaUsuarioValores[2]));
                        break;
                    case "a":
                        System.out.println(tableroJuego.mostrarComandos());
                        break;
                    case "e": 
                        System.out.println("Turno terminado");
                        tableroJuego.setTurno(1);
                        turno = false;
                        break;
                    case "s":
                        play = false;
                        turno = false;
                        break;
                    default:
                        System.out.println("El comando no existe o está mal escrito");
                        break;
                    }
               } catch (ArrayIndexOutOfBoundsException e) {
                   System.out.println(e);
               }
            }
            // Acciones Repetitivas
            tableroJuego.setSoles(tableroJuego.getnGirasoles()*10);
            tableroJuego.dispararLanzaGuisantes();
            tableroJuego.moverZombies();
            tableroJuego.setPuedeColocarLanzaGuisantes(true);
            tableroJuego.setPuedeColocarGirasol(true);
            
            // Revisa Acciones de Victoria
            if(tableroJuego.getnZombies() == tableroJuego.getZombiesMatados()){
                    tableroJuego.pintarTablero();
                    play = false;
                    System.out.println("¡¡HAN GANADO LAS PLANTAS!!"); 
                }
            if(tableroJuego.getlZombie().size() == 0 && tableroJuego.getTurno() > 30){
                    tableroJuego.pintarTablero();
                    play = false;
                    System.out.println("¡¡HAN GANADO LAS PLANTAS!!"); 
                }
            for (Zombie z : tableroJuego.getlZombie()) {
                if (z.getPosCol() == 0) {
                    tableroJuego.pintarTablero();
                    play = false;
                    System.out.println("¡¡HAN GANADO LOS ZOMBIES!!");
                } 
            } 
        }
        
    }
    
}
