package org.example;

import java.util.HashMap;
import java.util.Map;

public class MapInverter {
    public static void main(String[] args) {
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("one", 1);
        originalMap.put("two", 2);
        originalMap.put("three", 3);

        Map<Integer, String> invertedMap = invertMap(originalMap);
        System.out.println("Исходная карта: " + originalMap);
        System.out.println("Переключенная карта: " + invertedMap);
    }

    public static <K, V> Map<V, K> invertMap(Map<K, V> originalMap) {
        Map<V, K> invertedMap = new HashMap<>();
        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            invertedMap.put(entry.getValue(), entry.getKey());
        }
        return invertedMap;
    }
}
