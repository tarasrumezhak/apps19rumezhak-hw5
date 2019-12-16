package ua.edu.ucu.stream;

import ua.edu.ucu.function.*;

import java.util.ArrayList;

public class AsIntStream implements IntStream {
    private static int[] elements;
    private static int sum;
    private static int max = 0;
    private static int min = Integer.MAX_VALUE;
    private static int count = 0;

    private AsIntStream(int[] els, int sum, int max, int min, int count) {
        elements = els;
        this.sum = sum;
        this.max = max;
        this.min = min;
        this.count = count;
    }

    public static IntStream of(int... values) {
//        ArrayList<Integer> els = new ArrayList<>();
        int[] els = new int[values.length];
        int sum = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        int count = values.length;
        for (int i=0; i < count; i++) {
//            els.add(value);
            els[i] = values[i];
            sum += values[i];
            if (max < values[i]) max = values[i];
            if (min > values[i]) min = values[i];
        }
        return new AsIntStream(els, sum, max, min, count);
    }

    @Override
    public Double average() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (count == 0) throw new IllegalArgumentException();
        return (double) (sum / count);
    }

    @Override
    public Integer max() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (count == 0) throw new IllegalArgumentException();
        return max;
    }

    @Override
    public Integer min() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (count == 0) throw new IllegalArgumentException();
        return min;
    }

    @Override
    public long count() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return count;
    }

    @Override
    public Integer sum() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (count == 0) throw new IllegalArgumentException();
        return sum;
    }

    @Override
    public IntStream filter(IntPredicate predicate) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int[] els = new int[count];
        int counter = 0;
        int suma = 0;
        int maxx = 0;
        int minn = Integer.MAX_VALUE;
        for (int i = 0; i < count; i++) {
            if(predicate.test(elements[i])) {
                els[counter] = elements[i];
                counter++;
                suma += elements[i];
                if (max < elements[i]) max = elements[i];
                if (min > elements[i]) min = elements[i];
            }
        }
        return new AsIntStream(els, suma, maxx, minn, counter);
    }

    @Override
    public void forEach(IntConsumer action) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return elements;
    }

}
