package ua.edu.ucu.iterators;

import ua.edu.ucu.function.IntPredicate;

import java.util.ArrayList;
import java.util.Iterator;

public class FilterIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private IntPredicate predicate;
    private int i = 0;
    private int value;

    public FilterIterator(Iterator<Integer> mainIterator, IntPredicate predicate) {
        this.iterator = mainIterator;
        this.predicate = predicate;
    }
    @Override
    public boolean hasNext() {
        while (iterator.hasNext()) {
            value = iterator.next();
            if (predicate.test(value)) {
                return true;
            }
        }
        return false;
        // must be changed
    }

    @Override
    public Integer next() {
//        System.out.println("Filter");
//        i++;
//        int next = iterator.next();
//        while (!(predicate.test(next))) {
//            i++;
//        }
//        return next;
        return value;
    }

    public static void main(String[] args) {
        MainIterator iter = new MainIterator(6,9,2);
        FilterIterator filter = new FilterIterator(iter, x -> x > 2);
        for (Iterator<Integer> it = filter; it.hasNext(); ) {
            Integer el = it.next();
            System.out.println("element: " + el);
        }

    }
}
