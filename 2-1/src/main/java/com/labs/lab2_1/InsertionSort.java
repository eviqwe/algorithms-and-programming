package com.labs.lab2_1;

import java.util.List;

public class InsertionSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        // идем по массиву начиная со 2 элемента
        for (int i = 1; i < nums.size(); i++) {
            int current = nums.get(i);
            int j = i - 1;

            // сдвигаем вправо все элементы которые > current
            while (j >= 0 && nums.get(j) > current) {
                nums.set(j + 1, nums.get(j));
                j--;
            }

            // ставим current на освободившееся место
            nums.set(j + 1, current);
        }
    }
}
