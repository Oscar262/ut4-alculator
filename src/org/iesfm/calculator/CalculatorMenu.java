package org.iesfm.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorMenu {

    private Scanner scanner;
    private Calculator calculator;

    public CalculatorMenu(Scanner scanner, Calculator calculator) {
        this.scanner = scanner;
        this.calculator = calculator;
    }

    private int askInteger(String message) {
        Integer number = null;
        while (number == null) {
            try {
                System.out.println(message);
                number = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error, no has introducido un número");
            } finally {
                scanner.nextLine();
            }
        }

        return number;
    }

    private int askOperation() {
        System.out.println("Qué deseas hacer");
        System.out.println("1. Dividir");
        System.out.println("2. Media");
        System.out.println("3. Salir");
        int operation = askInteger("");

        while (operation != 1 && operation != 2 && operation != 3) {
            operation = askInteger("Opción inválida...");
        }

        return operation;
    }

    private int askSize() {
        int size = askInteger("Introduce el tamaño del array");
        while (size < 0) {
            size = askInteger("El tamaño debe ser mayor que cero, introduce el tamaño del array");
        }
        return size;
    }

    private int[] askNumbers() {
        int[] numbers = new int[askSize()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = askInteger("Introduce un número entero");
        }
        return numbers;
    }

    public void run() {
        int operation = askOperation();
        while (operation != 3) {
            if (operation == 1) {
                calculator.divide(askInteger("Introduce un número entero"), askInteger("Introduce otro número entero"));
            } else if (operation == 2) {
                calculator.average(askNumbers());
            } else {
                System.out.println("Opción desconocida");
            }

            operation = askOperation();
        }
    }
}
