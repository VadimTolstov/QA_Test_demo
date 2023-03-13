package ru.tolstov.hw_9;

import java.util.Queue;

abstract class As {

    static void collectionWork(Queue col, String string) { // вставьте нужный код
        Object polledObject = col.add(string);
    }

    public static Object processAnyList(Queue<String> list, Object o) {
        list.add((String) o);
        return list;
    }

    static void addList(Queue<?> list) {

    }

    static void printList(Queue<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }
}