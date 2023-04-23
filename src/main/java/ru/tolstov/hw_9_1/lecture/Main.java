package ru.tolstov.hw_9_1.lecture;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Используем
        boolean flag = false;
        flag = false;

        // Целочисленные типы данных
        byte aByte = 0; // -128 ... 127 (8 bit)
        aByte = (byte) (aByte + 1);

        short aShort = 0; // -32768 ... 32767 (16 bit)
        // Используем
        int aInt = 0; // 32 bit  2^(bit-1)
        long aLong = 0; // 64 bit

        // Типы данных с плавающей точкой
        float aFloat = 0F; // 32 bit
        // Используем*
        double aDouble = 0D; // 64 bit
        char aChar = '0';

        // Операторы
        // 1. Присвоение
        char bChar = 'a';
        // 2. Математические + - * / %
        int result = 5 / 2;
        System.out.println("### result: " + result);
        // 3. Операторы сравнения >, <, >=, <=, !=, ==
        System.out.println("### boolean result: " + (3 == 3));

        String s = "this is a String";
        List<Integer> aList = new ArrayList<>();

        // 4. Логические операторы &(И) && (сокращенное И), | (ИЛИ)  || (сокращенное ИЛИ), отрицание (! НЕ)
        if (methodOne() | methodAnother()) {
            System.out.println("");
        }

        // 5. Тернарный оператор
        int value = (methodOne())
                ? 10
                : 20;

        // 6 instanceof
        if (s instanceof String) {

        }

        System.out.println("### Value: " + value);
        System.out.println("Hello world!");

        // Wrapper types
        Integer aIntegerWrapper;// int
        Double aDoubleWrapper;
        Character aCharWrapper; // char

        switch (s) {
            case "dima": {
                System.out.println("Thats Dima");
                break;
            }
            case "vasya": {
                System.out.println("Thats Vasya");
            }
            default: {
                System.out.println("Default");
            }
        }

        if (s.equals("dima")) {
            System.out.println("Thats Dima");
        } else if (s.equals("vasya")) {
            System.out.println("Thats Vasya");
        } else {
            System.out.println("Default");
        }
    }

    public static boolean methodOne() {
        System.out.println("methodOne");
        return false;
    }
    public static boolean methodAnother() {
        System.out.println("methodAnother");
        return true;
    }

    public static void printInt(int arg) {
        System.out.println("### printInt: " + arg);
    }
}