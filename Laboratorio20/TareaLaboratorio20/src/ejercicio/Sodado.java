package ejercicio;

class Soldado {
    protected String nombre;
    protected int vida;
    protected int fila;
    protected int columna;

    public Soldado(String nombre, int vida, int fila, int columna) {
        this.nombre = nombre;
        this.vida = vida;
        this.fila = fila;
        this.columna = columna;
    }

    public void atacar() {
        System.out.println(nombre + " atacando...");
    }

    public void defender() {
        System.out.println(nombre + " defendiendo...");
    }
}
