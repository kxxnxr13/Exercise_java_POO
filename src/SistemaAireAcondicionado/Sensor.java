package SistemaAireAcondicionado;



import java.util.Random;

public class Sensor {
    private double temperatura;
    private double humedad;

    public Sensor() {
        this.temperatura = 0;
        this.humedad = 0;
    }

    public void leerDatos() {
        Random rand = new Random();
        this.temperatura = 25 + rand.nextDouble() * 10; // Genera entre 25°C y 35°C
        this.humedad = 50 + rand.nextDouble() * 30; // Genera entre 50% y 80%
    }

    public double getTemperatura() {
        return temperatura;
    }

    public double getHumedad() {
        return humedad;
    }
}
