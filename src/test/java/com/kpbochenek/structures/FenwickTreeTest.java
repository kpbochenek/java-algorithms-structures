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

    @Test
    void addedMultipleValues() {
        FenwickTree t = new FenwickTree(10);

        t.add(3, 1);
        t.add(5, 2);
        t.add(7, 4);

        assertEquals(0, t.read(2));
        assertEquals(1, t.read(3));
        assertEquals(1, t.read(4));
        assertEquals(3, t.read(5));
        assertEquals(3, t.read(6));
        assertEquals(7, t.read(7));
        assertEquals(7, t.read(8));
    }

    @Test
    void scalingUp() {
        FenwickTree t = new FenwickTree(10);

        t.add(3, 1);
        t.add(5, 2);
        t.add(7, 4);

        t.scaleUp(10);

        assertEquals(0, t.read(2));
        assertEquals(10, t.read(3));
        assertEquals(10, t.read(4));
        assertEquals(30, t.read(5));
        assertEquals(30, t.read(6));
        assertEquals(70, t.read(7));
    }

    @Test
    void scaleDown() {
        FenwickTree t = new FenwickTree(10);

        t.add(3, 10);
        t.add(5, 20);
        t.add(7, 40);

        t.scaleDown(2);

        assertEquals(0, t.read(2));
        assertEquals(5, t.read(3));
        assertEquals(5, t.read(4));
        assertEquals(15, t.read(5));
        assertEquals(15, t.read(6));
        assertEquals(35, t.read(7));
    }
}
