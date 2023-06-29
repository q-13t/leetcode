package le.test.LeetCode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.junit.Test;

public class PairTest {
    @Test
    public void testEquals() {
        assertTrue(new Pair<Integer, Integer>(0, 1).equals(new Pair<Integer, Integer>(0, 1)));
        assertTrue(new Pair<Integer, Integer>(2, 1).equals(new Pair<Integer, Integer>(2, 1)));
        assertFalse(new Pair<Integer, Integer>(0, 0).equals(new Pair<Integer, Integer>(0, 1)));
        assertFalse(new Pair<Integer, Character>(0, '0').equals(new Pair<Integer, Integer>(0, 1)));
        assertFalse(new Pair<Integer, Character>(0, '0').equals(new LinkedList<Integer>()));
    }
}
