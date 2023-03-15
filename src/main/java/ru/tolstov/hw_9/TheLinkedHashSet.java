package ru.tolstov.hw_9;

import java.util.LinkedHashSet;
import java.util.Set;

class TheLinkedHashSet {
    public static void main(String[] args) {
        Set<String> linkedHashSet = new LinkedHashSet<>();
        System.out.println("Это  LinkedHashSet ");
        addSet(linkedHashSet, "Java");
        addSet(linkedHashSet, "Как дела?");
        addSet(linkedHashSet, "Привет");
        addSet(linkedHashSet, "Привет");
        addSet(linkedHashSet, "Привет");
        addSet(linkedHashSet, "Привет");
        printSet(linkedHashSet);
        removeSet(linkedHashSet, "Java");
        printSet(linkedHashSet);
        containsSet(linkedHashSet, "Java");

    }

    static void printSet(Set<?> hashSet) {
        for (Object o : hashSet) {
            System.out.println(o);
        }
    }

    static void addSet(Set<String> hashSet, Object o) {
        hashSet.add((String) o);


    }

    static void removeSet(Set<String> hashSet, Object o) {
        System.out.println(hashSet.remove((String) o));

    }

    static void containsSet(Set<String> hashSet, Object o) {
        System.out.println(hashSet.contains(o));

    }
}

