package io.sanchopansa.lesson06;

public class HomeworkClass {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.run(15);
        dog.run(520);
        dog.swim(8);
        dog.swim(12);

        cat.run(20);
        cat.run(450);
        cat.swim(5);

        System.out.printf("Класс Animal и его потомки были созданы %d раз", Animal.getCounter());
    }
}
