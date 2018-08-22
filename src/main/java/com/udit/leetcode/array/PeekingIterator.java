package com.udit.leetcode.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class PeekingIterator implements Iterator<Integer> {

    private Integer next;
    private Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (iterator.hasNext()) {
            this.next = iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer peek = peek();
        if (iterator.hasNext()) {
            this.next = iterator.next();
        } else {
            this.next = null;
        }
        return peek;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}
