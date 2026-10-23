package com.labs.lab3_3;

import java.util.List;

public class InsertionSort<T extends Comparable<? super T>> implements Sorting<T> {
    @Override
    public void sort(List<T> nums) {
        // идем по массиву начиная со 2 элемента, элемент с индексом 0 уже считается отсортированной частью
        for (int i = 1; i < nums.size(); i++) {
            T current = nums.get(i);
            int j = i - 1;

            // сдвигаем вправо все элементы которые > current
            // a.compareTo(b) > 0 значит a > b
            while (j >= 0 && nums.get(j).compareTo(current) > 0) {
                nums.set(j + 1, nums.get(j));
                j--;
            }

            // ставим current на освободившееся место
            nums.set(j + 1, current);
        }
    }
}
