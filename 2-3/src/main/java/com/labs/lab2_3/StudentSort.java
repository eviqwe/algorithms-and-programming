package com.labs.lab2_3;

import java.util.ArrayList;
import java.util.List;

public class StudentSort implements Sorting<Student> {
    @Override
    public void sort(List<Student> students) {
        quickSortByAge(students, 0, students.size() - 1);
        mergeSortByName(students, 0, students.size() - 1);
    }

    // быстрая сортировка: берем опорный элемент из середины,
    // слева собираем тех кто младше, справа тех кто старше
    // нестабильная, потому что swap может перекинуть элемент через равный ему
    private void quickSortByAge(List<Student> students, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = students.get((start + end) / 2).getAge();
        int i = start;
        int j = end;

        while (i <= j) {
            // ищем слева того, кто стоит не на своем месте
            while (students.get(i).getAge() < pivot) {
                i++;
            }
            // ищем справа того, кто стоит не на своем месте
            while (students.get(j).getAge() > pivot) {
                j--;
            }
            // меняем их местами
            if (i <= j) {
                Student temp = students.get(i);
                students.set(i, students.get(j));
                students.set(j, temp);
                i++;
                j--;
            }
        }

        quickSortByAge(students, start, j);
        quickSortByAge(students, i, end);
    }

    // сортировка слиянием по имени
    private void mergeSortByName(List<Student> students, int start, int end) {
        if (start >= end) {
            return;
        }

        int middle = (start + end) / 2;
        mergeSortByName(students, start, middle);
        mergeSortByName(students, middle + 1, end);
        merge(students, start, middle, end);
    }

    private void merge(List<Student> students, int start, int middle, int end) {
        List<Student> temp = new ArrayList<>();

        int left = start;
        int right = middle + 1;

        while (left <= middle && right <= end) {
            if (students.get(left).compareTo(students.get(right)) <= 0) {
                temp.add(students.get(left));
                left++;
            } else {
                temp.add(students.get(right));
                right++;
            }
        }

        while (left <= middle) {
            temp.add(students.get(left));
            left++;
        }

        while (right <= end) {
            temp.add(students.get(right));
            right++;
        }

        for (int i = 0; i < temp.size(); i++) {
            students.set(start + i, temp.get(i));
        }
    }
}
