package ejC02.enums;

public enum Columna {

A(0),B(1),C(2),D(3),E(4),F(5);
    
private int posicion;

    private Columna() {
    }

    private Columna(int posicion) {
        this.posicion = posicion;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }




    
    
}
