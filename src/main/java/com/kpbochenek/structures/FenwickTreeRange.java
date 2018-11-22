package com.kpbochenek.structures;

public class FenwickTreeRange {
    FenwickTree F1;
    FenwickTree F2;

    /**
     * Tree indexed from 1.
     * Size is a number of elements stored in a tree. In range [1 .. size] inclusive!
     */
    public FenwickTreeRange(int size) {
        F1 = new FenwickTree(size);
        F2 = new FenwickTree(size);
    }

    public void add(int left, int right, int value) {
        F1.add(left, value);
        F1.add(right + 1, -value);
        F2.add(left, value * (left-1));
        F2.add(right + 1, -value * right);
    }

    public long readSingle(int idx) {
        return read(idx) - read(idx-1);
    }

    public long read(int idx) {
        return F1.read(idx) * idx - F2.read(idx);
    }

    public long readRange(int left, int right) {
        return read(right) - read(left-1);
    }

}
