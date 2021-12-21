package ej02.entidades;

import java.util.ArrayList;
import java.util.List;

public class Juego {
 
    private Revolver r;
    private List<Jugador> jugadores;

    public Juego() {
    }

    public Juego(Revolver r, List<Jugador> jugadores) {
        this.r = r;
        this.jugadores = jugadores;
    }

    public Revolver getR() {
        return r;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setR(Revolver r) {
        this.r = r;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    
    // METODOS
    
    public void llenarJuego(ArrayList<Jugador>js2,Revolver r2){
        jugadores=js2;
        r=r2;
    }
    
    public boolean ronda(int i){
        boolean juegoSigue = true;
        jugadores.get(i).disparo(r);
        if (jugadores.get(i).isMojado()) {
            juegoSigue=false;
        }
        return juegoSigue;
    }
    
    
    @Override
    public String toString() {
        return "Juego{" + "r=" + r + ", j=" + jugadores + '}';
    }
    
    
    
}
