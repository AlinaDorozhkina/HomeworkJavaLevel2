package ru.geekbrains.java.homeworks;

import java.util.HashSet;
import java.util.Set;

public class TelephoneNumber {

    private Set<String> number;

    public TelephoneNumber(Object o) {
        this.number = new HashSet<>();
        number.add(String.valueOf(o));
    }

    public Set<String> getNumber() {
        return number;
    }

    public void addNumber(Object o) {
        this.number.add(String.valueOf(o));
    }


}
