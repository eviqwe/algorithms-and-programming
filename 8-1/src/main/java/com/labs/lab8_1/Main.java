package com.labs.lab8_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(reader.readLine().trim());
        String[] parts = reader.readLine().trim().split(" ");
        int[] arr = new int[n];
        for (int k = 0; k < n; k++) {
            arr[k] = Integer.parseInt(parts[k]);
        }

        PrefixSums prefixSums = new PrefixSums(arr);

        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                break;
            }

            String[] query = line.split(" ");
            int i = Integer.parseInt(query[0]);
            int j = Integer.parseInt(query[1]);
            out.println(prefixSums.sum(i, j));
        }

        out.flush();
        reader.close();
    }
}
