package SistemaReserva;

public class Sala {
    private int numero; // Número identificador de la sala
    private boolean[] asientos; // Array que representa los asientos de la sala (true = ocupado, false = libre)

    // Constructor: Inicializa la sala con su número y la cantidad de asientos especificada
    public Sala(int numero, int cantidadAsientos) {
        this.numero = numero;
        this.asientos = new boolean[cantidadAsientos]; // Todos los asientos empiezan libres (false)
    }

    // Método para obtener el número de la sala
    public int getNumero() {
        return numero;
    }

    // Método para mostrar el estado actual de los asientos en la sala
    public void mostrarAsientos() {
        System.out.println("\nSala " + numero + " - Estado de los asientos:");
        for (int i = 0; i < asientos.length; i++) {
            // Si el asiento está ocupado, muestra [X], de lo contrario, muestra su número
            System.out.print(asientos[i] ? "[X] " : "[" + (i + 1) + "] ");
        }
        System.out.println(); // Salto de línea para mejor visualización
    }

    // Método que verifica si todos los asientos están ocupados
    public boolean estaLlena() {
        for (boolean ocupado : asientos) {
            if (!ocupado) return false; // Si hay al menos un asiento libre, la sala no está llena
        }
        return true; // Si todos los asientos están ocupados, la sala está llena
    }

    // Método que cuenta cuántos asientos están disponibles en la sala
    public int asientosDisponibles() {
        int disponibles = 0;
        for (boolean ocupado : asientos) {
            if (!ocupado) disponibles++; // Cuenta los asientos que aún están libres
        }
        return disponibles;
    }

    // Método para reservar un asiento en la sala
    public void reservarAsiento(int numeroAsiento) {
        // Verifica si el número de asiento es válido
        if (numeroAsiento < 1 || numeroAsiento > asientos.length) {
            System.out.println("⚠️ Número de asiento inválido.");
            return;
        }

        // Verifica si el asiento ya está ocupado
        if (asientos[numeroAsiento - 1]) {
            System.out.println("⛔ Asiento " + numeroAsiento + " ya está ocupado.");
        } else {
            asientos[numeroAsiento - 1] = true; // Marca el asiento como ocupado
            System.out.println("✅ Asiento " + numeroAsiento + " reservado con éxito.");
        }
    }
}
