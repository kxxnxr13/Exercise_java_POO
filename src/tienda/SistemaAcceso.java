package tienda;


import java.time.LocalTime;
import java.util.Scanner;

public class SistemaAcceso {
    public static void iniciarSistema() {
        Scanner scanner = new Scanner(System.in);

        // Definir horario de la tienda (Ejemplo: 9:00 AM - 9:00 PM)
        Tienda tienda = new Tienda(LocalTime.of(9, 0), LocalTime.of(21, 0));

        char continuar;
        do {
            System.out.println("\n--- Control de Acceso a la Tienda ---");

            // Ingresar datos del cliente
            System.out.print("¿Tiene membresía? (s/n): ");
            boolean tieneMembresia = scanner.next().equalsIgnoreCase("s");

            System.out.print("¿Es empleado? (s/n): ");
            boolean esEmpleado = scanner.next().equalsIgnoreCase("s");

            // Crear objeto Cliente
            Cliente cliente = new Cliente(tieneMembresia, esEmpleado);

            // Procesar y mostrar si se permite el acceso
            if (tienda.permitirAcceso(cliente)) {
                System.out.println("✅ Acceso permitido.");
            } else {
                System.out.println("❌ Acceso denegado. La tienda está cerrada o no tiene permisos.");
            }

            // Preguntar si desea continuar
            System.out.print("¿Desea probar otro acceso? (s/n): ");
            continuar = scanner.next().charAt(0);

        } while (continuar == 's' || continuar == 'S');

        System.out.println("Sistema finalizado.");
        scanner.close();
    }
}

