package io.sanchopansa.lesson12;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

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

        final Object monitor = new Object();
        AtomicBoolean isFirstReady = new AtomicBoolean(false);
        AtomicBoolean isSecondReady = new AtomicBoolean(false);

        long timer = System.currentTimeMillis();

        float[] firstHalf = Arrays.copyOf(array, HALF);
        float[] secondHalf = Arrays.copyOfRange(array, HALF, SIZE);

        Thread firstPart = new Thread(() -> {
            for (int i = 0; i < HALF; i++)
                firstHalf[i] = formula(firstHalf[i], i);
            System.arraycopy(firstHalf, 0, array, 0, HALF);
            synchronized (monitor) {
                isFirstReady.set(true);
                monitor.notify();
            }
        });

        Thread secondPart = new Thread(() -> {
            for (int i = 0; i < HALF; i++)
                secondHalf[i] = formula(secondHalf[i], i);
            System.arraycopy(secondHalf, 0, array, HALF, HALF);
            synchronized(monitor) {
                isSecondReady.set(true);
                monitor.notify();
            }
        });

        Thread finalPart = new Thread(() -> {
                try {
                    while(!isFirstReady.get() || !isSecondReady.get()) {
                        synchronized (monitor) {
                            monitor.wait();
                            System.out.println("Got notifier");
                        }
                    }
                    System.out.printf("Two threads: %d ms\n", System.currentTimeMillis() - timer);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

        });

        firstPart.start();
        secondPart.start();
        finalPart.start();
    }

    private static float formula(float a, int b) {
        return (float) (a * Math.sin(0.2f + b / 5) * Math.cos(0.2f + b / 5) * Math.cos(0.4f + b / 2));
    }
}
