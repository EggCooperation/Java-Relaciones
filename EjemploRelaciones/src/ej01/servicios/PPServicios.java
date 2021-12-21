package ej01.servicios;

import ej01.entidades.Perro;
import ej01.entidades.Persona;
import java.util.Scanner;

public class PPServicios {

    private Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Persona crearPersona() {
        Persona a = new Persona();
        System.out.println("Ingrese el nombre de la persona");
        a.setNombre(leer.next());
        System.out.println("Ingrese apellido");
        a.setApellido(leer.next());
        // de la misma forma se ingresan los demas datos
        return a;

    }

    public Perro crearPerro() {
        Perro b = new Perro();
        System.out.println("Ingrese el nombre del perro");
        b.setNombre(leer.next());
        System.out.println("Ingrese raza");
        b.setRaza(leer.next());
        // de la misma forma se ingresan los demas datos
        return b;

    }
}

