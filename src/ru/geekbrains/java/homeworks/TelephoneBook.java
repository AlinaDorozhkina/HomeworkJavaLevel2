package ru.geekbrains.java.homeworks;

import java.util.*;

public class TelephoneBook implements Catalog {
    private Map<String, TelephoneNumber> telephoneAndName;

    public TelephoneBook() {
        this.telephoneAndName = new HashMap<>();
    }

    @Override
    public void add(Object k, Object v) {
        if (telephoneAndName.containsKey(k)) {
            TelephoneNumber numbers = telephoneAndName.get(k);
            numbers.addNumber(v);
        } else {
            telephoneAndName.put(String.valueOf(k), new TelephoneNumber(v));
        }
    }

    @Override
    public Collection get(Object k) {
        for (Map.Entry<String, TelephoneNumber> pb : telephoneAndName.entrySet()) {
            if (pb.getKey().equals(k)) {
                System.out.println("Owner " + pb.getKey());
                return pb.getValue().getNumber();
            }
        }
        System.out.print(String.format("Owner %s doesn't exist ",k));
        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelephoneBook that = (TelephoneBook) o;
        return Objects.equals(telephoneAndName, that.telephoneAndName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telephoneAndName);
    }
}
