package com.labs.lab3_3;

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

    @Override
    public int compareTo(Student other) {
        int byName = name.compareTo(other.name);
        if (byName != 0) {
            return byName;
        }
        return Integer.compare(age, other.age);
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}
