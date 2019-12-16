package ua.edu.ucu;

import ua.edu.ucu.stream.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class AsIntStreamTest {
    private IntStream intStream;

    @Before
    public void init() {
        intStream = AsIntStream.of(-1, 0, 1, 2, 3);
    }

    @Test
    public void testAverage() {
        double expResult = 1.0;
        double result = intStream.average();
        assertEquals(expResult, result, 0.001);
    }

    @Test
    public void testMax() {
        int expResult = 3;
        int result = intStream.max();
        assertEquals(expResult, result);
    }

    @Test
    public void testMin() {
        int expResult = -1;
        int result = intStream.min();
        assertEquals(expResult, result);
    }

    @Test
    public void testCount() {
        int expResult = 5;
        long result = intStream.count();
        assertEquals(expResult, result);
    }

    @Test
    public void testSum() {
        int expResult = 5;
        long result = intStream.sum();
        assertEquals(expResult, result);
    }

    @Test
    public void testToArray() {
        int[] expResult = {-1, 0, 1, 2, 3};
        int[] result = intStream.toArray();
        assertArrayEquals(expResult, result);
    }
}
