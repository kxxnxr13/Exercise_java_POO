package SistemaReserva; // Define el paquete en el que se encuentra la clase Sala.

public class Sala { // Define la clase Sala, que representa una sala de cine con asientos.
    private final int numero; // Número identificador de la sala.
    private final boolean[] asientos; // Arreglo de booleanos para representar los asientos (true = ocupado, false = libre).

    /**
     * Constructor de la clase Sala.
     * @param numero Número identificador de la sala.
     * @param cantidadAsientos Cantidad total de asientos en la sala.
     */
    public Sala(int numero, int cantidadAsientos) {
        this.numero = numero; // Asigna el número de sala.
        this.asientos = new boolean[cantidadAsientos]; // Crea el arreglo de asientos, todos inician como `false` (libres).
    }

    /**
     * Método para obtener el número de la sala.
     * @return Número de la sala.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Muestra el estado actual de los asientos de la sala.
     * Si el asiento está ocupado, se muestra como [X].
     * Si el asiento está libre, se muestra con su número correspondiente.
     */
    public void mostrarAsientos() {
        System.out.println("\nSala " + numero + " - Estado de los asientos:");
        for (int i = 0; i < asientos.length; i++) {
            // Si el asiento está ocupado, se muestra [X]; si está libre, se muestra su número.
            System.out.print((asientos[i] ? "[X]" : "[" + (i + 1) + "]") + " ");
        }
        System.out.println(); // Salto de línea al final de la impresión.
    }

    /**
     * Verifica si todos los asientos están ocupados.
     * @return true si la sala está llena, false si hay al menos un asiento libre.
     */
    public boolean estaLlena() {
        for (boolean ocupado : asientos) {
            if (!ocupado) { // Si hay al menos un asiento libre, la sala no está llena.
                return false;
            }
        }
        return true; // Si todos los asientos están ocupados, la sala está llena.
    }

    /**
     * Cuenta cuántos asientos están disponibles en la sala.
     * @return Número de asientos libres.
     */
    public int asientosDisponibles() {
        int disponibles = 0;
        for (boolean ocupado : asientos) {
            if (!ocupado) disponibles++; // Suma 1 por cada asiento libre.
        }
        return disponibles; // Retorna la cantidad de asientos libres.
    }

    /**
     * Permite reservar un asiento en la sala.
     * @param numeroAsiento Número del asiento a reservar (basado en 1, no en índice de array).
     */
    public void reservarAsiento(int numeroAsiento) {
        // Validación: El número de asiento debe estar dentro del rango permitido.
        if (numeroAsiento < 1 || numeroAsiento > asientos.length) {
            System.out.println("⚠️ Número de asiento inválido.");
            return;
        }

        // Verifica si el asiento ya está ocupado.
        if (asientos[numeroAsiento - 1]) { // Se usa `numeroAsiento - 1` porque los arrays en Java inician en 0.
            System.out.println("⛔ Asiento " + numeroAsiento + " ya está ocupado.");
        } else {
            asientos[numeroAsiento - 1] = true; // Marca el asiento como ocupado.
            System.out.println("✅ Asiento " + numeroAsiento + " reservado con éxito.");
        }
    }
}

