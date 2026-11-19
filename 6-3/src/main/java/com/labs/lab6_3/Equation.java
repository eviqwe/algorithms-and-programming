package com.labs.lab6_3;

public class Equation {
    private double f(double x) {
        return x * x - x + Math.sqrt(x);
    }

    public double solve(double a) {
        double left = 1;
        double right = a;

        for (int i = 0; i < 100; i++) {
            double middle = (left + right) / 2;
            if (f(middle) < a) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return left;
    }
}
