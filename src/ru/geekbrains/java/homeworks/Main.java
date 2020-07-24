package ru.geekbrains.java.homeworks;


public class Main {

    public static void main(String[] args) {
        String[][] correctArray = {{"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"2", "2", "2", "2"}, {"3", "3", "2", "2"}};
        String[][] wrongArraySize = {{"1", "2", "3", "4", "5"}, {"1", "2", "3", "4"}, {"2", "2", "2", "2", "6", "9"}, {"2", "2", "2"}};
        String[][] wrongArrayData = {{"7", "1", "9", "4",}, {"?", "2", "р", "4"}, {"*", "2", "2", "2"}, {"2", "g", "2", "&"}};
        checkArray(correctArray);
        checkArray(wrongArraySize);
        checkArray(wrongArrayData);

    }

    public static void checkArray(String[][] inputArray) {
        System.out.println("Start");
        printArray(inputArray);

        int result = 0;
        try {
            result = checkSum(inputArray);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Result is " + (result));
        }
    }

    public static int checkSum(String[][] inputArray) {
        int sum = 0;
        int value;
        int row;
        int cell;

        if (inputArray[0].length != 4 || inputArray[1].length != 4) {
            throw new MyArraySizeException();
        }

        for (int i = 0; i < inputArray.length; i++) {
            row = i + 1;
            for (int j = 0; j < inputArray[i].length; j++) {
                cell = j + 1;
                try {
                    value = Integer.parseInt(inputArray[i][j]);
                    sum += value;
                } catch (IllegalArgumentException e) {

                    StringBuilder message = new StringBuilder();
                    message.append("row ").append(row).append(" cell ").append(cell);
                    throw new MyArrayDataException(message);
                }
            }
        }

        return sum;
    }

    public static void printArray(String[][] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                System.out.print(inputArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}

