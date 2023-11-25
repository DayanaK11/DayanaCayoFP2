package ejercicio;

class Lancero extends Soldado {
    private int longitudLanza;

    public Lancero(String nombre, int vida, int fila, int columna, int longitudLanza) {
        super(nombre, vida, fila, columna);
        this.longitudLanza = longitudLanza;
    }

    public void schiltrom() {
        System.out.println(nombre + " formando schiltrom...");
    }

	public int getLongitudLanza() {
		return longitudLanza;
	}

	public void setLongitudLanza(int longitudLanza) {
		this.longitudLanza = longitudLanza;
	}
    
}

