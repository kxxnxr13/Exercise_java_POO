package SistemaReserva;

import java.util.Scanner;

public class Cine {
    private final Sala[] salas; // Array de salas en el cine

    public Cine() {
        // Inicializa 3 salas con 10 asientos cada una
        salas = new Sala[]{
                new Sala(1, 10),
                new Sala(2, 10),
                new Sala(3, 10)
        };
    }

    public void mostrarSalas() {
        System.out.println("\n--- Salas Disponibles ---");
        for (Sala sala : salas) {
            System.out.println("Sala " + sala.getNumero() + " - Asientos disponibles: " + sala.asientosDisponibles());
        }
    }

    public Sala getSala(int numeroSala) {
        if (numeroSala >= 1 && numeroSala <= salas.length) {
            return salas[numeroSala - 1];
        }
        return null;
    }

    // Método que gestiona todo el proceso de reservas
    public void gestionarReservas() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Seleccione una sala (1-3): ");
        int salaSeleccionada = scanner.nextInt();
        Sala sala = getSala(salaSeleccionada);

        if (sala != null) {
            int asiento;
            do {
                sala.mostrarAsientos();

                if (sala.estaLlena()) {
                    System.out.println("🚨 ¡Sala llena! No hay más asientos disponibles.");
                    break;
                }

                System.out.print("Ingrese el número de asiento a reservar (0 para salir): ");
                asiento = scanner.nextInt();

                if (asiento != 0) {
                    sala.reservarAsiento(asiento);
                }
            } while (asiento != 0);
        } else {
            System.out.println("Sala no válida.");
        }
    }
}
