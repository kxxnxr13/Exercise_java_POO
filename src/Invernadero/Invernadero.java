package Invernadero;

import java.util.Random;


public class Invernadero {
    //atributos de encapsulación
    private double temperatura;
    private String EstadoSistema;

    //constructor
    public Invernadero() {
        this.temperatura = 0.0; //inicializa temperatura en 0
        this.EstadoSistema = "Inactivo"; // estado inicial sin activar ningún sistema
    }

    // metodos get y set para temp


    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    // metodos get y set para estado sistema


    public String getEstadoSistema() {
        return EstadoSistema;
    }

    public void setEstadoSistema(String EstadoSistema) {
        this.EstadoSistema = EstadoSistema;
    }

    //metodo para tomar datos simulacion sensor
    public void tomarDatos(){
        Random random = new Random();
        setTemperatura(5 + random.nextDouble() * 30); //genera temperatura entre 5°C Y 35°C
    }

    //METODO PROCESAR DATOS Y DEFINIR ESTADO SISTEMA
    public void procesarDatos() {
        if(getTemperatura() < 10){
            setEstadoSistema("Calefactor activado  \uD83D\uDD25");
        } else if (getTemperatura() > 25) {
            setEstadoSistema("Ventilador Activado  ❄️");
        } else {
            setEstadoSistema("Sistema Inactivo ⚡");
        }

    }

    public void mostrarDatos() {
        System.out.println("🌡 Temperatura actual: " + String.format("%.2f", getTemperatura()) + "°C");
        System.out.println("🔧 Estado del sistema: " + getEstadoSistema());
        System.out.println("-------------------------------");
    }

    // **Método estático para iniciar la simulación**
    public static void iniciarControl() {
        Invernadero invernadero = new Invernadero(); // Crear objeto del invernadero

        while (true) { // Bucle infinito para simular el sensor
            invernadero.tomarDatos();   // Simular lectura del sensor
            invernadero.procesarDatos(); // Determinar qué sistema activar
            invernadero.mostrarDatos();  // Mostrar la información

            try {
                Thread.sleep(5000); // Esperar 5 segundos antes de la siguiente lectura
            } catch (InterruptedException e) {
                System.out.println("Error en la simulación.");
            }
        }
    }


}
