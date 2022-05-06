package io.sanchopansa.lesson12;

import java.util.Arrays;

public class HomeworkClass {
    private static final int SIZE = 10000000;
    private static final int HALF = SIZE / 2;



    public static void main(String[] args) {
        oneThreadedMethod();
        twoThreadedMethod();
    }

    private static void oneThreadedMethod() {
        float[] array = new float[SIZE];
        Arrays.fill(array, 1f);

        long timer = System.currentTimeMillis();

        for(int i = 0; i < SIZE; i++) {
            array[i] = formula(array[i], i);
        }
        System.out.printf("Single thread: %d ms\n", System.currentTimeMillis() - timer);
    }

    private static void twoThreadedMethod() {
        float[] array = new float[SIZE];
        Arrays.fill(array, 1f);

        long timer = System.currentTimeMillis();
        final Object monitor = new Object();

        float[] firstHalf = Arrays.copyOf(array, HALF);
        float[] secondHalf = Arrays.copyOfRange(array, HALF, SIZE);
        new Thread(() -> {
            synchronized(monitor) {
                for (int i = 0; i < HALF; i++)
                    firstHalf[i] = formula(firstHalf[i], i);
                System.arraycopy(firstHalf, 0, array, 0, HALF);
                monitor.notify();
            }
        }).start();

        new Thread(() -> {
            synchronized(monitor) {
                for (int i = 0; i < HALF; i++)
                    secondHalf[i] = formula(secondHalf[i], i);
                System.arraycopy(secondHalf, 0, array, HALF, HALF);
                monitor.notify();
            }
        }).start();

        new Thread(() -> {
            synchronized (monitor) {
                try {
                    monitor.wait();
                    System.out.printf("Two threads: %d ms\n", System.currentTimeMillis() - timer);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    private static float formula(float a, int b) {
        return (float) (a * Math.sin(0.2f + b / 5) * Math.cos(0.2f + b / 5) * Math.cos(0.4f + b / 2));
    }
}
