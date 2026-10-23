package com.labs.lab3_2;

import java.util.List;

public interface Sorting<T extends Comparable<T>> {
    void sort(List<T> nums);
}
