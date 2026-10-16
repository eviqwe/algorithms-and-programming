package com.labs.lab2_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // читаем кол-во элементов
        int n = scanner.nextInt();

        // читаем элементы
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(scanner.nextInt());
        }

        Sorting<Integer> sorter = new InsertionSort();
        sorter.sort(nums);

        // вывод через пробел
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.size(); i++) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(nums.get(i));
        }
        System.out.println(sb);

        scanner.close();
    }
}
