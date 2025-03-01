package Calculadora; // Ubicación en el paquete Calculadora

import java.util.Scanner; // Importamos Scanner para leer datos del usuario.

public class CalculadoraSimple { // Definimos la clase CalculadoraSimple

    // **Atributos privados para encapsulación**
    private double numero1;
    private double numero2;
    private char operacion;
    private double resultado;

    // **Constructor para inicializar valores**
    public CalculadoraSimple() {
        this.numero1 = 0;
        this.numero2 = 0;
        this.operacion = ' ';
        this.resultado = 0;
    }

    // **Método para tomar datos**
    public void tomarDatos() {
        Scanner scanner = new Scanner(System.in); // Crear Scanner para entrada

        System.out.print("Ingrese el primer número: ");
        this.numero1 = scanner.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        this.numero2 = scanner.nextDouble();

        System.out.print("Ingrese la operación (+, -, *, /): ");
        this.operacion = scanner.next().charAt(0); // Lee solo un carácter
    }

    // **Método para procesar la operación**
    public void procesarDatos() {
        switch (operacion) {
            case '+':
                resultado = numero1 + numero2;
                break;
            case '-':
                resultado = numero1 - numero2;
                break;
            case '*':
                resultado = numero1 * numero2;
                break;
            case '/':
                if (numero2 != 0) {
                    resultado = numero1 / numero2;
                } else {
                    System.out.println("⛔ Error: No se puede dividir por 0.");
                    return;
                }
                break;
            default:
                System.out.println("⚠️ Operación no válida.");
                return;
        }
    }

    // **Método para mostrar el resultado**
    public void mostrarDatos() {
        if (operacion == '+' || operacion == '-' || operacion == '*' || (operacion == '/' && numero2 != 0)) {
            System.out.println("Resultado: " + numero1 + " " + operacion + " " + numero2 + " = " + resultado);
        }
    }

    // **Método estático para iniciar la calculadora dentro del menú**
    public static void iniciarCalculadora() {
        Scanner scanner = new Scanner(System.in); // Scanner para controlar el bucle
        char continuar;

        do {
            CalculadoraSimple calculadora = new CalculadoraSimple(); // Crear objeto de la calculadora

            calculadora.tomarDatos();   // Tomar los datos del usuario
            calculadora.procesarDatos(); // Procesar la operación
            calculadora.mostrarDatos();  // Mostrar el resultado

            // Preguntar si quiere continuar
            System.out.print("¿Desea realizar otra operación? (s/n): ");
            continuar = scanner.next().charAt(0);

        } while (continuar == 's' || continuar == 'S'); // Repetir mientras el usuario quiera

        System.out.println("¡Calculadora finalizada!");
    }
}
