package com.labs.lab3_3;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(-3);
        numbers.add(42);
        numbers.add(0);
        numbers.add(7);
        test("Integer", numbers);

        List<String> words = new ArrayList<>();
        words.add("banana");
        words.add("apple");
        words.add("cherry");
        words.add("Apple");
        test("String", words);

        List<LocalDateTime> dates = new ArrayList<>();
        dates.add(LocalDateTime.of(2025, 9, 1, 8, 30));
        dates.add(LocalDateTime.of(2024, 12, 31, 23, 59));
        dates.add(LocalDateTime.of(2025, 1, 1, 0, 0));
        dates.add(LocalDateTime.of(2025, 9, 1, 8, 0));
        test("LocalDateTime", dates);

        List<Student> students = new ArrayList<>();
        students.add(new Student("Vasya", 21));
        students.add(new Student("Vasya", 19));
        students.add(new Student("Anton", 22));
        students.add(new Student("Antonio", 23));
        test("Student", students);

        List<UUID> uuids = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            uuids.add(UUID.randomUUID());
        }
        test("UUID", uuids);
    }

    private static <T extends Comparable<? super T>> void test(String typeName, List<T> list) {
        System.out.println(typeName);
        System.out.println("до:    " + list);

        Sorting<T> sorter = new InsertionSort<>();
        sorter.sort(list);

        System.out.println("после: " + list);
        System.out.println();
    }
}
