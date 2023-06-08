package le.test.LeetCode;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomizedSet {
    private Set<Integer> set = new HashSet<Integer>();
    private static Random rand = new Random();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        return set.add(val);
    }

    public boolean remove(int val) {
        return set.remove(val);
    }

    public int getRandom() {
        return (int) set.toArray()[rand.nextInt(set.size())];
    }
}