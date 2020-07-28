package ru.geekbrains.java.homeworks;

import java.util.Collection;

public interface Catalog {
    void add(Object k, Object v);

    Collection get(Object k);

}
