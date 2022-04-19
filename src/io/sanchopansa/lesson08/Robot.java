package io.sanchopansa.lesson08;

public class Robot implements Sportable {
    private int maxJumpHeight;
    private final int maxRunDistance = Integer.MAX_VALUE;

    public Robot(int maxJumpHeight) {
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public boolean jump(Wall wall) {
        if(this.maxJumpHeight >= wall.getHeight()) {
            System.out.println("Робот прыгнул");
            return true;
        }
        System.out.println("Робот не перепрыгнул");
        return false;
    }

    @Override
    public boolean run(RunningTrack track) {
        System.out.println("Робот пробежал. Он всегда пробежит.");
        return true;
    }

    @Override
    public String toString() {
        return "Робот";
    }
}
