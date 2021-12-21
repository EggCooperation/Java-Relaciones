package ej03.entidades;

import ej03.enums.Palo;

public class Carta {
    
    private Integer numero;
    private Palo palo;

    public Carta() {
    }

    public Carta(Integer numero, Palo palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public Integer getNumero() {
        return numero;
    }

    public Palo getPalo() {
        return palo;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setPalo(Palo palo) {
        this.palo = palo;
    }

    @Override
    public String toString() {
        return numero + " de " + palo.getNombre();
    }
    
    
}
