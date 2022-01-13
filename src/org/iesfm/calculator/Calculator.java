package org.iesfm.calculator;

public class Calculator {

    public void divide(int n1, int n2) {
        try {
            int div = n1 / n2;
            System.out.println("El resultado es " + div);
        } catch (ArithmeticException e) {
            System.out.println("No se puede dividir por cero");
        }
    }

    public void average(int[] numbers) {

        try {
            int sum = 0;
            for (int number : numbers) {
                sum += number; // equivale a sum = sum + number;
            }
            System.out.println("La media es " + sum / numbers.length);
        } catch (ArithmeticException e) {
            System.out.println("No se puede calcular la media de un array vacío");
        }
    }
}
