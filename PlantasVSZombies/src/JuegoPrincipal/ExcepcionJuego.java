/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoPrincipal;

/**
 *
 * @author admin
 */
public class ExcepcionJuego extends Exception {
    public ExcepcionJuego() {
        super("No has introducido los comandos para una nueva partida correctamente");
    }
    
    public ExcepcionJuego(String s) {
        super(s);
    }
}
