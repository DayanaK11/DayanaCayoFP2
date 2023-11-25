package ejercicio;
import java.util.*;
class Ejercito {
    private List<Soldado> soldados;

    public Ejercito() {
        this.soldados = new ArrayList<>();
    }

    public void reclutarSoldado(Soldado soldado) {
        soldados.add(soldado);
    }

    public List<Soldado> getSoldados() {
        return soldados;
    }
}
