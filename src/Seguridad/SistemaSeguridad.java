package Seguridad; // Definimos el paquete

import java.util.Random;
import java.util.Scanner;

public class SistemaSeguridad {
    // **Atributos**
    private boolean sensor1; // Estado del sensor 1 (true = movimiento detectado)
    private boolean sensor2; // Estado del sensor 2
    private boolean sensor3; // Estado del sensor 3
    private boolean esDeNoche; // Indica si es de noche
    private boolean alarmaActivada; // Indica si la alarma está activada

    // **Constructor**
    public SistemaSeguridad() {
        this.sensor1 = false;
        this.sensor2 = false;
        this.sensor3 = false;
        this.esDeNoche = false;
        this.alarmaActivada = false;
    }

    // **Métodos Getter y Setter**
    public boolean isAlarmaActivada() {
        return alarmaActivada;
    }

    public void setAlarmaActivada(boolean estado) {
        this.alarmaActivada = estado;
    }

    // **Método para simular la lectura de sensores y la detección de movimiento**
    public void tomarDatos() {
        Random random = new Random();
        sensor1 = random.nextBoolean(); // Simula detección de movimiento
        sensor2 = random.nextBoolean();
        sensor3 = random.nextBoolean();
        esDeNoche = random.nextBoolean(); // Simula si es de noche
    }

    // **Método para procesar los datos y activar/desactivar la alarma**
    public void procesarDatos() {
        int sensoresActivos = (sensor1 ? 1 : 0) + (sensor2 ? 1 : 0) + (sensor3 ? 1 : 0);

        if (sensoresActivos >= 2 && esDeNoche) {
            setAlarmaActivada(true);
        } else {
            setAlarmaActivada(false);
        }
    }

    // **Método para mostrar el estado del sistema**
    public void mostrarDatos() {
        System.out.println("\n🔍 Estado de los Sensores:");
        System.out.println("📡 Sensor 1: " + (sensor1 ? "Movimiento Detectado" : "Sin Movimiento"));
        System.out.println("📡 Sensor 2: " + (sensor2 ? "Movimiento Detectado" : "Sin Movimiento"));
        System.out.println("📡 Sensor 3: " + (sensor3 ? "Movimiento Detectado" : "Sin Movimiento"));
        System.out.println("🌙 Es de noche: " + (esDeNoche ? "Sí" : "No"));
        System.out.println("🚨 Alarma: " + (isAlarmaActivada() ? "🔴 ACTIVADA" : "🟢 DESACTIVADA"));
        System.out.println("----------------------------------");
    }

    // **Método para iniciar la detección de intrusos**
    public static void iniciarSistema() {
        SistemaSeguridad sistema = new SistemaSeguridad();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n🔐 --- MENÚ DE SEGURIDAD --- 🔐");
            System.out.println("1. Iniciar Monitoreo");
            System.out.println("2. Activar/Desactivar Alarma");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n🛡 Iniciando Monitoreo de Sensores...");
                    for (int i = 0; i < 5; i++) { // Simula 5 lecturas
                        sistema.tomarDatos();
                        sistema.procesarDatos();
                        sistema.mostrarDatos();
                        try {
                            Thread.sleep(3000); // Espera 3 segundos entre lecturas
                        } catch (InterruptedException e) {
                            System.out.println("Error en la simulación.");
                        }
                    }
                    break;

                case 2:
                    sistema.setAlarmaActivada(!sistema.isAlarmaActivada());
                    System.out.println("\n🚨 Alarma " + (sistema.isAlarmaActivada() ? "ACTIVADA 🔴" : "DESACTIVADA 🟢"));
                    break;

                case 3:
                    System.out.println("\nSaliendo del sistema de seguridad...");
                    break;

                default:
                    System.out.println("\n⚠️ Opción no válida.");
            }

        } while (opcion != 3);

        scanner.close();
    }
}

