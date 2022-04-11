import java.util.Stack;

class MinStack {

    private Stack<Integer> valueStack;
    private Stack<Integer> minStack;

    public MinStack() {
        valueStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if (minStack.isEmpty() || val <= getMin()) {
            minStack.push(val);
        }
        valueStack.push(val);
    }

    public void pop() {
        if (valueStack.peek() == getMin()) {
            minStack.pop();
        }
        valueStack.pop();
    }

    public int top() {
        return valueStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */