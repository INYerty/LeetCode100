package Test.B_medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class T155 {
    class MinStack {
        private Deque<Integer> dataStack;
        private Deque<Integer> minStack;

        public MinStack() {
            dataStack = new ArrayDeque<>();
            minStack = new ArrayDeque<>();
        }

        public void push(int val) {
            dataStack.push(val);
            if (minStack.isEmpty()) {
                minStack.push(val);
            } else {
                if (val < minStack.peek()) {
                    minStack.push(val);
                } else {
                    minStack.push(minStack.peek());
                }
            }
        }

        public void pop() {
            // 两栈必须同步弹出 [ref_2]
            dataStack.pop();
            minStack.pop();
        }

        public int top() {
            return dataStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
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
