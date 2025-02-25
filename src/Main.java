import SistemaReserva.Cine;
import JuegoFizzBuzz.FizzBuzz;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Sistema de Reservas de Cine");
            System.out.println("2. Juego FizzBuzz");
            System.out.println("8. Salir");
            System.out.print("Seleccione un ejercicio: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Cine cine = new Cine();
                    cine.gestionarReservas(); // Llamamos al método que maneja las reservas
                    break;

                case 2:
                    System.out.println("\n--- Juego FizzBuzz ---");
                    FizzBuzz fizzBuzz = new FizzBuzz();
                    fizzBuzz.jugar();
                    break;

                case 8:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 8);

        scanner.close();
    }
}
