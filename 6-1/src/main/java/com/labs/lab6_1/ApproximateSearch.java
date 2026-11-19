package com.labs.lab6_1;

public class ApproximateSearch {
    public int findClosest(int[] arr, int query) {
        int left = 0;
        int right = arr.length - 1;
        int found = arr.length;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (arr[middle] >= query) {
                found = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        if (found == arr.length) {
            return arr[arr.length - 1];
        }

        if (found == 0) {
            return arr[0];
        }

        int bigger = arr[found];
        int smaller = arr[found - 1];

        long toBigger = (long) bigger - query;
        long toSmaller = (long) query - smaller;

        if (toSmaller <= toBigger) {
            return smaller;
        }
        return bigger;
    }
}
