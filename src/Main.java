import Domotica.ControlLuces;
import Invernadero.Invernadero;
import Seguridad.SistemaSeguridad;
import SistemaReserva.Cine;
import JuegoFizzBuzz.FizzBuzz;
import Calculadora.CalculadoraSimple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;


        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Sistema de Reservas de Cine");
            System.out.println("2. Juego FizzBuzz");
            System.out.println("3. Calculadora");
            System.out.println("4. Sensor invernadero");
            System.out.println("5. Sistema de seguridad");
            System.out.println("6. Control luces_sensores");
            System.out.println("8. Salir");
            System.out.print("Seleccione un ejercicio: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    new Cine().gestionarReservas();
                    break;

                case 2:
                    System.out.println("\n--- Juego FizzBuzz ---");
                    FizzBuzz fizzBuzz = new FizzBuzz();
                    fizzBuzz.jugar();
                    break;

                case 3:
                    System.out.println("\n--- Calculadora ---");
                    CalculadoraSimple.iniciarCalculadora();
                case 4:
                    System.out.println("\n--- control de temperatura en invernadero ---");
                    Invernadero.iniciarControl();
                case 5:
                    System.out.println("\n--- sistema de seguridad ---");
                    SistemaSeguridad.iniciarSistema(); //llama a sistema de seguridad5
                case 6:
                    System.out.println("\n--- control luces ---");
                    ControlLuces.iniciarSistema();
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
