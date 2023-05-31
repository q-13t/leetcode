package le.test;

import java.util.Arrays;

public class SmallestInfiniteSet {
    int[] hash = new int[1001];

    public SmallestInfiniteSet() {
        Arrays.fill(hash, 1);
    }

    public int popSmallest() {
        for (int i = 1; i < 1001; i++)
            if (hash[i] == 1) {
                hash[i] = 0;
                return i;
            }
        return -1;
    }

    public void addBack(int num) {
        hash[num] = 1;
    }
}