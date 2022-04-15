package io.sanchopansa.lesson07;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return this.food;
    }

    public void decreaseFood(int value) {
        if(value > food)
            return;
        food -= value;
    }

    public void addFood(int value) {
        food += value;
    }

    @Override
    public String toString() {
        return "Plate: " + this.food;
    }
}
