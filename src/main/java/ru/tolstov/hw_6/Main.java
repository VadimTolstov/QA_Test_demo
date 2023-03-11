package ru.tolstov.hw_6;

public class Main {
    public static void main(String[] args) {

        int a = 20;
        int b = 35;
        double c = 23.15;


        //  Арифметические операторы
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("double a / b = " + (double) a / b);
        System.out.println("a % b = " + (b % a));
        System.out.println("Инкремент " + ++a);
        System.out.println("Декремент  " + --b);
        double d = c + b;
        System.out.println(d);
        System.out.println(a * 1000000000);
        var n = 1598 + 153.52684;
        System.out.println("var " + n);

        //логическими операторами
        System.out.println("a > b " + (a > b));
        System.out.println("a < b " + (a < b));
        System.out.println("a <= b " + (a <= b));
        System.out.println("a >= b " + (a >= b));
        System.out.println("a <= b " + (a <= b));
        System.out.println("a != b " + (a != b));
        System.out.println("a == b " + (a == b));

        if (a < b && a < n) {
            System.out.println("a < b && a < n");

        } else {
            System.out.println("and 1");
        }
        if (a < b || a > n) {
            System.out.println("a < b || a > n");

        } else {
            System.out.println("and 2");
        }
        if (!(a < b && a < n)) {
            System.out.println("and 3");

        } else {
            System.out.println("!(a < b && a < n)");

        }
    }
}