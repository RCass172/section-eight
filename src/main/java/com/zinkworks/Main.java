package com.zinkworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] intList = getInt(5);
        int[] sorted = sortInt(intList);
        printArray(sorted);
    }

    public static int[] getInt(int amount) {
        Scanner s = new Scanner(System.in);
        int[] list = new int[amount];
        System.out.println("Enter " + amount + " numbers:\r");

        for(int x = 0; x < list.length; x++) {
            list[x] = s.nextInt();
        }
        return list;
    }

    public static void printArray(int[] array) {
        for (int x = 0; x < array.length; x++) {
            System.out.println(array[x]);
        }
    }

    // Sorts in Desc order
    public static int[] sortInt(int[] array) {
//        int[] sorted = new int[array.length];
//        for (int x = 0; x < array.length; x++) {
//            sorted[x] = array[x];
//        }
        int[] sorted = Arrays.copyOf(array, array.length);
        boolean flag = true;
        int temp;

        while (flag) {
            flag = false;
            for (int x = 0; x < sorted.length-1; x++) {
                if (sorted[x] < sorted[x+1]) {
                    temp = sorted[x];
                    sorted[x] = sorted[x+1];
                    sorted[x+1] = temp;
                    flag = true;
                }
            }
        }
        return sorted;
    }
}