package demo.parallel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComplexTest {

    @Test
    public void testPlus() {
        Complex a = new Complex(2.0, 3.0);
        Complex b = new Complex(1.0, 2.0);

        a.plus(b);

        assertEquals(3.0, a.getRe(), 0.0001);
        assertEquals(5.0, a.getIm(), 0.0001);
    }

    @Test
    public void testTimes() {
        Complex a = new Complex(2.0, 3.0);
        Complex b = new Complex(1.0, 2.0);

        a.times(b);

        // (2+3i)*(1+2i) = 2*1 + 2*2i + 3i*1 + 3i*2i = 2 + 4i + 3i + 6i² = 2 + 7i - 6 = -4 + 7i
        assertEquals(-4.0, a.getRe(), 0.0001);
        assertEquals(7.0, a.getIm(), 0.0001);
    }

    @Test
    public void testDiv() {
        Complex a = new Complex(4.0, 6.0);
        Complex b = new Complex(2.0, 2.0);

        a.div(b);

        // (4+6i)/(2+2i) = (4+6i)*(2-2i)/(4+4) = (8-8i+12i-12i²)/8 = (8+4i+12)/8 = (20+4i)/8 = 2.5 + 0.5i
        assertEquals(2.5, a.getRe(), 0.0001);
        assertEquals(0.5, a.getIm(), 0.0001);
    }

    @Test
    public void testSin() {
        Complex a = new Complex(Math.PI/2, 0.0); // sin(π/2) = 1

        a.sin();

        assertEquals(1.0, a.getRe(), 0.0001);
        assertEquals(0.0, a.getIm(), 0.0001);
    }

    @Test
    public void testLengthSQ() {
        Complex a = new Complex(3.0, 4.0);

        double lengthSQ = a.lengthSQ();

        assertEquals(25.0, lengthSQ, 0.0001); // 3² + 4² = 9 + 16 = 25
    }

    @Test
    public void testConstructorAndGetters() {
        Complex a = new Complex(5.0, 7.0);

        assertEquals(5.0, a.getRe(), 0.0001);
        assertEquals(7.0, a.getIm(), 0.0001);
    }

    @Test
    public void testDivisionByZeroComplex() {
        Complex a = new Complex(1.0, 1.0);
        Complex b = new Complex(0.0, 0.0);

        // This should not throw an exception due to division by zero
        // The result should be NaN or Infinity, but the current implementation doesn't handle this case
        assertDoesNotThrow(() -> a.div(b));
    }

    @Test
    public void testChainedOperations() {
        Complex result = new Complex(1.0, 2.0)
                .plus(new Complex(3.0, 4.0))
                .times(new Complex(2.0, 1.0));

        // (1+2i + 3+4i) * (2+i) = (4+6i) * (2+i) = 8+4i+12i+6i² = 8+16i-6 = 2+16i
        assertEquals(2.0, result.getRe(), 0.0001);
        assertEquals(16.0, result.getIm(), 0.0001);
    }
}