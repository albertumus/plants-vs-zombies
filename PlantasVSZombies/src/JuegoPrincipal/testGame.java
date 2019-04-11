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
        
        Tablero tableroJuego = new Tablero(4,5);
        boolean play = true;
        
        while (play) {
            tableroJuego.pintarTablero();
            System.out.print("Teclea el comando deseado: ");
            String comando = userInput.next();
            
            switch(comando) {
                case "s":
                    play = false;
            }   
        }
        
    }
    
}
