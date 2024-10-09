package org.example;

import java.util.*;

class Human implements Comparable<Human> {
    String firstName;
    String lastName;
    int age;

    Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public int compareTo(Human other) {
        return this.lastName.compareTo(other.lastName);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + age + ")";
    }
}

class HumanComparatorByLastName implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.lastName.compareTo(h2.lastName);
    }
}

public class HumanTest {
    public static void main(String[] args) {
        List<Human> humans = Arrays.asList(
                new Human("Иван", "Иванов", 30),
                new Human("Петр", "Петров", 25),
                new Human("Сидор", "Сидоров", 28)
        );

        // a) Создание HashSet
        Set<Human> hashSet = new HashSet<>(humans);
        System.out.println("HashSet: " + hashSet);

        // b) Создание LinkedHashSet
        Set<Human> linkedHashSet = new LinkedHashSet<>(humans);
        System.out.println("LinkedHashSet: " + linkedHashSet);

        // c) Создание TreeSet
        Set<Human> treeSet = new TreeSet<>(humans);
        System.out.println("TreeSet: " + treeSet);

        // d) TreeSet с компаратором
        Set<Human> treeSetWithComparator = new TreeSet<>(new HumanComparatorByLastName());
        treeSetWithComparator.addAll(humans);
        System.out.println("TreeSet c по фамилии: " + treeSetWithComparator);

        // e) TreeSet с анонимным компаратором по возрасту
        Set<Human> treeSetAge = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return Integer.compare(h1.age, h2.age);
            }
        });
        treeSetAge.addAll(humans);
        System.out.println("TreeSet с анонимным компаратором по возрасту: " + treeSetAge);

        // f) Комментарии
        /*
        HashSet не сохраняет порядок элементов, LinkedHashSet сохраняет порядок вставки,
        а TreeSet сортирует элементы согласно их natural order или компаратору.
        Компаратор по фамилии, сортирует по фамилии, а анонимный компаратор – по возрасту.*/
    }
}
