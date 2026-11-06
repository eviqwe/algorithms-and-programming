package com.labs.lab4_1;

public class MinStackImpl implements MinStack<Integer> {
    private Node head = null;

    @Override
    public void push(Integer value) {
        int newMin;
        if (head == null) {
            newMin = value;
        } else {
            newMin = Math.min(value, head.min);
        }

        head = new Node(value, newMin, head);
    }

    @Override
    public Integer pop() {
        if (head == null) {
            return null;
        }

        int value = head.value;
        head = head.next;
        return value;
    }

    @Override
    public Integer top() {
        if (head == null) {
            return null;
        }
        return head.value;
    }

    @Override
    public Integer min() {
        if (head == null) {
            return null;
        }
        return head.min;
    }
}
