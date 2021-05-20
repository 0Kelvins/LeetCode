import java.util.Deque;
import java.util.LinkedList;

/**
 * 232. Implement Queue using Stacks
 * Easy
 */
class MyQueue {

    private Deque<Integer> in;
    private Deque<Integer> out;

    /** Initialize your data structure here. */
    public MyQueue() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }
    
    private void isOutEmpty() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        isOutEmpty();
        return out.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        isOutEmpty();
        return out.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}

public class Solution {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
        myQueue.push(3);
        System.out.println(myQueue.pop()); // return 2
        System.out.println(myQueue.peek()); // return 3
        System.out.println(myQueue.pop()); // return 3
    }
}
