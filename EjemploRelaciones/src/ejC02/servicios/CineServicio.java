package ejC02.servicios;

import ejC02.entidades.Cine;
import ejC02.entidades.Espectador;
import ejC02.entidades.Pelicula;
import ejC02.entidades.Asiento;
import ejC02.enums.Columna;
import java.util.ArrayList;
import java.util.Scanner;
//import java.util.Scanner;

public class CineServicio {

    private Scanner leer = new Scanner(System.in).useDelimiter("\n");
//    private Scanner leer = new Scanner(System.in).useDelimiter("\n");
    //SE ABRE UN CINE CON UNA PELICULA Y PRECIO PREVIAMENTE ESTABLECIDOS, Y TODOS LOS ASIENTOS VACIOS

    public Cine abrirCine() {
        Cine c = new Cine();
        c.setPelicula(new Pelicula("El Hobbit", 185, 18, "Fulano de Tal"));
        c.setPrecio(110);

        Asiento s[][] = new Asiento[8][6];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                Integer a = 8 - i;
                String b = a.toString();
                switch (j) {
                    case 0:
                        b = b.concat("A");
                        break;
                    case 1:
                        b = b.concat("B");
                        break;
                    case 2:
                        b = b.concat("C");
                        break;
                    case 3:
                        b = b.concat("D");
                        break;
                    case 4:
                        b = b.concat("E");
                        break;
                    case 5:
                        b = b.concat("F");
                        break;
                    default:
                        throw new AssertionError();
                }
                s[i][j] = new Asiento(b, null);
            }
        }
        c.setSala(s);

        ArrayList<String> a = new ArrayList();
        for (int i = 0; i < 8; i++) {
            for (Columna aux : Columna.values()) {
                String asiento = (8 - i) + aux.toString();
                a.add(asiento);
            }
        }
        c.setAsientosLibres(a);

        return c;

    }

    // MENU PARA CAMBIAR PELICULA Y PRECIO DEL CINE
    public Cine modificarCine(Cine c) {
        System.out.println("----- MENU CINE -----");
        System.out.println("en desarrollo");
        //incluir opciones de cambio de pelicula y precio de entrada
        return c;
    }

    // SE CREA UN UNIVERSO DE POSIBLES ESPECTADORES QUE INTENTARAN INGRESAR AL CINE
    public ArrayList<Espectador> crearPosiblesEspectadores() {
        ArrayList<Espectador> interesados = new ArrayList();
        int cantidad = 25 + (int) (Math.random() * 60);
        for (int i = 0; i < cantidad; i++) {
            Espectador e = new Espectador("Interesado " + (i + 1), (int) (Math.random() * 70), (int) (Math.random() * 1000));
            interesados.add(e);
        }
        System.out.println("Cantidad de posibles espectadores: " + interesados.size());
        return interesados;

    }

    // SE CONTROLAN LOS INTERESADOS Y SE COBRA Y ASIGNA UN ASIENTO DE CORRESPONDER
    public Cine recibirPosiblesEspectadores(Cine c, ArrayList<Espectador> interesados) {
        int rechazos = 0;
        int recibidos = 0;
        for (Espectador aux : interesados) {
            if (aux.getEdad() >= c.getPelicula().getEdadMinima() && aux.getDinero() >= c.getPrecio() && c.getAsientosLibres().size() > 0) {
                //resta dinero al visitante
                aux.setDinero(aux.getDinero() - c.getPrecio());
                //selecciona un lugar para ubicarlo
                int posicionLista = (int) (Math.random() * c.getAsientosLibres().size());
                String ubicacion = c.getAsientosLibres().get(posicionLista);
                c.getAsientosLibres().remove(posicionLista);

                Asiento visual[][] = c.getSala();
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 6; j++) {
                        if (visual[i][j].getUbicacion().equalsIgnoreCase(ubicacion)) {
                            visual[i][j].setE(aux);
                        }
                    }
                }
                recibidos++;
            } else {
                rechazos++;
            }
        }
        System.out.println("Espectadores recibidos: " + recibidos);
        System.out.println("Recaudación de la funcion: " + recibidos * c.getPrecio());
        System.out.println("Ingresos rechazados por falta de edad, dinero o capacidad de sala agotada: " + rechazos);
        return c;
    }

    // SE VISUALISA EL SUMARIO DE LA FUNCION
    public void verSala(Cine c) {
        System.out.println("");
        System.out.println("Pelicula: " + c.getPelicula().getTitulo());
        System.out.println("Duración: " + c.getPelicula().getDuracionEnMinutos() + " minutos");
        System.out.println("Estado de la sala durante la función: ");
        Asiento visual[][] = c.getSala();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(visual[i][j].toString());
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public void revisarEspectadores(Cine c) {
        Asiento visual[][] = c.getSala();
        int ctrol = 0;
        System.out.println("Seleccione un asiento para visualizar la información del espectador: ");
        String asientoABuscar = leer.next();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                if (visual[i][j].getUbicacion().equalsIgnoreCase(asientoABuscar)) {
                    ctrol++;
                    System.out.println("Información del espectador ubicado en "+visual[i][j].getUbicacion());
                    System.out.println(visual[i][j].getE().toString());
                    break;
                }
            }
        }

        if (ctrol == 0) {
            System.out.println("Asiento invalido. Ingrese una posición válida");
            revisarEspectadores(c);
        }
        System.out.println("Desea consultar otro asiento? s/n");
        String opc = leer.next();
        if (opc.equalsIgnoreCase("s")) {
            revisarEspectadores(c);
        }
    }

}
