package ru.geekbrains.java.homeworks;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException() {
        super("Array length is not correct!");
    }
}
