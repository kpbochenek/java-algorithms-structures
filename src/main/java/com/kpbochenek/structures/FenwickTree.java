package com.kpbochenek.structures;

/**
 * Tree used to store sum values.
 * Value in given index represents sum of all values to this index and all index.
 * Tree only handling non-negative values.
 *
 */
public class FenwickTree {
    private long[] array;

    /**
     * Tree indexed from 1.
     * Size is a number of elements stored in a tree. In range [1 .. size] inclusive!
     */
    public FenwickTree(int size) {
        array = new long[size + 1];
    }

    /**
     * Returns a value at given idx.
     * Value represents sum of elements [1 .. idx] inclusive!
     */
    public long read(int idx) {
        long sum = 0;
        while (idx > 0) {
            sum += array[idx];
            idx -= (idx & (-idx));
        }
        return sum;
    }

    /**
     * Returns number of elements explicitly added at this given idx.
     */
    public long readSingle(int idx) {
        return read(idx) - read(idx - 1);
    }

    /**
     * Returns sum of elements added in range [a .. b] inclusive!
     */
    public long readRange(int a, int b) {
        return read(a) - read(b-1);
    }

    public void scaleDown(int value) {
        for (int i=1; i<array.length; ++i) {
            array[i] = array[i] / value;
        }
    }

    public void scaleUp(int value) {
        for (int i=1; i<array.length; ++i) {
            array[i] = array[i] * value;
        }
    }

    /**
     * Adds 'value' to defined 'idx'.
     */
    public void add(int idx, long value) {
        while (idx < array.length) {
            array[idx] += value;
            idx += (idx & (-idx));
        }
    }


}
