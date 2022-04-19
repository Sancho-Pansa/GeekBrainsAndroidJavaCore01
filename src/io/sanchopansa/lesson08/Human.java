package io.sanchopansa.lesson08;

public class Human implements Sportable {
    private int maxJumpHeight;
    private int maxRunDistance;

    public Human(int maxJumpHeight, int maxRunDistance) {
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunDistance = maxRunDistance;
    }

    @Override
    public boolean jump(Wall wall) {
        if(this.maxJumpHeight >= wall.getHeight()) {
            System.out.println("Человек прыгнул");
            return true;
        }
        System.out.println("Человек не перепрыгнул");
        return false;
    }

    @Override
    public boolean run(RunningTrack track) {
        if(this.maxRunDistance >= track.getDistance()) {
            System.out.println("Человек пробежал");
            return true;
        }
        System.out.println("Человек не пробежал дорожку");
        return false;
    }

    @Override
    public String toString() {
        return "Человек";
    }
}
