package SistemaAireAcondicionado;

import java.util.ArrayList;

public class AireAcondicionado {
    private boolean encendido;
    private ArrayList<String> historial;

    public AireAcondicionado() {
        this.encendido = false;
        this.historial = new ArrayList<>();
    }

    public void procesarDatos(Sensor sensor) {
        double temperatura = sensor.getTemperatura();
        double humedad = sensor.getHumedad();

        if ((temperatura > 28 && humedad > 60) || temperatura > 30) {
            encendido = true;
        } else {
            encendido = false;
        }

        String registro = String.format("Temp: %.2f°C, Humedad: %.2f%% -> Aire: %s",
                temperatura, humedad, (encendido ? "ENCENDIDO" : "APAGADO"));
        historial.add(registro);
        System.out.println(registro);
    }

    public void mostrarHistorial() {
        System.out.println("\n--- Historial de Lecturas ---");
        for (String registro : historial) {
            System.out.println(registro);
        }
    }
}

