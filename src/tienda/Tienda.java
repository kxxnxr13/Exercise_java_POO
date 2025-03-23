package tienda;


import java.time.LocalTime;

public class Tienda {
    private LocalTime horaApertura;
    private LocalTime horaCierre;

    // Constructor
    public Tienda(LocalTime horaApertura, LocalTime horaCierre) {
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }

    // Verifica si está dentro del horario de atención
    public boolean estaAbierta() {
        LocalTime ahora = LocalTime.now();
        return !ahora.isBefore(horaApertura) && !ahora.isAfter(horaCierre);
    }

    // Verifica si el cliente puede entrar
    public boolean permitirAcceso(Cliente cliente) {
        return cliente.esEmpleado() || (cliente.tieneMembresia() && estaAbierta());
    }
}

