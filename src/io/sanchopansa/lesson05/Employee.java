package io.sanchopansa.lesson05;

public class Employee {
    private String firstName;
    private String surname;
    private String patronymic;
    private int age;

    private String position;
    private String email;
    private String phone;
    private int monthlyWage;

    public Employee(
            String firstName,
            String surname,
            String patronymic,
            int age,
            String position,
            String email,
            String phone,
            int monthlyWage
    ) {
        this.firstName = firstName;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.monthlyWage = monthlyWage;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Employee\n");
        result.append(String.format("ФИО: %s %s %s\n", surname, firstName, patronymic))
                .append(String.format("Возраст: %d\n", age))
                .append(String.format("Должность: %s\n", position))
                .append(String.format("Зарплата: %d\n", monthlyWage))
                .append(String.format("Email: %s\n", email))
                .append(String.format("Телефон: %s\n", phone));

        return result.toString();
    }
}
