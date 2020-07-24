package ru.geekbrains.java.homeworks;

public class MyArrayDataException extends RuntimeException{
    public MyArrayDataException(StringBuilder message) {
        super("Invalid data "+message);
    }
}
