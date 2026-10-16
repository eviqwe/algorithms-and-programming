package com.labs.lab2_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // читаем кол-во студентов
        int n = scanner.nextInt();

        // в каждой строке имя и возраст
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int age = scanner.nextInt();
            students.add(new Student(name, age));
        }

        Sorting<Student> sorter = new StudentSort();
        sorter.sort(students);

        // каждый студент на новой строке
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(student.getName()).append(" ").append(student.getAge()).append("\n");
        }
        System.out.print(sb);
    }
}
