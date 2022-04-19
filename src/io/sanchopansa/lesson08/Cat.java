package io.sanchopansa.lesson08;

public class Cat implements Sportable {
    private int maxJumpHeight;
    private int maxRunDistance;

    public Cat(int maxJumpHeight, int maxRunDistance) {
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunDistance = maxRunDistance;
    }

    @Override
    public boolean jump(Wall wall) {
        if(this.maxJumpHeight >= wall.getHeight()) {
            System.out.println("Кот прыгнул");
            return true;
        }
        System.out.println("Кот не перепрыгнул");
        return false;
    }

    @Override
    public boolean run(RunningTrack track) {
        if(this.maxRunDistance >= track.getDistance()) {
            System.out.println("Кот пробежал");
            return true;
        }
        System.out.println("Кот не пробежал дорожку");
        return false;
    }

    @Override
    public String toString() {
        return "Кот";
    }
}
