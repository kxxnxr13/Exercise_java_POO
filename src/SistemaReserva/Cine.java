package SistemaReserva;

import java.util.Scanner; // Importamos la clase Scanner para leer la entrada del usuario.

public class Cine { // Definimos la clase Cine, que gestiona varias salas de cine.
    private final Sala[] salas; // Array de objetos Sala, representa las salas del cine.

    /**
     * Constructor de la clase Cine.
     * Inicializa el cine con 3 salas, cada una con 10 asientos.
     */
    public Cine() {
        // Se crean 3 salas con 10 asientos cada una y se almacenan en el array `salas`
        salas = new Sala[]{
                new Sala(1, 10), // Sala 1 con 10 asientos
                new Sala(2, 10), // Sala 2 con 10 asientos
                new Sala(3, 10)  // Sala 3 con 10 asientos
        };
    }

    /**
     * Método que muestra el estado de las salas disponibles.
     * Indica cuántos asientos libres tiene cada sala.
     */
    public void mostrarSalas() {
        System.out.println("\n--- Salas Disponibles ---");
        for (Sala sala : salas) { // Itera sobre el array de salas
            System.out.println("Sala " + sala.getNumero() + " - Asientos disponibles: " + sala.asientosDisponibles());
        }
    }

    /**
     * Método que devuelve una sala según su número.
     * @param numeroSala Número de la sala solicitada.
     * @return La sala correspondiente si existe, de lo contrario retorna null.
     */
    public Sala getSala(int numeroSala) {
        // Verifica si el número de sala está dentro del rango válido (1 a 3)
        if (numeroSala >= 1 && numeroSala <= salas.length) {
            return salas[numeroSala - 1]; // Devuelve la sala correspondiente (ajustando índice del array)
        }
        return null; // Si el número de sala no es válido, retorna null.
    }

    /**
     * Método que gestiona todo el proceso de reservas.
     * Permite al usuario seleccionar una sala y reservar asientos hasta que decida salir o la sala esté llena.
     */
    public void gestionarReservas() {
        Scanner scanner = new Scanner(System.in); // Se crea un objeto Scanner para leer entrada del usuario.

        // Solicita al usuario que seleccione una sala
        System.out.print("Seleccione una sala (1-3): ");
        int salaSeleccionada = scanner.nextInt(); // Lee el número de la sala elegida

        Sala sala = getSala(salaSeleccionada); // Obtiene el objeto Sala correspondiente

        if (sala != null) { // Verifica si la sala seleccionada es válida
            int asiento; // Variable para almacenar el número de asiento elegido por el usuario.

            do {
                sala.mostrarAsientos(); // Muestra el estado actual de los asientos en la sala.

                // Verifica si la sala está llena antes de permitir reservas
                if (sala.estaLlena()) {
                    System.out.println("🚨 ¡Sala llena! No hay más asientos disponibles.");
                    break; // Sale del bucle si no hay más asientos disponibles
                }

                // Solicita al usuario un número de asiento
                System.out.print("Ingrese el número de asiento a reservar (0 para salir): ");
                asiento = scanner.nextInt(); // Captura el número del asiento

                if (asiento != 0) { // Si el usuario no ingresa 0, intenta reservar el asiento
                    sala.reservarAsiento(asiento);
                }
            } while (asiento != 0); // Repite el proceso hasta que el usuario ingrese 0 (salir)
        } else {
            System.out.println("Sala no válida."); // Mensaje de error si la sala no existe.
        }
    }
}
