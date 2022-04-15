package io.sanchopansa.lesson07;

public class HomeworkClass {
    public static void main(String[] args) {
        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Барсик", 15);
        cats[1] = new Cat("Мурка", 25);
        cats[2] = new Cat("Жаклин", 15);
        cats[3] = new Cat("Искра", 45);

        Plate plate = new Plate(95);

        for(Cat x: cats) {
            x.eat(plate);
            System.out.println(x);
            System.out.println(plate);
        }

        plate.addFood(40);
        System.out.println(plate);
        cats[3].eat(plate);
        System.out.println(cats[3]);
    }
}
