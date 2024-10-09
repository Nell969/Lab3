package org.example;

import java.util.*;

class PrimesGenerator implements Iterable<Integer> {
    private final int N;

    PrimesGenerator(int N) {
        this.N = N;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int count = 0;
            private int current = 1;

            @Override
            public boolean hasNext() {
                return count < N;
            }

            @Override
            public Integer next() {
                current++;
                while (count < N) {
                    if (isPrime(current)) {
                        count++;
                        return current++;
                    }
                    current++;
                }
                throw new NoSuchElementException();
            }

            private boolean isPrime(int number) {
                for (int i = 2; i <= Math.sqrt(number); i++) {
                    if (number % i == 0) return false;
                }
                return true;
            }
        };
    }
}

class PrimesGeneratorTest {
    public static void main(String[] args) {
        int N = 10;
        PrimesGenerator primesGenerator = new PrimesGenerator(N);
       List<Integer> primesList = new ArrayList<>();

        // Прямой порядок
        for (Integer prime : primesGenerator) {
            primesList.add(prime);
        }
        System.out.println("Первые " + N + " простых чисел (прямой порядок): " + primesList);


        // Обратный порядок
        Collections.reverse(primesList);
        System.out.println("Первые " + N + " простых чисел (обратный порядок): " + primesList);
    }
}
