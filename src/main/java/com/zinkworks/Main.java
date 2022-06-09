package com.zinkworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    private static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int[] intList = getInt(5);
        int[] sorted = sortInt(intList);
        printArray(sorted);

        System.out.println("Enter how many numbers to enter");
        int count = s.nextInt();
        s.nextLine();
        int[] returnedArray = readInteger(count);
        int returnedMin = findMin(returnedArray);
        System.out.println("min = " + returnedMin);

        int[] arr = new int[5];
        arr[0] = 2;
        arr[1] = 28;
        arr[2] = 46;
        arr[3] = 7;
        arr[4] = 52;
        reverse(arr);
    }

    public static int[] getInt(int amount) {

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

    private static int[] readInteger(int count) {
        int[] myArray = new int[count];
        for (int x=0; x<myArray.length; x++) {
            System.out.println("Enter number: ");
            int num = s.nextInt();
            s.nextLine();
            myArray[x] = num;
        }
        return myArray;
    }

    private static int findMin(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    private static void reverse(int[] arr) {
        System.out.println("Array = " + Arrays.toString(arr));
        int[] reverse = new int[arr.length];
        int num = 0;
        for (int x=arr.length-1; x>=0;x--) {
            reverse[x] = arr[num];
            num += 1;
        }
        System.out.println("Reversed array = " + Arrays.toString(reverse));
    }
}