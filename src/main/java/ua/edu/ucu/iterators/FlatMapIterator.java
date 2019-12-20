package ua.edu.ucu.iterators;

import ua.edu.ucu.function.IntToIntStreamFunction;
import ua.edu.ucu.stream.AsIntStream;

import java.util.*;

public class FlatMapIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private IntToIntStreamFunction operator;
    private MainIterator internalIterator;

    public FlatMapIterator(Iterator<Integer> mainIterator, IntToIntStreamFunction operator) {
        this.iterator = mainIterator;
        this.operator = operator;
        this.internalIterator = new MainIterator();
    }

    @Override
    public boolean hasNext() {
        if (internalIterator.hasNext()) {
            return true;
        }
        if (iterator.hasNext()) {
            AsIntStream tempStream = (AsIntStream) operator.applyAsIntStream(iterator.next());
            internalIterator = new MainIterator(tempStream.toArray());
            return true;
        }
        return false;
    }

    @Override
    public Integer next() {
        return internalIterator.next();
    }
}
