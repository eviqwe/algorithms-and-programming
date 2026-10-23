package com.labs.lab3_2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RadixSort implements Sorting<BigInteger> {
    // по условию все числа 20-значные
    private static final int LENGTH = 20;

    @Override
    public void sort(List<BigInteger> nums) {
        // идем по цифрам справа налево (с последней до первой)
        for (int pos = LENGTH - 1; pos >= 0; pos--) { // 20 раз
            List<BigInteger> result = new ArrayList<>();

            // сначала забираем все числа, у которых на позиции pos цифра 0,
            // потом все с цифрой 1, потом с 2 и тд до 9
            for (int digit = 0; digit <= 9; digit++) { // 10 раз
                for (BigInteger num : nums) {          // n раз
                    if (num.toString().charAt(pos) - '0' == digit) {
                        result.add(num);
                    }
                }
            }

            // теперь числа упорядочены по цифре на позиции pos
            nums.clear();
            nums.addAll(result);
        }
    }
}
