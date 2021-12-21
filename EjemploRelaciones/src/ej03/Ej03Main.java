package ej03;

import ej03.servicios.BarajaServicio;

public class Ej03Main {

    public static void main(String[] args) {
        BarajaServicio bs = new BarajaServicio();
        
        bs.crearBaraja();
        bs.menu();
        
    }
    
}
