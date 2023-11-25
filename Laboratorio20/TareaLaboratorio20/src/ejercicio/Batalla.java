package ejercicio;
import java.util.*;

public class Batalla {
    public static void main(String[] args) {
        Ejercito ejercito1 = crearEjercitoAleatorio();
        Ejercito ejercito2 = crearEjercitoAleatorio();

        mostrarInformacionEjercitos(ejercito1, ejercito2);
        determinarGanador(ejercito1, ejercito2);
        
    }

    private static Ejercito crearEjercitoAleatorio() {
        Ejercito ejercito = new Ejercito();
        Random random = new Random();

        for (int i = 0; i < random.nextInt(10) + 1; i++) {
            Soldado soldado = null;
            int tipoSoldado = random.nextInt(4); // 0: Espadachin, 1: Caballero, 2: Arquero, 3: Lancero

            switch (tipoSoldado) {
                case 0:
                    soldado = new Espadachin("Espadachin" + i, random.nextInt(2) + 3, random.nextInt(5), random.nextInt(5), random.nextInt(3) + 1);
                    break;
                case 1:
                    soldado = new Caballero("Caballero" + i, random.nextInt(3) + 3, random.nextInt(5), random.nextInt(5), "Espada");
                    break;
                case 2:
                    soldado = new Arquero("Arquero" + i, random.nextInt(3) + 1, random.nextInt(5), random.nextInt(5), random.nextInt(10) + 1);
                    break;
                case 3:
                    soldado = new Lancero("Lancero" + i, random.nextInt(2) + 1, random.nextInt(5), random.nextInt(5), random.nextInt(3) + 1);
                    break;
            }

            ejercito.reclutarSoldado(soldado);
        }

        return ejercito;
    }

    private static void mostrarInformacionEjercitos(Ejercito ejercito1, Ejercito ejercito2) {
        System.out.println("=== Información del Ejército 1 ===");
        mostrarInformacionEjercito(ejercito1);

        System.out.println("\n=== Información del Ejército 2 ===");
        mostrarInformacionEjercito(ejercito2);
    }

    private static void mostrarInformacionEjercito(Ejercito ejercito) {
        List<Soldado> soldados = ejercito.getSoldados();

        for (Soldado soldado : soldados) {
            System.out.println("Nombre: " + soldado.nombre);
            System.out.println("Vida: " + soldado.vida);
            System.out.println("Fila: " + soldado.fila);
            System.out.println("Columna: " + soldado.columna);

            if (soldado instanceof Espadachin) {
                Espadachin espadachin = (Espadachin) soldado;
                System.out.println("Longitud de Espada: " + espadachin.getLongitudEspada());
            } else if (soldado instanceof Caballero) {
                Caballero caballero = (Caballero) soldado;
                System.out.println("Arma: " + caballero.getArma());
            } else if (soldado instanceof Arquero) {
                Arquero arquero = (Arquero) soldado;
                System.out.println("Flechas: " + arquero.getFlechas());
            } else if (soldado instanceof Lancero) {
                Lancero lancero = (Lancero) soldado;
                System.out.println("Longitud de Lanza: " + lancero.getLongitudLanza());
            }

            System.out.println(); 
        }

        Soldado soldadoConMayorVida = obtenerSoldadoConMayorVida(soldados);
        double promedioDeVida = calcularPromedioDeVida(soldados);

        System.out.println("\nMétricas adicionales:");
        System.out.println("Soldado con mayor vida: " + soldadoConMayorVida.nombre + " (Vida: " + soldadoConMayorVida.vida + ")");
        System.out.println("Promedio de vida de los soldados: " + promedioDeVida);

        // Ranking de los soldados por vida (de mayor a menor)
        List<Soldado> rankingSoldados = obtenerRankingSoldados(soldados);
        System.out.println("\nRanking de Soldados por Vida:");

        for (int i = 0; i < rankingSoldados.size(); i++) {
            Soldado soldado = rankingSoldados.get(i);
            System.out.println((i + 1) + ". " + soldado.nombre + " (Vida: " + soldado.vida + ")");
        }
    }
    private static Soldado obtenerSoldadoConMayorVida(List<Soldado> soldados) {
        return soldados.stream().max(Comparator.comparingInt(s -> s.vida)).orElse(null);
    }

    private static double calcularPromedioDeVida(List<Soldado> soldados) {
        return soldados.stream().mapToInt(s -> s.vida).average().orElse(0.0);
    }

    private static List<Soldado> obtenerRankingSoldados(List<Soldado> soldados) {
        List<Soldado> rankingSoldados = new ArrayList<>(soldados);
        rankingSoldados.sort(Comparator.comparingInt(s -> s.vida));
        Collections.reverse(rankingSoldados); // Para ordenar de mayor a menor
        return rankingSoldados;
    }

    private static void determinarGanador(Ejercito ejercito1, Ejercito ejercito2) {
        int totalVidaEjercito1 = calcularTotalVida(ejercito1.getSoldados());
        int totalVidaEjercito2 = calcularTotalVida(ejercito2.getSoldados());

        System.out.println("\nTotal de vida del Ejército 1: " + totalVidaEjercito1);
        System.out.println("Total de vida del Ejército 2: " + totalVidaEjercito2);
        System.out.println();

        if (totalVidaEjercito1 > totalVidaEjercito2) {
            System.out.println("!!Ganador ejercito 01!!"); 
        } else if (totalVidaEjercito1 < totalVidaEjercito2) {
        	System.out.println("!!Ganador ejercito 02!!");
        } else {
            System.out.println("¡La batalla terminó en empate!");
        }
    }

    private static int calcularTotalVida(List<Soldado> soldados) {
        return soldados.stream().mapToInt(s -> s.vida).sum();
    }
}
