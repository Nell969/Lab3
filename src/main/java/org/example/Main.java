package org.example;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // 1
        int N = 10;
        //a)
        int[] randomNumbers = new Random().ints(N, 0, 101).toArray();
        System.out.println("Массив случайных чисел: " + Arrays.toString(randomNumbers));

        //b)
        List<Integer> numberList = new ArrayList<>();
        for (int num : randomNumbers) {
            numberList.add(num);
        }

        //c)
        Collections.sort(numberList);
        System.out.println("список по возрастанию: " + numberList);

        // d)
        numberList.sort(Collections.reverseOrder());
        System.out.println("список в обратном порядке:" + numberList);

        // e)
        Collections.shuffle(numberList);
        System.out.println("Перемешанный список: " + numberList);
        // f)
        Collections.rotate(numberList, 1);
        System.out.println("Циклический сдвиг на 1 элемент: " + numberList);

        // g)
        Set<Integer> uniqueSet = new HashSet<>(numberList);
        System.out.println("Уникальные элементы: " + uniqueSet);

        // h)
        Set<Integer> duplicatesSet = new HashSet<>();
        for (Integer num : numberList) {
            if (Collections.frequency(numberList, num) > 1) {
                duplicatesSet.add(num);
            }
        }
        System.out.println("Дублирующиеся элементы: " + duplicatesSet);

        // i)
        Integer[] newArray = numberList.toArray(new Integer[0]);
        System.out.println("Полученный массив из списка: " + Arrays.toString(newArray));

        // j)
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : newArray) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        countMap.forEach((key, value) -> System.out.println("Число " + key + " встречается " + value + " раз"));
    }
}
