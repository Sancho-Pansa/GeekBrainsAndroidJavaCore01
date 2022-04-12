package io.sanchopansa.lesson06;

public class Cat extends Animal {

    public Cat() {
        super(200, 0);
    }

    @Override
    public void run(int distance) {
        if(distance <= maxRunDistance)
            System.out.printf("Кошка пробежала %d метров\n", distance);
        else
            System.out.println("Ошибка, Кошка столько не пробежит");
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кошки не умеют плавать");
    }
}
