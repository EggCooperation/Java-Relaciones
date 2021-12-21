package ej02;

import ej02.entidades.Juego;
import ej02.entidades.Jugador;
import ej02.entidades.Revolver;
import java.util.ArrayList;
import java.util.Scanner;

public class Ej02Main {

    private static Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) {

        ArrayList<Jugador> jugadores = new ArrayList();

        System.out.println("Se va a iniciar un juego. Seleccione la cantidad de jugadores:");
        int cantidadJugadores = leer.nextInt();
        if (cantidadJugadores<1||cantidadJugadores>6) {
            cantidadJugadores=6;
        }
        for (int i = 0; i < cantidadJugadores; i++) {
            Jugador a = new Jugador(i + 1);
            jugadores.add(a);
        }

        System.out.println("Se va a preparar el revolver para el juego");
        Revolver r = new Revolver();
        r.llenarRevolver();

        System.out.println("Revolver cargado. Se da inicio al juego");
        Juego j = new Juego();
        j.llenarJuego(jugadores, r);

        boolean juegoSigue = true;
        int turno = 0;
        while (juegoSigue) {
            if (turno == (cantidadJugadores)){
                turno = 0;
            }
            System.out.println("El " + j.getJugadores().get(turno).getNombre() + " procede a disparar");
            juegoSigue = j.ronda(turno);
            if (juegoSigue) {
                System.out.println("El " + j.getJugadores().get(turno).getNombre() + " se salva");
            } else {
                System.out.println("El " + j.getJugadores().get(turno).getNombre() + " ha sido mojado");
                System.out.println("Juego finalizado");
            }
            turno++;
        }
        System.out.println("");
    }
}
