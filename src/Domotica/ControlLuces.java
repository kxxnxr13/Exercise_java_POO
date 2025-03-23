package Domotica; // Definimos el paquete

import java.util.Random;
import java.util.Scanner;

public class ControlLuces {
    // **Atributos**
    private boolean esDeNoche;  // True = Es de noche, False = Es de día
    private boolean hayMovimiento; // True = Hay movimiento
    private boolean lucesEncendidas; // Estado de las luces

    // **Constructor**
    public ControlLuces() {
        this.esDeNoche = false;
        this.hayMovimiento = false;
        this.lucesEncendidas = false;
    }

    // **Getters y Setters**
    public boolean isLucesEncendidas() {
        return lucesEncendidas;
    }

    public void setLucesEncendidas(boolean estado) {
        this.lucesEncendidas = estado;
    }

    // **Método para simular la lectura de sensores**
    public void tomarDatos() {
        Random random = new Random();
        esDeNoche = random.nextBoolean(); // Simula si es de noche
        hayMovimiento = random.nextBoolean(); // Simula si hay movimiento
    }

    // **Método para procesar los datos y determinar el estado de las luces**
    public void procesarDatos() {
        if (esDeNoche && hayMovimiento) {
            setLucesEncendidas(true); // Encender luces
        } else {
            setLucesEncendidas(false); // Apagar luces
        }
    }

    // **Método para mostrar el estado del sistema**
    public void mostrarDatos() {
        System.out.println("\n🔦 Estado del Control de Luces:");
        System.out.println("🌙 Es de noche: " + (esDeNoche ? "Sí" : "No"));
        System.out.println("🚶 Hay movimiento: " + (hayMovimiento ? "Sí" : "No"));
        System.out.println("💡 Luces: " + (isLucesEncendidas() ? "ENCENDIDAS 🔆" : "APAGADAS 🔅"));
        System.out.println("----------------------------------");
    }

    // **Método para iniciar la simulación del sistema**
    public static void iniciarSistema() {
        ControlLuces sistema = new ControlLuces();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n🏠 --- MENÚ DEL SISTEMA DOMÓTICO --- 🏠");
            System.out.println("1. Iniciar Simulación de Control de Luces");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n🔄 Simulando control de luces...");
                    for (int i = 0; i < 5; i++) { // Simula 5 lecturas
                        sistema.tomarDatos();
                        sistema.procesarDatos();
                        sistema.mostrarDatos();
                        try {
                            Thread.sleep(10000); // Espera 10 segundos entre lecturas
                        } catch (InterruptedException e) {
                            System.out.println("Error en la simulación.");
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n🏠 Apagando sistema domótico...");
                    break;

                default:
                    System.out.println("\n⚠️ Opción no válida.");
            }

        } while (opcion != 2);

        scanner.close();
    }
}