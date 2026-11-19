package com.labs.lab7_2;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    public List<Integer> find(int[] a) {
        int n = a.length;

        int[] dp = new int[n];
        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            prev[i] = -1;

            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
        }

        int last = 0;
        for (int i = 1; i < n; i++) {
            if (dp[i] > dp[last]) {
                last = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        int current = last;
        while (current != -1) {
            result.add(0, a[current]);
            current = prev[current];
        }
        return result;
    }
}
