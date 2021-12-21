package ej01.entidades;

public class Perro {

    private String nombre;
    private String raza;
    private Integer edad;
    private String tamanio;

    public Perro() {
    }

    public Perro(String nombre, String raza, Integer edad, String tamaño) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.tamanio = tamaño;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getTamaño() {
        return tamanio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setTamaño(String tamaño) {
        this.tamanio = tamaño;
    }

    @Override
    public String toString() {
        return "Perro{" + "nombre: " + nombre + ", raza: " + raza + ", edad: " + edad + ", tamanio: " + tamanio + '}';
    }

}
