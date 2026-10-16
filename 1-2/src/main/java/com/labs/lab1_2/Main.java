package com.labs.lab1_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // первая строка это размер массива, вторая это сам массив, третья это val
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int val = scanner.nextInt();

        RemoveElement remover = new RemoveElement();
        int k = remover.removeElementInplace(arr, val);

        // выводим в формате 2, arr = [5,5,_,_]
        StringBuilder sb = new StringBuilder();
        sb.append(k).append(", arr = [");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                sb.append(",");
            }
            if (i < k) {
                sb.append(arr[i]);
            } else {
                sb.append("_");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }
}
