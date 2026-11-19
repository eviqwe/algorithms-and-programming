package com.labs.lab6_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextLong();
        long w = scanner.nextLong();
        long h = scanner.nextLong();

        Diplomas diplomas = new Diplomas();
        System.out.println(diplomas.findMinSide(n, w, h));

        scanner.close();
    }
}
