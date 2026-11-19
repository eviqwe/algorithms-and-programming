package com.labs.lab8_2;

public class SegmentTree {
    private final int[] tree;
    private final int n;

    public SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        build(arr, 1, 0, n - 1);
    }

    private void build(int[] arr, int v, int left, int right) {
        if (left == right) {
            tree[v] = arr[left];
            return;
        }

        int middle = (left + right) / 2;
        build(arr, 2 * v, left, middle);
        build(arr, 2 * v + 1, middle + 1, right);

        tree[v] = Math.min(tree[2 * v], tree[2 * v + 1]);
    }

    public int min(int i, int j) {
        return query(1, 0, n - 1, i, j - 1);
    }

    private int query(int v, int left, int right, int from, int to) {
        if (to < left || right < from) {
            return Integer.MAX_VALUE;
        }

        if (from <= left && right <= to) {
            return tree[v];
        }

        int middle = (left + right) / 2;
        int leftMin = query(2 * v, left, middle, from, to);
        int rightMin = query(2 * v + 1, middle + 1, right, from, to);
        return Math.min(leftMin, rightMin);
    }
}
