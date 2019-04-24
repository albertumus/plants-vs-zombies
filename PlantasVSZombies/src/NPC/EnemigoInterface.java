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
public interface EnemigoInterface {
    
    public void mover();
    /**
    *Se ataca a una planta
    *@param None
    *@return None
    * */
    public void atacar(NPC p);
}