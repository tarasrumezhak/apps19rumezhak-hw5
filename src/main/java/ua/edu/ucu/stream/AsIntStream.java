package ua.edu.ucu.stream;

import ua.edu.ucu.function.*;
import ua.edu.ucu.iterators.FilterIterator;
import ua.edu.ucu.iterators.MainIterator;
import ua.edu.ucu.iterators.MapIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class AsIntStream implements IntStream {
    private Iterator<Integer> elementsIterator;

    private AsIntStream() {
    }

    private AsIntStream(Iterator<Integer> iterator) {
        elementsIterator = iterator;
    }

    public static IntStream of(int... values) {
        return new AsIntStream(new MainIterator(values));
    }

    @Override
    public Double average() {
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
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        if (!elementsIterator.hasNext()) {
//            throw new IllegalArgumentException();
//        }
        int max = 0;
        while (elementsIterator.hasNext()) {
            int next = elementsIterator.next();
            if (next > max) max = next;
        }
        return max;
    }

    public static void main(String[] args) {
        IntStream intStream = AsIntStream.of(-1, 0, 1, 2, 3);
//        intStream.filter(x -> x > 1).forEach(System.out::println);
        int[] res = intStream.filter(x -> x > 1).map(x -> x * 2).toArray();
        System.out.println(Arrays.toString(res));
    }

    @Override
    public Integer min() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int min = Integer.MAX_VALUE;
        while (elementsIterator.hasNext()) {
            int next = elementsIterator.next();
            if (next < min) min = next;
        }
        return min;
    }

    @Override
    public long count() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        long size = 0;
        while (elementsIterator.hasNext()) {
            size++;
            elementsIterator.next();
        }
        return size;
    }

    @Override
    public Integer sum() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int sum = 0;
        while (elementsIterator.hasNext()) {
            sum += elementsIterator.next();
        }
        return sum;
    }

    @Override
    public IntStream filter(IntPredicate predicate) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return new AsIntStream(new FilterIterator(elementsIterator, predicate));
    }

    @Override
    public void forEach(IntConsumer action) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for (Iterator<Integer> it = elementsIterator; it.hasNext(); ) {
            Integer el = it.next();
            System.out.println("element: " + el);
            action.accept(el);
        }
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return new AsIntStream(new MapIterator(elementsIterator, mapper));
    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[] toArray() {
//        System.out.println("To array");
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Iterator<Integer> it = elementsIterator; it.hasNext(); ) {
            Integer value = it.next();
            arrayList.add(value);
        }
        int[] result = new int[arrayList.size()];
        int i = 0;
        for (Integer el: arrayList) {
            result[i++] = el;
        };
        return result;
    }

}
