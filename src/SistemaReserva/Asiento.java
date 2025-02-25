package SistemaReserva; // Define que esta clase pertenece al paquete 'sistemaReservas'.

// Clase que representa un asiento en la sala de cine.
public class Asiento {
    private boolean ocupado; // Atributo para saber si el asiento está ocupado.

    // Constructor de la clase. Inicialmente, el asiento está libre.
    public Asiento() {
        this.ocupado = false;
    }

    // Método que devuelve si el asiento está ocupado.
    public boolean estaOcupado() {
        return ocupado;
    }

    // Método para reservar el asiento (lo marca como ocupado).
    public void reservar() {
        this.ocupado = true;
    }
}
