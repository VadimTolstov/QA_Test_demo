package ru.tolstov.hw_9;

import java.util.LinkedList;
import java.util.Queue;

class TheLinkedList {
    public static void main(String[] args) {
        Queue<String> stringQueue = new LinkedList<>();
        System.out.println("Это  LinkedList ");
        addList(stringQueue, "Java");
        addList(stringQueue, "Как дела?");
        addList(stringQueue, "Привет");
        printList(stringQueue);
        removeList(stringQueue, "Java");
        printList(stringQueue);
        containsList(stringQueue, "Java");

    }

    static void printList(Queue<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    static void addList(Queue<String> list, Object o) {
        list.add((String) o);

    }

    static void removeList(Queue<String> list, Object o) {
        list.remove((String) o);

    }

    static void containsList(Queue<String> list, Object o) {
        System.out.println(list.contains(o));

    }
}
