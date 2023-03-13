package ru.tolstov.hw_9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TheList {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        System.out.println("Это  ArrayList ");
        addList(stringList, "Java");
        addList(stringList, "Как дела?");
        addList(stringList, "Привет");
        printList(stringList);
        removeList(stringList, "Java");
        printList(stringList);
        containsList(stringList, "Java");

    }

    static void printList(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    static void addList(List<String> list, Object o) {
        list.add((String) o);

    }

    static void removeList(List<String> list, Object o) {
        list.remove((String) o);

    }

    static void containsList(List<String> list, Object o) {
        System.out.println(list.contains(o));

    }
}

