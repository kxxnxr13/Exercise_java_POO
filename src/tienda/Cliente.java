package tienda;



public class Cliente {
    private boolean tieneMembresia;
    private boolean esEmpleado;

    // Constructor
    public Cliente(boolean tieneMembresia, boolean esEmpleado) {
        this.tieneMembresia = tieneMembresia;
        this.esEmpleado = esEmpleado;
    }

    // Getters
    public boolean tieneMembresia() {
        return tieneMembresia;
    }

    public boolean esEmpleado() {
        return esEmpleado;
    }
}
