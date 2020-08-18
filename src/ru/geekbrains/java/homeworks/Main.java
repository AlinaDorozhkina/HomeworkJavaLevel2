package ru.geekbrains.java.homeworks;

public class Main {
    public static void main(String[] args) {
        TwoLinkedList cities = new TwoLinkedList();
        cities.addLast("Chicago");
        cities.addLast("Budapest");
        cities.addLast("Rio");
        System.out.println(cities);
        cities.displayList();
        cities.addFirst("Moscow");
        System.out.println(cities);
        cities.displayList();
        System.out.println(cities.getSize());
        cities.addByIndex(2, "Paris");
        cities.displayList();
        cities.addByIndex(0, "Roma");
        System.out.println(cities);
        cities.displayList();
        System.out.println(cities.getSize());
        System.out.println(cities);
        cities.removeFirst();
        cities.displayList();
        cities.removeLast();
        cities.displayList();
        System.out.println(cities.getSize());
        cities.addByIndex(10, "Miami");

    }
}
