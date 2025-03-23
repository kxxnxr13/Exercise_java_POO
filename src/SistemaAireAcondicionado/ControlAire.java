package SistemaAireAcondicionado;

import java.util.Scanner;

public class ControlAire {
    public static void iniciarSistema() {
        Scanner scanner = new Scanner(System.in);
        Sensor sensor = new Sensor();
        AireAcondicionado aire = new AireAcondicionado();

        while (true) {
            System.out.println("\n--- Control de Aire Acondicionado ---");
            System.out.println("1. Leer Sensores");
            System.out.println("2. Mostrar Historial");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    sensor.leerDatos();
                    aire.procesarDatos(sensor);
                    break;
                case 2:
                    aire.mostrarHistorial();
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("❌ Opción inválida, intente de nuevo.");
            }
        }
    }
}
