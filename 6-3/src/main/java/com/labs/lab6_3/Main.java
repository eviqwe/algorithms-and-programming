package com.labs.lab6_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.next());

        Equation equation = new Equation();
        double x = equation.solve(a);

        System.out.println(Math.round(x * 1000000) / 1000000.0);

        scanner.close();
    }
}
