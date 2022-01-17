package org.iesfm.calculator;

import org.iesfm.calculator.exceptions.DivideByZeroException;
import org.iesfm.calculator.exceptions.EmptyArrayException;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Thread.sleep;

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

    }private double askDouble(String message) {
        Double number = null;
        while (number == null) {
            try {
                System.out.println(message);
                number = scanner.nextDouble();
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

    private double[] askNumbers() {
        double[] numbers = new double[askSize()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = askInteger("Introduce un número entero");
        }
        return numbers;
    }

    public void run() {
        int operation = askOperation();
        while (operation != 3) {
            if (operation == 1) {
                try {
                    double result = calculator.divide(askDouble("Introduce un número entero"), askDouble("Introduce otro número entero"));
                    System.out.println(result);
                } catch (DivideByZeroException e) {
                    System.out.println("No se puede dividir entre cero");
                }
            } else if (operation == 2) {

                try {
                    double result = calculator.average(askNumbers());
                    System.out.println(result);
                } catch (EmptyArrayException e) {
                    System.out.println("Necesita introducir numeros para calcular la media");
                }

            } else {
                System.out.println("Opción desconocida");
            }
            System.out.println();

            operation = askOperation();
        }
    }
}
