package ej03.servicios;

import ej03.entidades.Baraja;
import ej03.entidades.Carta;
import ej03.enums.Palo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BarajaServicio {

    private Baraja mazoInicial = new Baraja();
    private Baraja cartasEntregadas = new Baraja();
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private Collections c;

    public Baraja crearBaraja() {
        System.out.println("Se procede a abrir una baraja");

        ArrayList<Carta> cs = new ArrayList();
        ArrayList<Carta> out = new ArrayList();
        cartasEntregadas.setCartas(out);

        for (Palo aux : Palo.values()) {
            String p = aux.getNombre();
            for (int i = 0; i < 12; i++) {
                if (i + 1 == 8 || i + 1 == 9) {
                    //NADA
                } else {
                    Carta c = new Carta(i + 1, aux);
                    cs.add(c);
                }
            }
        }
        mazoInicial.setCartas(cs);
        System.out.println("Baraja iniciada");

        return mazoInicial;
    }

    public void barajar() {
        c.shuffle(mazoInicial.getCartas());
    }

    public Carta siguienteCarta() {
        Carta c = mazoInicial.getCartas().get(0);
        System.out.println("La siguiente carta es el " + mazoInicial.getCartas().get(0).toString());
        return c;
    }

    public void cartasDisponibles() {
        System.out.println("Cartas disponibles: " + mazoInicial.getCartas().size());
    }

    public void darCartas() {
        System.out.println("Seleccione la cantidad de cartas a recibir: ");
        int cant = leer.nextInt();

        if (cant <= mazoInicial.getCartas().size()) {
            for (int i = 0; i < cant; i++) {
                System.out.println("se entrega el " + mazoInicial.getCartas().get(i).toString() + " al jugador");
            }
            for (int i = 0; i < cant; i++) {
                cartasEntregadas.getCartas().add(mazoInicial.getCartas().get(0));
                mazoInicial.getCartas().remove(0);
            }
        } else {
            System.out.println("Cartas insuficientes. No se entregó ninguna carta al jugador");
            cartasDisponibles();
        }
    }

    public void cartasMonton() {
        if (cartasEntregadas.getCartas().size() == 0) {
            System.out.println("Aún no se han retirado cartas del mazo");
        } else {
            System.out.println("Cartas retiradas (del montón): ");
            String parrafo = "";
            int ctrol = 0;
            for (Object aux : cartasEntregadas.getCartas()) {
                parrafo = parrafo.concat(aux.toString());
                parrafo = parrafo.concat(". ");
                ctrol++;
                if (ctrol == 10) {
                    System.out.println(parrafo);
                    parrafo = "";
                    ctrol = 0;
                }
            }
        }
    }

    public void mostrarBaraja() {
        if (mazoInicial.getCartas().size() == 0) {
            System.out.println("No quedan cartas en el mazo");
        } else {
            System.out.println("Cartas del mazo: ");
            String parrafo = "";
            int ctrol = 0;
            for (Object aux : mazoInicial.getCartas()) {
                parrafo = parrafo.concat(aux.toString());
                parrafo = parrafo.concat(". ");
                ctrol++;
                if (ctrol == 10) {
                    System.out.println(parrafo);
                    parrafo = "";
                    ctrol = 0;
                }
            }
        }
    }

    public void menu() {
        System.out.println("");
        System.out.println("----- MENU -----");
        System.out.println("Seleccione una opción: ");
        System.out.println("1. Barajar el mazo");
        System.out.println("2. Ver siguiente carta");
        System.out.println("3. Pedir cartas");
        System.out.println("4. Ver cartas ya usadas");
        System.out.println("5. Ver cartas aún en el mazo");
        System.out.println("6. Salir del programa");
        System.out.println("");
        String opc = leer.next();
        switch (opc) {
            case "1":
                barajar();
                System.out.println("Mazo barajado");
                menu();
                break;
            case "2":
                siguienteCarta();
                menu();
                break;
            case "3":
                darCartas();
                menu();
                break;
            case "4":
                cartasMonton();
                menu();
                break;
            case "5":
                mostrarBaraja();
                menu();
                break;
            case "6":
                System.out.println("Ejecución finalizada");
                break;
            default:
                System.out.println("Opcion no válida");
                ;
                menu();
        }

    }
}
