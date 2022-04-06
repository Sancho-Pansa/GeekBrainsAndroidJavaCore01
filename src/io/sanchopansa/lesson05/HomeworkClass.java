package io.sanchopansa.lesson05;

public class HomeworkClass {

    public static void main(String[] args) {
        Employee first = new Employee(
                "Иван",
                "Иванов",
                "Иванович",
                25,
                "Инженер",
                "example@example.com",
                "+1234567890",
                100000
        );
        System.out.println(first);
    }
}
