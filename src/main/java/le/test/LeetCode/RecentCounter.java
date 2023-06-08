package le.test.LeetCode;

import java.util.Queue;
import java.util.LinkedList;

class RecentCounter {
    private Queue<Integer> calls;

    public RecentCounter() {
        calls = new LinkedList<>();
    }

    public int ping(int t) {
        calls.add(t);

        while (calls.peek() < t - 3000)
            calls.poll();

        return calls.size();
    }
}