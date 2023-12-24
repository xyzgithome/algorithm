package com.focus.leetcode.number_42;

public class Data {
    private int height;
    private int i;

    public Data(int height, int i) {
        this.height = height;
        this.i = i;
    }

    public int getHeight() {
        return height;
    }

    public int getI() {
        return i;
    }

    @Override
    public String toString() {
        return "Data{" +
                "height=" + height +
                ", i=" + i +
                '}';
    }
}
