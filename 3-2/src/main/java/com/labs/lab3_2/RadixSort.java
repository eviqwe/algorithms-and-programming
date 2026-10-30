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
        for (int pos = LENGTH - 1; pos >= 0; pos--) {
            // 10 корзин: в корзину 0 кладем числа с цифрой 0, в корзину 1 с цифрой 1 и тд
            List<List<BigInteger>> buckets = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                buckets.add(new ArrayList<>());
            }

            // один раз проходим по числам и кидаем каждое в корзину по его цифре
            for (BigInteger num : nums) {
                int digit = num.toString().charAt(pos) - '0';
                buckets.get(digit).add(num);
            }

            // собираем корзины обратно по порядку: 0, 1, 2 ... 9
            nums.clear();
            for (List<BigInteger> bucket : buckets) {
                nums.addAll(bucket);
            }
        }
    }
}
