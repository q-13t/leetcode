package le.test.LeetCode;

import java.util.*;

public class LRUCache {
    LinkedHashMap<Integer, Integer> map;
    int size;

    public LRUCache(int capacity) {
        size = capacity;
        map = new LinkedHashMap<>(capacity, 1F, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > size;
            };
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}