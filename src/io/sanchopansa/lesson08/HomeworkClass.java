package io.sanchopansa.lesson08;

public class HomeworkClass {
    public static void main(String[] args) {
        // Массив препятствий
        Obstacle[] obstacles = new Obstacle[5];
        obstacles[0] = new RunningTrack(100);
        obstacles[1] = new Wall(1);
        obstacles[2] = new RunningTrack(1000);
        obstacles[3] = new RunningTrack(20000);
        obstacles[4] = new Wall(4);

        // Массив участников
        Sportable[] participants = new Sportable[3];
        participants[0] = new Human(2, 2000);
        participants[1] = new Cat(5, 100);
        participants[2] = new Robot(3);

        for(Sportable x: participants) {
            boolean result = true;
            for(Obstacle y: obstacles) {
                if(y instanceof RunningTrack)
                    result = x.run((RunningTrack) y);
                else
                    result = x.jump((Wall) y);
                if(!result) {
                    System.out.println(x.toString() + " проиграл\n");
                    break;
                }
            }
        }
    }
}
