package com.example;

public class pactDemo {

    private int value;

    public pactDemo() {
    }

    public pactDemo(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        pactDemo pactDemo = (pactDemo) o;

        if (value != pactDemo.value) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
