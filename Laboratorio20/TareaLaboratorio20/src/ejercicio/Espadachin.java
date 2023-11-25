package ejercicio;

class Espadachin extends Soldado {
    private int longitudEspada;

    public Espadachin(String nombre, int vida, int fila, int columna, int longitudEspada) {
        super(nombre, vida, fila, columna);
        this.longitudEspada = longitudEspada;
    }

    public void crearMuroEscudos() {
        System.out.println(nombre + " creando un muro de escudos...");
    }

	public int getLongitudEspada() {
		return longitudEspada;
	}

	public void setLongitudEspada(int longitudEspada) {
		this.longitudEspada = longitudEspada;
	}
    
    
}
