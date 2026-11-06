package com.labs.lab4_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueueImpl queue = new PriorityQueueImpl();

        StringBuilder sb = new StringBuilder();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();

            if (line.isEmpty()) {
                break;
            }

            String[] parts = line.split(" ");
            String command = parts[0];

            if (command.equals("enqueue")) {
                int k = Integer.parseInt(parts[1]);
                queue.enqueue(k);
            } else if (command.equals("dequeue-max")) {
                Element max = queue.dequeueMaxElement();
                if (max == null) {
                    sb.append("*\n");
                } else {
                    sb.append(max.operation).append(" ").append(max.value).append("\n");
                }
            } else if (command.equals("inc")) {
                long i = Long.parseLong(parts[1]);
                int v = Integer.parseInt(parts[2]);
                queue.increment(i, v);
            }
        }

        System.out.print(sb);
        scanner.close();
    }
}
