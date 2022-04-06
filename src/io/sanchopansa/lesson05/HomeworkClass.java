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

        Employee[] employees = new Employee[5];
        employees[0] = first;
        employees[1] = new Employee(
                "Петр",
                "Петров",
                "Петрович",
                26,
                "Инженер",
                "example@example.com",
                "+1234567890",
                100000
        );
        employees[2] = new Employee(
                "Алексей",
                "Сидоров",
                "Алексеевич",
                27,
                "Старший инженер",
                "example@example.com",
                "+1234567890",
                120000
        );
        employees[3] = new Employee(
                "Александр",
                "Александров",
                "Александрович",
                32,
                "Ведущий специалист",
                "example@example.com",
                "+1234567890",
                160000
        );
        employees[4] = new Employee(
                "Сергей",
                "Павлов",
                "Павлович",
                45,
                "Начальник отдела",
                "example@example.com",
                "+1234567890",
                200000
        );

        for(int i = 0; i < employees.length; i++) {
            if(employees[i].getAge() > 40)
                System.out.println(employees[i]);
        }
    }
}
