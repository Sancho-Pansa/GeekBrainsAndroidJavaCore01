package io.sanchopansa.lesson07;

public class Cat {

    private final String name;
    private int appetite;

    private boolean satiety = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void eat(Plate p) {
        if(p.getFood() >= appetite) {
            p.decreaseFood(appetite);
            this.satiety = true;
        }
    }

    @Override
    public String toString() {
        return String.format("Cat: %s\tAppetite: %d\tПокормлен? - %s", this.name, this.appetite, this.satiety ? "Да" : "Нет");
    }
}
