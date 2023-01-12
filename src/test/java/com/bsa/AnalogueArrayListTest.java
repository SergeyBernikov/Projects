package com.bsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class AnalogueArrayListTest {
    AnalogueArrayList<String> analogueArrayListString;
    AnalogueArrayList<Integer> analogueArrayListInteger;
    AnalogueArrayList<Integer> analogueArrayListIntegerTemp;
    String [] arrayString;
    Integer [] arrayInteger;

    @BeforeEach
    public void createAnalogueArrayListString(){
        analogueArrayListString = new AnalogueArrayList<>();
        analogueArrayListString.add("Head");
        analogueArrayListString.add("Leg");
        analogueArrayListString.add("Hand");
        analogueArrayListString.add("Back");
        analogueArrayListString.add("Body");

        arrayString = new String[]{"Head", "Leg", "Hand", "Back", "Body"};
    }
    @BeforeEach
    public void createAnalogueArrayListInteger(){
        analogueArrayListInteger = new AnalogueArrayList<>();
        analogueArrayListInteger.add(1);
        analogueArrayListInteger.add(2);
        analogueArrayListInteger.add(3);
        analogueArrayListInteger.add(4);
        analogueArrayListInteger.add(5);

        arrayInteger = new Integer []{1,2,3,4,5};

        analogueArrayListIntegerTemp = new AnalogueArrayList<>();
        analogueArrayListIntegerTemp.add(98751);
        analogueArrayListIntegerTemp.add(65894);
        analogueArrayListIntegerTemp.add(6597);
        analogueArrayListIntegerTemp.add(86);
        analogueArrayListIntegerTemp.add(961);
    }
    @Test
    void getArray() {
        assertArrayEquals(arrayString, analogueArrayListString.getArray());
    }
    @Test
    void AddString() {
        assertArrayEquals(arrayString, analogueArrayListString.getArray());
    }
    @Test
    void AddInteger() {
        assertArrayEquals(arrayInteger, analogueArrayListInteger.getArray());
    }
    @Test
    void addAll() {
        analogueArrayListInteger.addAll(analogueArrayListIntegerTemp);

        arrayInteger = new Integer []{1,2,3,4,5,98751,65894,6597,86,961};

        assertArrayEquals(arrayInteger, analogueArrayListInteger.getArray());
    }
    @Test
    void getInteger() {
        assertEquals(3, analogueArrayListInteger.get(2));

    }
    @Test
    void getString() {
        assertEquals("Body", analogueArrayListString.get(4));
    }
    @ParameterizedTest
    @ValueSource(strings = {"Head", "Leg", "Hand", "Back", "Body"})
    @NullSource
    void set(String str) {
        analogueArrayListString.set(0,str);
        assertEquals(str,analogueArrayListString.get(0));
    }
    @Test
    void remove() {
        analogueArrayListString.remove(0);

        arrayString = new String[]{"Leg", "Hand", "Back", "Body"};
        assertArrayEquals(arrayString, analogueArrayListString.getArray());
    }
    @Test
    void size() {
        assertEquals(5, analogueArrayListInteger.size());
    }
    @Test
    void sort() {
        arrayInteger = new Integer []{86,961,6597,65894,98751};
        AnalogueArrayList<Integer> sortInteger = AnalogueArrayList.sort(analogueArrayListIntegerTemp);
        assertArrayEquals(arrayInteger, sortInteger.getArray());
    }

}