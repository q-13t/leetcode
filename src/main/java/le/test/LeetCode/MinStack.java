package le.test.LeetCode;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;
    private int minElement;

    public MinStack() {
        this.minElement = Integer.MAX_VALUE;
        this.mainStack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }

    public void push(int val) {
        if (minElement > val || mainStack.isEmpty()) {
            minElement = val;
        }
        minStack.add(minElement);
        mainStack.add(val);
    }

    public void pop() {
        mainStack.pop();
        minStack.pop();
        if (minStack.isEmpty()) {
            minElement = Integer.MAX_VALUE;
        } else {
            minElement = minStack.peek();
        }
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}