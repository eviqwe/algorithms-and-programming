package com.labs.lab1_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine().trim();

        BracketChecker checker = new BracketChecker();
        System.out.println(checker.isBalanced(str));
    }
}
