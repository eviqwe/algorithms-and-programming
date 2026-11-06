package com.labs.lab4_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MinStack<Integer> stack = new MinStackImpl();

        StringBuilder sb = new StringBuilder();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();

            if (line.isEmpty()) {
                break;
            }

            String[] parts = line.split(" ");
            String command = parts[0];

            if (command.equals("push")) {
                int k = Integer.parseInt(parts[1]);
                stack.push(k);
            } else if (command.equals("pop")) {
                stack.pop();
            } else if (command.equals("top")) {
                sb.append(stack.top()).append("\n");
            } else if (command.equals("min")) {
                sb.append(stack.min()).append("\n");
            }
        }

        System.out.print(sb);
        scanner.close();
    }
}
