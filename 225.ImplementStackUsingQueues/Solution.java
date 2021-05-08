import java.util.Deque;
import java.util.LinkedList;

/**
 * 225. Implement Stack using Queues
 * Easy
 */
class MyStack {

    private Deque<Integer> q1;
    private Deque<Integer> q2;
    int cur = 0;


    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if (cur == 0) {
            q1.offer(x);
            while (!q2.isEmpty()) {
                q1.offer(q2.poll());
            }
        } else {
            q2.offer(x);
            while (!q1.isEmpty()) {
                q2.offer(q1.poll());
            }
        }
        cur = 1 - cur;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (cur == 0) {
            return q2.poll();
        } else {
            return q1.poll();
        }
    }
    
    /** Get the top element. */
    public int top() {
        if (cur == 0) {
            return q2.peek();
        } else {
            return q1.peek();
        }
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        if (cur == 0) {
            return q2.isEmpty();
        } else {
            return q1.isEmpty();
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        // Your MyStack object will be instantiated and called as such:
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        int param_3 = obj.top();
        System.out.println(param_3);
        int param_2 = obj.pop();
        System.out.println(param_2);
        boolean param_4 = obj.empty();
        System.out.println(param_4);
    }
}
