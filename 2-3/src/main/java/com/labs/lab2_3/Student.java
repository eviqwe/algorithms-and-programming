package com.labs.lab2_3;

public class Student implements Comparable<Student> {
    private final String name;
    private final int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // сравниваем студентов по имени
    @Override
    public int compareTo(Student other) {
        return name.compareTo(other.name);
    }
}
