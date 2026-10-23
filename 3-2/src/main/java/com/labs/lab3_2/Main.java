package com.labs.lab3_2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // читаем кол-во чисел
        int n = scanner.nextInt();

        // числа 20-значные, в long не влезают, поэтому BigInteger
        List<BigInteger> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(new BigInteger(scanner.next()));
        }

        Sorting<BigInteger> sorter = new RadixSort();
        sorter.sort(nums);

        // каждое число на новой строке
        StringBuilder sb = new StringBuilder();
        for (BigInteger num : nums) {
            sb.append(num).append("\n");
        }
        System.out.print(sb);

        scanner.close();
    }
}
