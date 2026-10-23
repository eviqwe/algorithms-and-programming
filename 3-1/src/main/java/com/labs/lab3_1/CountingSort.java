package com.labs.lab3_1;

import java.util.List;

public class CountingSort implements Sorting<Integer> {
    // числа в массиве от 0 до 127, значит возможных значений 128
    private static final int MAX_VALUE = 127;

    @Override
    public void sort(List<Integer> nums) {
        // count[x] сколько раз число x встретилось в массиве
        int[] count = new int[MAX_VALUE + 1];
        for (int i = 0; i < nums.size(); i++) {
            count[nums.get(i)]++;
        }

        // идем по всем значениям по возрастанию и записываем каждое столько раз сколько оно встретилось
        int index = 0;
        for (int value = 0; value <= MAX_VALUE; value++) {
            for (int k = 0; k < count[value]; k++) {
                nums.set(index, value);
                index++;
            }
        }
    }
}
