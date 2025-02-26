
package Calculadora;

import java.util.Scanner;

public class CalculadoraSimple {
    private double numero1;  // Primer número ingresado por el usuario
    private double numero2;  // Segundo número ingresado por el usuario
    private char operacion;  // Operación a realizar (+, -, *, /)

    // Constructor para inicializar los valores
    public CalculadoraSimple(double numero1, double numero2, char operacion) {
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.operacion = operacion;
    }

    // Método para realizar la operación seleccionada
    public double calcular() {
        switch (operacion) {
            case '+':
                return numero1 + numero2;
            case '-':
                return numero1 - numero2;
            case '*':
                return numero1 * numero2;
            case '/':
                if (numero2 != 0) {
                    return numero1 / numero2;
                } else {
                    System.out.println("⚠️ Error: No se puede dividir entre cero.");
                    return Double.NaN; // Devuelve "No es un número"
                }
            default:
                System.out.println("⚠️ Operación no válida.");
                return Double.NaN;
        }
    }

    // Método estático para iniciar la calculadora con interacción de usuario
    public static void iniciarCalculadora() {
        Scanner scanner = new Scanner(System.in);
        char continuar;

        do {
            System.out.print("Ingrese el primer número: ");
            double numero1 = scanner.nextDouble();

            System.out.print("Ingrese el segundo número: ");
            double numero2 = scanner.nextDouble();

            System.out.print("Ingrese la operación (+, -, *, /): ");
            char operacion = scanner.next().charAt(0);

            // Crear objeto Calculadora y realizar la operación
            CalculadoraSimple calculadora = new CalculadoraSimple(numero1, numero2, operacion);
            double resultado = calculadora.calcular();

            // Mostrar resultado si es válido
            if (!Double.isNaN(resultado)) {
                System.out.println("✅ Resultado: " + resultado);
            }

            // Preguntar si quiere hacer otro cálculo
            System.out.print("¿Desea realizar otra operación? (s/n): ");
            continuar = scanner.next().toLowerCase().charAt(0);

        } while (continuar == 's');

        System.out.println("🔚 Saliendo de la calculadora...");
    }
}