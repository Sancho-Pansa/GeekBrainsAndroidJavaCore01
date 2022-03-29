package io.sanchopansa.lesson02;

import java.util.Arrays;

public class HomeworkClass {
    public static void main(String[] args) {
        System.out.println("#1");
        invertZeroOne();

        System.out.println("#2");
        fillArray();

        System.out.println("#3");
        multiplyLessThanSix();

        System.out.println("#4");
        createIdentityMatrix();

        System.out.println("#5");
        findMinMaxInArray();

        System.out.println("#6");
        final int[] balancedArray = {5, 3, 4, 17, -5}; // 4 || 17
        final int[] unbalancedArray = {5, 3, 4, 17, -4};
        System.out.println(checkBalance(balancedArray));
        System.out.println(checkBalance(unbalancedArray));

        System.out.println("#7");
        final int[] array = {1,2,3,4,5,6,7};
        shiftArray(array, 3);
    }

    public static void invertZeroOne() {
        int[] initialArray = {0, 1, 1, 0, 0, 1, 1, 1, 0, 0};
        System.out.println(Arrays.toString(initialArray));
        for(int i = 0; i < initialArray.length; i++) {
            if(initialArray[i] == 1)
                initialArray[i] = 0;
            else
                initialArray[i] = 1;
        }
        System.out.println(Arrays.toString(initialArray));
    }

    public static void fillArray() {
        int[] array = new int[8];
        for(int i = 0; i < array.length; i++) {
            array[i] = i * 3;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void multiplyLessThanSix() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(array));
        for(int i = 0; i < array.length; i++) {
            if(array[i] < 6)
                array[i] = array[i] * 2;
        }
        // Или array = Arrays.stream(array).map(x -> x<6 ? x*2 : x).toArray();
        System.out.println(Arrays.toString(array));
    }

    public static void createIdentityMatrix() {
        final int dim = 4;
        int[][] idMatrix = new int[dim][dim];
        for(int i = 0; i < dim; i++) {
            idMatrix[i][i] = 1;
        }
        System.out.println(Arrays.deepToString(idMatrix));
    }

    public static void findMinMaxInArray() {
        int[] array = {6, 9, 36, -13, 45, 86, 1, 0, 99};
        int min = array[0];
        int max = array[0];
        for(int x: array) {
            if(x < min) min = x;
            if(x > max) max = x;
        }
        System.out.println("min = " + min);
        System.out.println("max = " + max);
        /* Или
        min = Arrays.stream(array).min().getAsInt();
        max = Arrays.stream(array).max().getAsInt();
        */
    }

    public static boolean checkBalance(int[] array) {
        int leftSum = 0;
        int rightSum = 0;
        for(int x: array) {
            rightSum += x;
        }
        for(int x: array) {
            leftSum += x;
            rightSum -= x;
            if(leftSum == rightSum)
                return true;
        }
        return false;
    }

    public static void shiftArray(int[] array, int n) {
        if(n == array.length)
            return;
        if(n > array.length)
            n = n % array.length;
        int gcd = gcd(array.length, n);
        for(int i = 0; i < gcd; i++) {
            int t1 = array[i];
            int j = i;
            do {
                int t2 = array[(j + n) % array.length];
                array[(j + n) % array.length] = t1;
                t1 = t2;
                j = (j + n) % array.length;
                System.out.println(Arrays.toString(array));
            } while(j != i);
        }
        /*if(gcd == 1) {
            System.out.println(Arrays.toString(array));
            int i = 0;
            int t1 = array[0];
            do {
                int t2 = array[(i + n) % array.length];
                array[(i + n) % array.length] = t1;
                t1 = t2;
                i = (i + n) % array.length;
                System.out.println(Arrays.toString(array));
            } while(i != 0);
        } else {
            for(int i = 0; i < gcd; i++) {
                int t1 = array[i];
                int j = i;
                do {
                    int t2 = array[(j + n) % array.length];
                    array[(j + n) % array.length] = t1;
                    t1 = t2;
                    j = (j + n) % array.length;
                    System.out.println(Arrays.toString(array));
                } while(j != i);
            }
        }*/
        System.out.println(Arrays.toString(array));
    }
    private static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b,a % b);
    }
}
