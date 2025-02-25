package JuegoFizzBuzz;

public class FizzBuzz {
    // Método que ejecuta el juego de FizzBuzz del 1 al 100
    public void jugar() {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz"); // Si es múltiplo de 3 y 5
            } else if (i % 3 == 0) {
                System.out.println("Fizz"); // Si es múltiplo de 3
            } else if (i % 5 == 0) {
                System.out.println("Buzz"); // Si es múltiplo de 5
            } else {
                System.out.println(i); // Si no es múltiplo de 3 ni de 5
            }
        }
    }
}

