package io.sanchopansa.lesson02;

import java.util.Arrays;

public class HomeworkClass {
    public static void main(String[] args) {
        invertZeroOne();
        fillArray();
        multiplyLessThanSix();
        createIdentityMatrix();
        findMinMaxInArray();
        final int[] balancedArray = {5, 3, 4, 17, -5}; // 4 || 17
        final int[] unbalancedArray = {5, 3, 4, 17, -4};
        System.out.println(checkBalance(balancedArray));
        System.out.println(checkBalance(unbalancedArray));
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
        // array = Arrays.stream(array).map(x -> x<6 ? x*2 : x).toArray();
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
}
