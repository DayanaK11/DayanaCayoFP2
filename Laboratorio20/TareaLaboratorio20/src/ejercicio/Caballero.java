package ejercicio;

class Caballero extends Soldado {
    private String arma;

    public Caballero(String nombre, int vida, int fila, int columna, String arma) {
        super(nombre, vida, fila, columna);
        this.arma = arma;
    }

    public void montar() {
        System.out.println(nombre + " montando...");
    }

    public void desmontar() {
        System.out.println(nombre + " desmontando...");
    }

    public void embestir() {
        System.out.println(nombre + " embistiendo...");
    }

	public String getArma() {
		return arma;
	}

	public void setArma(String arma) {
		this.arma = arma;
	}
    
    
}
