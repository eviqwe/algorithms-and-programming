package com.labs.lab7_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("lcs-input.txt"));

        String x = reader.readLine().trim();
        String y = reader.readLine().trim();
        reader.close();

        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.length(x, y));
    }
}
