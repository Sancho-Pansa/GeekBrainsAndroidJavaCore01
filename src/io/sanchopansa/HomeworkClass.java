package io.sanchopansa;

public class HomeworkClass {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // Примитивные типы
        byte byteVar = 5;
        short shortVar = 10;
        int intVar = 15;
        long longVar = 20;
        float floatVar = 0.5f;
        double doubleVar = 0.25;
        char charVar = 'a';
        boolean booleanVar = true;

        // 3
        System.out.println(operatorDemonstration(floatVar, floatVar, floatVar, floatVar));

        // 4
        System.out.println(isInRange(intVar, 2));

        // 5
        sgn(intVar);

        // 6
        System.out.println(isNegative(intVar));

        // 7
        printHello("Vadim");

        // 8
        System.out.println(isLeapYear(2020));
        System.out.println(isLeapYear(5));
        System.out.println(isLeapYear(200));
        System.out.println(isLeapYear(1600));
    }

    public static float operatorDemonstration(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    public static boolean isInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void sgn(int a) {
        if(a >= 0)
            System.out.println("Положительное");
        else
            System.out.println("Отрицательное");
    }

    public static boolean isNegative(int a) {
        return a < 0;
    }

    public static void printHello(String name) {
        System.out.println("Привет, " + name + "!");
        // System.out.printf("Привет, %s!", name);
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}
