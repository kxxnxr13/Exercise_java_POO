package SistemaReserva;

public class Sala {
    private final int numero; // Número de la sala
    private final boolean[] asientos; // Representación de los asientos

    public Sala(int numero, int cantidadAsientos) {
        this.numero = numero;
        this.asientos = new boolean[cantidadAsientos]; // Todos los asientos empiezan libres
    }

    public int getNumero() {
        return numero;
    }

    public void mostrarAsientos() {
        System.out.println("\nSala " + numero + " - Estado de los asientos:");
        for (int i = 0; i < asientos.length; i++) {
            System.out.print((asientos[i] ? "[X]" : "[" + (i + 1) + "]") + " ");
        }
        System.out.println();
    }

    public boolean estaLlena() {
        for (boolean ocupado : asientos) {
            if (!ocupado) {
                return false;
            }
        }
        return true;
    }

    public int asientosDisponibles() {
        int disponibles = 0;
        for (boolean ocupado : asientos) {
            if (!ocupado) disponibles++;
        }
        return disponibles;
    }

    public void reservarAsiento(int numeroAsiento) {
        if (numeroAsiento < 1 || numeroAsiento > asientos.length) {
            System.out.println("⚠️ Número de asiento inválido.");
            return;
        }

        if (asientos[numeroAsiento - 1]) {
            System.out.println("⛔ Asiento " + numeroAsiento + " ya está ocupado.");
        } else {
            asientos[numeroAsiento - 1] = true;
            System.out.println("✅ Asiento " + numeroAsiento + " reservado con éxito.");
        }
    }
}

