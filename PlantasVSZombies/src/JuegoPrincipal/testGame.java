/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoPrincipal;
import java.util.*;

/**
 *
 * @author admin
 */
public class testGame {
    
    public static Scanner userInput = new Scanner(System.in);
    
    public static void main (String[] args) {
        
        // Se instancia un nuevo tablero con el tamaño especifico y las stats a 0
        Tablero tableroJuego = new Tablero(4,5);
        boolean play = true;
        
        // Se pinta por primera vez el tablero de juego
        
        
        while (play) {
            
            tableroJuego.pintarTablero();
            boolean turno = true;

            while (turno) {
                System.out.print("Teclea el comando deseado: ");
                String entradaUsuario = userInput.next().toLowerCase();

                String[] entradaUsuarioValores = entradaUsuario.split("");
                String comando = entradaUsuarioValores[0];
                
                switch(comando) {
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
                }
            }
            
            tableroJuego.setSoles(tableroJuego.getnGirasoles()*10);
            tableroJuego.setPuedeColocarLanzaGuisantes(true);
            tableroJuego.setPuedeColocarGirasol(true);
                        
        }
        
    }
    
}
