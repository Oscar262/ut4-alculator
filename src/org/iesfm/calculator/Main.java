package org.iesfm.calculator;


import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        CalculatorMenu menu = new CalculatorMenu(
                scanner,
                calculator
        );
        menu.run();
    }
}
