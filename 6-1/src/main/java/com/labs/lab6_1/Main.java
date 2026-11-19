package com.labs.lab6_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        ApproximateSearch search = new ApproximateSearch();

        int m = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int query = scanner.nextInt();
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(search.findClosest(arr, query));
        }
        System.out.println(sb);

        scanner.close();
    }
}
