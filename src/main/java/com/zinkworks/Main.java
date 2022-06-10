package com.zinkworks;

import java.util.*;

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

        // Banking exercise
        Bank bank = new Bank("National Irish Bank");

        if(bank.addBranch("Mullingar")) {
            System.out.println("Mullingar branch created");
        }

        bank.addCustomer("Mullingar", "Ruth", 50.05);
        bank.addCustomer("Mullingar", "Mike", 175.34);
        bank.addCustomer("Mullingar", "Percy", 220.12);

        bank.addBranch("Athlone");
        bank.addCustomer("Athlone", "Bob", 150.54);

        bank.addCustomerTransaction("Mullingar", "Ruth", 44.22);
        bank.addCustomerTransaction("Mullingar", "Ruth", 12.44);
        bank.addCustomerTransaction("Mullingar", "Mike", 1.65);

        bank.listCustomers("Mullingar", true);
        bank.listCustomers("Athlone", true);

        bank.addBranch("Galway");

        if(!bank.addCustomer("Galway", "Brian", 5.53)) {
            System.out.println("Error Galway branch does not exist");
        }

        if(!bank.addBranch("Mullingar")) {
            System.out.println("Mullingar branch already exists");
        }

        if(!bank.addCustomerTransaction("Mullingar", "Fergus", 52.33)) {
            System.out.println("Customer does not exist at branch");
        }

        if(!bank.addCustomer("Mullingar", "Ruth", 12.21)) {
            System.out.println("Customer Ruth already exists");
        }

        // Linked list
        LinkedList<String> placesToVisit = new LinkedList<String>();
        addInOrder(placesToVisit, "Sydney");
        addInOrder(placesToVisit, "Melbourne");
        addInOrder(placesToVisit, "Brisbane");
        addInOrder(placesToVisit, "Perth");
        addInOrder(placesToVisit, "Canberra");
        addInOrder(placesToVisit, "Adelaide");
        addInOrder(placesToVisit, "Darwin");
        printList(placesToVisit);

        addInOrder(placesToVisit, "Alice Springs");
        addInOrder(placesToVisit, "Darwin");
        printList(placesToVisit);
        visit(placesToVisit);
    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> i= linkedList.iterator();
        while(i.hasNext()) {
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("=========================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while(stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            if(comparison == 0) {
                // equal, do not add
                System.out.println(newCity + " is already included as a destination");
                return false;
            } else if(comparison > 0) {
                // new City should appear before this one
                // Brisbane  -> Adelaide
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else if(comparison < 0) {
                // move on next city
            }
        }

        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList cities) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();

        if(cities.isEmpty()) {
            System.out.println("No cities in the itenerary");
            return;
        } else {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action) {
                case 0:
                    System.out.println("Holiday (Vacation) over");
                    quit = true;
                    break;

                case 1:
                    if(!goingForward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now visiting " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    break;

                case 2:
                    if(goingForward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now visiting " + listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the list");
                        goingForward = true;
                    }
                    break;

                case 3:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress ");
        System.out.println("0 - to quit\n" +
                "1 - go to next city\n" +
                "2 - go to previous city\n" +
                "3 - print menu options");
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