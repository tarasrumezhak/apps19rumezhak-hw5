package ua.edu.ucu.iterators;

import ua.edu.ucu.stream.IntStream;

import java.util.ArrayList;
import java.util.Iterator;

public class MainIterator implements Iterator<Integer> {
    private ArrayList elements = new ArrayList();
    private int i = 0;

    public MainIterator(int... values) {
        for (Integer value: values) {
            elements.add(value);
        }
    }

    @Override
    public boolean hasNext() {
        return elements.size() > i;
    }

    @Override
    public Integer next() {
        return (Integer) elements.get(i++);
    }

}
