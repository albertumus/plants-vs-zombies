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
public class PlantaExpception extends Exception {
    
    public PlantaExpception() {
        super("No puedes colocar una planta ahi");
    }
    
    public PlantaExpception(String s) {
        super(s);
    }
    
}
