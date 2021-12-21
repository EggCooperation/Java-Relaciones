package ej02.entidades;

public class Jugador {
 
    private Integer id;
    private String nombre;
    private boolean mojado;

    public Jugador() {
    }

    public Jugador(Integer id) {
        this.id = id;
        String ids = id.toString();
        ids = "Jugador ".concat(ids);
        this.nombre = ids;
        this.mojado = false;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isMojado() {
        return mojado;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMojado(boolean mojado) {
        this.mojado = mojado;
    }
    
    
    
    //METODOS

    public boolean disparo(Revolver r){
        boolean vof=false;
        if (r.mojar()) {
            mojado = true;
            vof = true;
        }
        r.nextChorro();
        return vof;  //da valor de verdadero si el jugador se mojo
    }
    
    
    @Override
    public String toString() {
        return "Jugador{" + "id=" + id + ", nombre=" + nombre + ", mojado=" + mojado + '}';
    }
    
    
    
    
}
