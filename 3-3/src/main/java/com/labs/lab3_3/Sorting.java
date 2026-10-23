package com.labs.lab3_3;

import java.util.List;

// тут не Comparable<T>, а Comparable<? super T>:
// T должен уметь сравниваться с T или с каким то своим родителем
// без этого не получится сортировать LocalDateTime, он реализует Comparable<ChronoLocalDateTime<?>>
public interface Sorting<T extends Comparable<? super T>> {
    void sort(List<T> nums);
}
