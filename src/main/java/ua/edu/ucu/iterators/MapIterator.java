package ua.edu.ucu.iterators;

import ua.edu.ucu.function.IntPredicate;
import ua.edu.ucu.function.IntUnaryOperator;

import java.util.Iterator;

public class MapIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private IntUnaryOperator mapper;
    private int i = 0;
    private int value;

    public MapIterator(Iterator<Integer> mainIterator, IntUnaryOperator mapper) {
        this.iterator = mainIterator;
        this.mapper = mapper;
    }
    @Override
    public boolean hasNext() {
        return iterator.hasNext();
        // must be changed
    }

    @Override
    public Integer next() {
        int next = iterator.next();
        return mapper.apply(next);
//        return value;
    }

    public static void main(String[] args) {
        MainIterator iter = new MainIterator(6,9,2);
        MapIterator filter = new MapIterator(iter, x -> x + 2);
        for (Iterator<Integer> it = filter; it.hasNext(); ) {
            Integer el = it.next();
            System.out.println("element: " + el);
        }

    }
}
