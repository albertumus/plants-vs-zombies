/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoPrincipal;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author admin
 */
public class Jugador implements Serializable {
    
    public String nombre;
    public String dni;
    public String contraseña;
    public int partidasJugadas;
    public int partidasPerdidas;
    public ArrayList<Integer> partidasGanadasFacil;
    public ArrayList<Integer> partidasGanadasMedio;
    public ArrayList<Integer> partidasGanadasDificil;
    public ArrayList<Integer> partidasGanadasImposible;
    
    public Jugador(String nombre, String dni, String contraseña) {
        this.nombre = nombre;
        this.dni = dni;
        this.contraseña = contraseña;
        this.partidasJugadas = 0;
        this.partidasPerdidas = 0;
        this.partidasGanadasFacil = new ArrayList<Integer>();
        this.partidasGanadasMedio = new ArrayList<Integer>();
        this.partidasGanadasDificil = new ArrayList<Integer>();
        this.partidasGanadasImposible = new ArrayList<Integer>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getPartidasPerdidas() {
        return partidasPerdidas;
    }

    public void setPartidasPerdidas(int partidasPerdidas) {
        this.partidasPerdidas += partidasPerdidas;
    }
    
    public void añadirPuntuacionPartidaGanada() {
        
    }
    
    
}
