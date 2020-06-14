import static org.junit.Assert.*;

import org.junit.Test;

public class FlikTest {
    @Test
    public void testEqual127() {
        int i = 127;
        int j = 127;
        assertTrue(Flik.isSameNumber(i, j));
    }

    @Test
    public void testEqual128() {
        int i = 128;
        int j = 128;
        assertTrue(Flik.isSameNumber(i, j));
    }
}