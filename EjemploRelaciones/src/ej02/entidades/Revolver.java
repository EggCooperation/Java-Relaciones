package ej02.entidades;

public class Revolver {

    private Integer posicionActual;
    private Integer posicionAgua;

    public Revolver() {
    }

    public Revolver(Integer posicionActual, Integer posicionAgua) {
        this.posicionActual = posicionActual;
        this.posicionAgua = posicionAgua;
    }

    public Integer getPosicionActual() {
        return posicionActual;
    }

    public Integer getPosicionAgua() {
        return posicionAgua;
    }

    public void setPosicionActual(Integer posicionActual) {
        this.posicionActual = posicionActual;
    }

    public void setPosicionAgua(Integer posicionAgua) {
        this.posicionAgua = posicionAgua;
    }

    
    
    //METODOS
    
    public void llenarRevolver() {
        posicionActual = (int) (Math.random() * 6 + 1);
        posicionAgua = (int) (Math.random() * 6 + 1);
    }

    public boolean mojar(){
        boolean vof = false;
        if (posicionActual==posicionAgua) {
            vof=true;
        }
        return vof;
    }
    
    public void nextChorro(){
        if (posicionActual==6) {
            posicionActual=1;
        }else
            posicionActual++;
    }
    
    @Override
    public String toString() {
        return "Revolver{" + "posicionActual=" + posicionActual + ", posicionAgua=" + posicionAgua + '}';
    }

}
