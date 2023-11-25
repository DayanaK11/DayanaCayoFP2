package ejercicio;

class Arquero extends Soldado {
    private int flechas;

    public Arquero(String nombre, int vida, int fila, int columna, int flechas) {
        super(nombre, vida, fila, columna);
        this.flechas = flechas;
    }

    public void disparar() {
        if (flechas > 0) {
            System.out.println(nombre + " disparando...");
            flechas--;
        } else {
            System.out.println(nombre + " no tiene flechas disponibles.");
        }
    }

	public int getFlechas() {
		return flechas;
	}

	public void setFlechas(int flechas) {
		this.flechas = flechas;
	}
    
    
}
