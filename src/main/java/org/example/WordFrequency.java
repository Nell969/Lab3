package org.example;

import java.util.HashMap;
import java.util.Map;

public class WordFrequency {
    public static void main(String[] args) {
        String text = "Step by step I am getting closer to my goal";
        Map<String, Integer> frequencyMap = new HashMap<>();

        String[] words = text.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        System.out.println("Частота слов: " + frequencyMap);
    }
}
