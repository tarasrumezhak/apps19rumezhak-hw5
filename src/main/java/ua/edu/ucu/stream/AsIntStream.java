package ua.edu.ucu.stream;

import ua.edu.ucu.function.*;
import ua.edu.ucu.iterators.FilterIterator;
import ua.edu.ucu.iterators.FlatMapIterator;
import ua.edu.ucu.iterators.MainIterator;
import ua.edu.ucu.iterators.MapIterator;
import java.util.ArrayList;
import java.util.Iterator;

public class AsIntStream implements IntStream {
    private Iterator<Integer> elementsIterator;

    private AsIntStream(Iterator<Integer> iterator) {
        elementsIterator = iterator;
    }

    public static IntStream of(int... values) {
        return new AsIntStream(new MainIterator(values));
    }

    private void checkIfEmpty() {
        if (!elementsIterator.hasNext()) throw new IllegalArgumentException();
    }

    @Override
    public Double average() {
        checkIfEmpty();
        int sum = 0;
        int size = 0;
        while (elementsIterator.hasNext()) {
            size++;
            sum += elementsIterator.next();
        }
        return (double) (sum / size);
    }

    @Override
    public Integer max() {
        checkIfEmpty();
        int max = 0;
        while (elementsIterator.hasNext()) {
            int next = elementsIterator.next();
            if (next > max) max = next;
        }
        return max;
    }

    @Override
    public Integer min() {
        checkIfEmpty();
        int min = Integer.MAX_VALUE;
        while (elementsIterator.hasNext()) {
            int next = elementsIterator.next();
            if (next < min) min = next;
        }
        return min;
    }

    @Override
    public long count() {
        long size = 0;
        while (elementsIterator.hasNext()) {
            size++;
            elementsIterator.next();
        }
        return size;
    }

    @Override
    public Integer sum() {
        checkIfEmpty();
        return reduce(0, (sum, x) -> sum += x);
    }

    @Override
    public IntStream filter(IntPredicate predicate) {
        return new AsIntStream(new FilterIterator(elementsIterator, predicate));
    }

    @Override
    public void forEach(IntConsumer action) {
        for (Iterator<Integer> it = elementsIterator; it.hasNext(); ) {
            Integer el = it.next();
            action.accept(el);
        }
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
        return new AsIntStream(new MapIterator(elementsIterator, mapper));
    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {
        return new AsIntStream(new FlatMapIterator(elementsIterator, func));
    }

    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        for (Iterator<Integer> it = elementsIterator; it.hasNext(); ) {
            Integer el = it.next();
            identity = op.apply(identity, el);
        }
        return identity;
    }

    @Override
    public int[] toArray() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Iterator<Integer> it = elementsIterator; it.hasNext(); ) {
            Integer value = it.next();
            arrayList.add(value);
        }
        int[] result = new int[arrayList.size()];
        int i = 0;
        for (Integer el: arrayList) {
            result[i++] = el;
        }
        return result;
    }
}
