package ejC02;

import ejC02.entidades.Cine;
import ejC02.entidades.Espectador;
import ejC02.servicios.CineServicio;
import java.util.ArrayList;

public class EjC02Main {

    public static void main(String[] args) {
        
        CineServicio cs = new CineServicio();
        
        Cine c = cs.abrirCine();
        ArrayList<Espectador> e = cs.crearPosiblesEspectadores();
        cs.recibirPosiblesEspectadores(c, e);
        cs.verSala(c);
        cs.revisarEspectadores(c);
    }
    
}
