package io.sanchopansa.lesson08;

public class RunningTrack extends Obstacle {
    private int distance;

    public RunningTrack(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }
}
