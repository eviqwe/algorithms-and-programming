package com.labs.lab2_2;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Sorting<Integer> {
    // делим отрезок [start, end] пополам и сортируем половинки и сливаем их
    private void slice(List<Integer> nums, int start, int end) {
        // если в отрезке один элемент или ноль, то он уже отсортирован
        if (start >= end) {
            return;
        }

        int middle = (start + end) / 2;
        slice(nums, start, middle);
        slice(nums, middle + 1, end);
        merge(nums, start, middle, end);
    }

    // сливаем две отсортированные части [start, middle] и [middle + 1, end]
    private void merge(List<Integer> nums, int start, int middle, int end) {
        List<Integer> temp = new ArrayList<>();

        int left = start;
        int right = middle + 1;

        // берем меньший элемент из двух половинок
        while (left <= middle && right <= end) {
            if (nums.get(left) <= nums.get(right)) {
                temp.add(nums.get(left));
                left++;
            } else {
                temp.add(nums.get(right));
                right++;
            }
        }

        // докидываем то, что осталось в левой половине
        while (left <= middle) {
            temp.add(nums.get(left));
            left++;
        }

        // докидываем то, что осталось в правой половине
        while (right <= end) {
            temp.add(nums.get(right));
            right++;
        }

        // копируем результат обратно в исходный список
        for (int i = 0; i < temp.size(); i++) {
            nums.set(start + i, temp.get(i));
        }
    }

    @Override
    public void sort(List<Integer> nums) {
        slice(nums, 0, nums.size() - 1);
    }
}
