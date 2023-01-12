package com.bsa;

import java.util.Arrays;
import java.util.Iterator;
public class AnalogueArrayList <T> implements Array <T>{
    private T [] array;                                                                      // основной массив
    private T [] tempArray;                                                                  // временный массив
    private int size;                                                                        // размер основного массива

    /* ******************** Конструктор *************** */
    public AnalogueArrayList(){
            array = (T[]) new Object[0];
    }

    /* ******************** Методы *************** */
    public T[] getArray() {                                                        // возвращает массив
        return array;
    }
    @Override
    public boolean add(T object) {                                                // добавление объекта по индексу
        tempArray = Arrays.copyOf(array, array.length + 1); /* копируемый массив и количество копируемых значений,
                                                                         которое определяет также длину нового массива */
        if (size == array.length) {
            array = Arrays.copyOf(tempArray, tempArray.length);
        }
        array[size++] = object;
        return true;
    }
    @Override
    public boolean addAll(Array<? extends T> collection) {                      // добавление коллекции в колекцию
        for (int i = 0; i < collection.size(); i++){
            add(collection.get(i));
        }
        return true;
    }
    @Override
    public T get(int index) {                                                   // получение объекта по индексу
        return array[index];
    }
    @Override
    public void set(int index, T object) {                                      // поместить новый объекта по индексу
        array[index] = object;
    }
    @Override
    public T remove(int index) {                                                // удаление объекта по индексу
        T value = array[index];

        for (int i = index; i < array.length - 1; i++){                         // смещаем массив после удалении элемента
            array[i] = array[i+1];
        }
        tempArray = Arrays.copyOf(array, array.length);  /* копируемый массив и количество копируемых значений,
                                                            которое определяет также длину нового массива */
        array = Arrays.copyOf(tempArray, tempArray.length -1);
        size--;
        return value;
    }
    public int size(){                                                                               // размер коллекции
        return array.length;
    }
    public static AnalogueArrayList<Integer> sort(Array<Integer> collection) {                       // сортировка
        Integer tempObject;
        boolean flag = false;

        while (!flag){
            flag = true;
            for (int i = 1; i < collection.size(); i++){
                if (collection.get(i - 1) > collection.get(i)) {
                    tempObject = collection.get(i - 1);
                    collection.set(i - 1, collection.get(i));
                    collection.set(i, tempObject);
                    flag = false;
                }
            }
        }
        return (AnalogueArrayList) collection;
    }
    /* объект данного класса помещенный в качестве второго аргумента в forEach, рассматривается в forEach как массив.
    (обязательно implements Iterator)
     */
    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(array);
    }
    @Override
    public String toString() {
        return Arrays.toString(array) + "";
    }
}
