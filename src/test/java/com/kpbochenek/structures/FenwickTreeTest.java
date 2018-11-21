package com.kpbochenek.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class FenwickTreeTest {
    @Test
    void initializedTreeHasOnlyZeros() {
        FenwickTree t = new FenwickTree(10);
        for (int i=1; i<=10; ++i) {
            assertEquals(0, t.read(i));
            assertEquals(0, t.readSingle(i));
        }
    }

    @Test
    void addedSingleValue() {
        FenwickTree t = new FenwickTree(10);
        t.add(4, 8);
        for (int i=1; i<=3; ++i) {
            assertEquals(0, t.read(i));
            assertEquals(0, t.readSingle(i));
        }
        for (int i=4; i<=10; ++i) {
            assertEquals(8, t.read(i));
        }

        for (int i=1; i<=10; ++i) {
            int expected = 0;
            if (i == 4) expected = 8;
            assertEquals(expected, t.readSingle(i));
        }
        assertEquals(0, t.readRange(5, 9));
    }

    //TODO: testy dla scalowania
}
