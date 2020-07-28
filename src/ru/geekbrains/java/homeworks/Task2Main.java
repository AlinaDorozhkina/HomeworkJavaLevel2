package ru.geekbrains.java.homeworks;

public class Task2Main {

    public static void main(String[] args) {
        TelephoneBook telephoneBook = new TelephoneBook();
        telephoneBook.add("Ivanov", "+7910-555-55-55");
        telephoneBook.add("Petrov", "+7910-554-78-21");
        telephoneBook.add("Sidorov", "+7910-553-58-41");
        telephoneBook.add("Ivanov", "+7952-164-62-55");
        telephoneBook.add("Petrov", "+7985-230-14-51");


        System.out.println(telephoneBook.get("Petrov"));
        System.out.println(telephoneBook.get("Sidorov"));
        System.out.println(telephoneBook.get("Iva"));


    }
}
