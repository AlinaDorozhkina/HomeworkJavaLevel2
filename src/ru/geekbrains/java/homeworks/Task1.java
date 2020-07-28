package ru.geekbrains.java.homeworks;

import java.util.*;

public class Task1 {
    /*
    1.Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
    2.Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
    3.Посчитать сколько раз встречается каждое слово.
     */

    public static void main(String[] args) {

        List<String> setWords = new ArrayList();
        setWords.add("orange");
        setWords.add("apple");
        setWords.add("banana");
        setWords.add("orange");
        setWords.add("apple");
        setWords.add("pear");
        setWords.add("pea");
        setWords.add("strawberry");
        setWords.add("pineapple");
        setWords.add("apple");


        doTask(setWords);

    }

    public static void doTask(List<String> inputSet) {
        System.out.println("Input array:\n " + inputSet);
        Set<String> uniqueWords = new HashSet<>(inputSet);
        System.out.println("Unique words:\n" + uniqueWords.toString());

        for (String number : inputSet) {
            System.out.println(String.format("Word %s repeats %s times", number, Collections.frequency(inputSet, number)));
        }
    }
}
