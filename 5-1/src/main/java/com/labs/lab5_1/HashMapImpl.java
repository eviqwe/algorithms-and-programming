package com.labs.lab5_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashMapImpl<V> implements HashMap<String, V> {
    private static final int TABLE_SIZE = 300007;
    private static final int A = 31;

    private final List<LinkedList<Pair<V>>> table = new ArrayList<>();

    public HashMapImpl() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            table.add(null);
        }
    }

    private long hashByString(String value) {
        long hash = 0;
        for (Character ch : value.toCharArray()) {
            hash = (hash * A + ch) % TABLE_SIZE;
        }
        return hash;
    }

    @Override
    public void put(String key, V value) {
        int index = (int) hashByString(key);
        if (table.get(index) == null) {
            table.set(index, new LinkedList<>());
        }

        LinkedList<Pair<V>> chain = table.get(index);

        for (Pair<V> pair : chain) {
            if (pair.key.equals(key)) {
                pair.value = value;
                return;
            }
        }

        chain.add(new Pair<>(key, value));
    }

    @Override
    public V getValue(String key) {
        int index = (int) hashByString(key);
        LinkedList<Pair<V>> chain = table.get(index);

        if (chain == null) {
            return null;
        }

        for (Pair<V> pair : chain) {
            if (pair.key.equals(key)) {
                return pair.value;
            }
        }
        return null;
    }

    @Override
    public V delete(String key) {
        int index = (int) hashByString(key);
        LinkedList<Pair<V>> chain = table.get(index);

        if (chain == null) {
            return null;
        }

        for (Pair<V> pair : chain) {
            if (pair.key.equals(key)) {
                chain.remove(pair);
                return pair.value;
            }
        }
        return null;
    }
}
