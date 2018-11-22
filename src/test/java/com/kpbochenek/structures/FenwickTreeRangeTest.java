package com.kpbochenek.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class FenwickTreeRangeTest {
    @Test
    void initializedTreeHasOnlyZeros() {
        FenwickTreeRange t = new FenwickTreeRange(10);

        for (int i=1; i<=10; ++i) {
            assertEquals(0, t.read(0));
            assertEquals(0, t.readSingle(i));
            assertEquals(0, t.readRange(i, 10));
        }
    }

    @Test
    void initializedTreeHasSingleValue() {
        FenwickTreeRange t = new FenwickTreeRange(10);

        t.add(3, 6, 5);

        assertEquals(0, t.readSingle(2));
        assertEquals(5, t.readSingle(3));
        assertEquals(5, t.readSingle(4));
        assertEquals(5, t.readSingle(5));
        assertEquals(5, t.readSingle(6));
        assertEquals(0, t.readSingle(7));

        assertEquals(0, t.read(2));
        assertEquals(5, t.read(3));
        assertEquals(10, t.read(4));
        assertEquals(15, t.read(5));
        assertEquals(20, t.read(6));
        assertEquals(20, t.read(7));
        assertEquals(20, t.read(8));

        assertEquals(5, t.readRange(4, 4));
        assertEquals(10, t.readRange(4, 5));
        assertEquals(15, t.readRange(4, 6));
        assertEquals(15, t.readRange(4, 8));
        assertEquals(20, t.readRange(1, 8));
    }

    @Test
    void initializedTreeMultipleValues() {
        FenwickTreeRange t = new FenwickTreeRange(10);

        t.add(2, 5, 5);
        t.add(4, 8, 2);
        t.add(7, 8, 20);

        assertEquals(0, t.readSingle(1));
        assertEquals(5, t.readSingle(2));
        assertEquals(5, t.readSingle(3));
        assertEquals(7, t.readSingle(4));
        assertEquals(7, t.readSingle(5));
        assertEquals(2, t.readSingle(6));
        assertEquals(22, t.readSingle(7));
        assertEquals(22, t.readSingle(8));
        assertEquals(0, t.readSingle(9));

        assertEquals(0, t.read(1));
        assertEquals(5, t.read(2));
        assertEquals(10, t.read(3));
        assertEquals(17, t.read(4));
        assertEquals(24, t.read(5));
        assertEquals(26, t.read(6));
        assertEquals(48, t.read(7));
        assertEquals(70, t.read(8));
        assertEquals(70, t.read(9));
    }
}
