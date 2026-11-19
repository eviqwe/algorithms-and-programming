package com.labs.lab8_1;

public class PrefixSums {
    private final long[] pref;

    public PrefixSums(int[] arr) {
        pref = new long[arr.length + 1];
        for (int k = 0; k < arr.length; k++) {
            pref[k + 1] = pref[k] + arr[k];
        }
    }

    public long sum(int i, int j) {
        return pref[j + 1] - pref[i];
    }
}
