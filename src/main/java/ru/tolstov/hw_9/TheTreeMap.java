package ru.tolstov.hw_9;

import java.util.*;

class TheTreeMap {


    public static void main(String[] args) {
        Map<Integer, String> treeMap = new TreeMap<>();
        System.out.println("Это  TreeMap ");
        putMap(treeMap, 1, "Java");
        putMap(treeMap, 2, "Как дела?");
        putMap(treeMap, 3, "Привет");
        printMap(treeMap);
        removeMap(treeMap, 1);
        printMap(treeMap);
        containsMap(treeMap, 1);


    }

    static void printMap(Map<Integer, String> map) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " = " + value);
        }

    }


    static void putMap(Map<Integer, String> map, Integer i, String o) {
        map.put(i, o);

    }

    static void removeMap(Map<Integer, String> map, Integer i) {
        System.out.println("Удален элемент " + map.remove(i));

    }

    static void containsMap(Map<Integer, String> map, Integer i) {
        System.out.println("Элемент найден? " + map.containsKey(i));

    }

}
