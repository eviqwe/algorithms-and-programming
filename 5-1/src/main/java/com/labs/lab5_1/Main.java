package com.labs.lab5_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> map = new HashMapImpl<>();

        // сюда копим ответы, чтобы вывести их все вместе в конце, как в примере
        StringBuilder sb = new StringBuilder();

        // читаем команды по строкам, пока они не закончатся
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();

            // пустая строка - конец ввода (просто нажать Enter)
            if (line.isEmpty()) {
                break;
            }

            // делим строку по пробелу: "put hello world" -> ["put", "hello", "world"]
            String[] parts = line.split(" ");
            String command = parts[0];

            if (command.equals("put")) {
                map.put(parts[1], parts[2]);
            } else if (command.equals("get")) {
                sb.append(map.getValue(parts[1])).append("\n");
            } else if (command.equals("delete")) {
                map.delete(parts[1]);
            }
        }

        System.out.print(sb);
        scanner.close();
    }
}
