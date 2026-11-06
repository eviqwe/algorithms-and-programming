package com.labs.lab5_1;

// пара ключ-значение, такие пары лежат в цепочках таблицы
public class Pair<V> {
    String key;
    V value;

    public Pair(String key, V value) {
        this.key = key;
        this.value = value;
    }
}
