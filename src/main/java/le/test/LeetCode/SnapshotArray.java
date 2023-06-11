package le.test.LeetCode;

import java.util.TreeMap;

public class SnapshotArray {
    TreeMap<Integer, Integer>[] snaps;
    int counter = 0;

    public SnapshotArray(int length) {
        snaps = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            snaps[i] = new TreeMap<Integer, Integer>();
            snaps[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        snaps[index].put(counter, val);
    }

    public int snap() {
        return counter++;
    }

    public int get(int index, int snapId) {
        return snaps[index].floorEntry(snapId).getValue();
    }
}