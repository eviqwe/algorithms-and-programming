package com.labs.lab7_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("lis-input.txt"));

        int n = Integer.parseInt(reader.readLine().trim());
        String[] parts = reader.readLine().trim().split(" ");
        reader.close();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(parts[i]);
        }

        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        List<Integer> result = lis.find(a);

        PrintWriter writer = new PrintWriter(new FileWriter("lis-output.txt"));
        writer.println(result.size());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(result.get(i));
        }
        writer.println(sb);
        writer.close();
    }
}
