package io.sanchopansa.lesson06;

public abstract class Animal {

    private static int classCounter = 0;

    protected int maxRunDistance;
    protected int maxSwimDistance;

    public Animal() {
        classCounter++;
    }

    public Animal(int maxRunDistance, int maxSwimDistance) {
        classCounter++;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
    }

    public void run(int distance) {
        if(distance <= maxRunDistance)
            System.out.printf("Животное пробежало %d метров\n", distance);
        else
            System.out.println("Ошибка, оно столько не пробежит");
    }

    public void swim(int distance) {
        if(distance <= maxSwimDistance)
            System.out.printf("Животное проплыло %d метров\n", distance);
        else
            System.out.println("Ошибка, оно столько не проплывёт");
    }

    public static int getCounter() {
        return classCounter;
    }
}
