package com.labs.lab1_2;

public class RemoveElement {
    public int removeElementInplace(int[] arr, int val) {
        // k - сколько "хороших" элементов уже сложили в начало массива
        int k = 0;

        for (int i = 0; i < arr.length; i++) {
            // Если элемент не равен val, переносим его на место k
            if (arr[i] != val) {
                arr[k] = arr[i];
                k++;
            }
        }

        return k;
    }
}
