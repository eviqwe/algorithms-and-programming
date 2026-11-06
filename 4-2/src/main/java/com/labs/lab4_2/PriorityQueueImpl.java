package com.labs.lab4_2;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueueImpl implements PriorityQueue<Integer> {
    private final List<Element> heap = new ArrayList<>();

    private final List<Element> all = new ArrayList<>();

    private long operationCounter = 0;

    @Override
    public void enqueue(Integer value) {
        operationCounter++;

        Element element = new Element(value, operationCounter, heap.size());
        heap.add(element);
        all.add(element);
        siftUp(element.index);
    }

    @Override
    public Integer dequeueMax() {
        Element max = dequeueMaxElement();
        if (max == null) {
            return null;
        }
        return max.value;
    }

    public Element dequeueMaxElement() {
        if (heap.isEmpty()) {
            return null;
        }

        Element max = heap.get(0);

        Element last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            last.index = 0;
            siftDown(0);
        }

        max.index = -1;
        return max;
    }

    @Override
    public void increment(long operation, Integer addition) {
        if (operation < 1 || operation > all.size()) {
            return;
        }

        Element element = all.get((int) operation - 1);

        if (element.index == -1) {
            return;
        }

        element.value += addition;

        siftUp(element.index);
        siftDown(element.index);
    }

    private void siftUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap.get(i).value > heap.get(parent).value) {
                swap(i, parent);
                i = parent;
            } else {
                break;
            }
        }
    }

    private void siftDown(int i) {
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;

            if (left < heap.size() && heap.get(left).value > heap.get(largest).value) {
                largest = left;
            }
            if (right < heap.size() && heap.get(right).value > heap.get(largest).value) {
                largest = right;
            }

            if (largest == i) {
                break;
            }

            swap(i, largest);
            i = largest;
        }
    }

    private void swap(int i, int j) {
        Element a = heap.get(i);
        Element b = heap.get(j);
        heap.set(i, b);
        heap.set(j, a);
        a.index = j;
        b.index = i;
    }
}
