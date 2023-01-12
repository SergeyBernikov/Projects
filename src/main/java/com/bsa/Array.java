package com.bsa;

public interface Array <T> extends Iterable <T> {
    boolean add(T object);
    boolean addAll(Array<? extends T> collection);
    T get(int index);
    void set(int index, T object);
    T remove(int index);
    int size();
}
