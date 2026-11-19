package com.labs.lab6_2;

public class Diplomas {
    public long findMinSide(long n, long w, long h) {
        long left = 0;
        long right = Math.max(w, h) * n;

        while (left < right) {
            long middle = (left + right) / 2;
            if (fits(middle, n, w, h)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    private boolean fits(long side, long n, long w, long h) {
        long inRow = side / w;
        long rows = side / h;

        if (inRow >= n || rows >= n) {
            return inRow > 0 && rows > 0;
        }
        return inRow * rows >= n;
    }
}
