package ua.edu.ucu.iterators;

import ua.edu.ucu.function.IntPredicate;
import ua.edu.ucu.function.IntUnaryOperator;

import java.util.Iterator;

public class MapIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private IntUnaryOperator mapper;

    public MapIterator(Iterator<Integer> mainIterator, IntUnaryOperator mapper) {
        this.iterator = mainIterator;
        this.mapper = mapper;
    }
    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Integer next() {
        int next = iterator.next();
        return mapper.apply(next);
    }
}
