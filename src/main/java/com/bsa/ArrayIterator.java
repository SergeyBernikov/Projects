package com.bsa;

import java.util.Arrays;
import java.util.Iterator;
public class ArrayIterator <T> implements Iterator <T>{
    private int index = 0;
    private T[] arrayIterator;
    public ArrayIterator(T[] temp) {
        this.arrayIterator = temp;
    }
    @Override
    public boolean hasNext() {
        return index < arrayIterator.length;
    }
    @Override
    public T next() {
        return arrayIterator[index++];
    }
    @Override
    public String toString() {
        return "ArrayIterator{" +
                ", arrayIterator = " + Arrays.toString(arrayIterator) +
                '}';
    }
}
