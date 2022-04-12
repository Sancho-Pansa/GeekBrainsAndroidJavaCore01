package io.sanchopansa.lesson06;

public class Dog extends Animal {

    public Dog() {
        super(500, 10);
    }

    @Override
    public void run(int distance) {
        if(distance <= maxRunDistance)
            System.out.printf("Собака пробежала %d метров\n", distance);
        else
            System.out.println("Ошибка, она столько не пробежит");
    }

    @Override
    public void swim(int distance) {
        if(distance <= maxSwimDistance)
            System.out.printf("Собака проплыла %d метров\n", distance);
        else
            System.out.println("Ошибка, Собака столько не проплывёт");
    }
}
