import java.util.*;

/**
 * 59 - II. 队列的最大值
 * Medium
 * 这题和前一题一个思路，被Integer的相等运算坑了手
 */
class MaxQueue {

    private Deque<Integer> queue;
    private Deque<Integer> maxQueue;    // 维护最大值的队列

    public MaxQueue() {
        queue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }
    
    public int max_value() {
        return maxQueue.isEmpty() ? -1 : maxQueue.peek();
    }
    
    public void push_back(int value) {
        queue.offer(value);
        while (!maxQueue.isEmpty() && maxQueue.getLast() < value) {
            maxQueue.removeLast();  // 插入值将代替前面的较小值成为最大值
        }
        maxQueue.offer(value);
    }
    
    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        
        int peek = queue.poll();
        if(peek == maxQueue.peek()) { // 两个Integer不能用 == ，而且equals比较慢
            maxQueue.poll();
        }
        return peek;
    }
}

public class Solution {
    public static void main(String[] args) {
        MaxQueue obj = new MaxQueue();
        System.out.println(obj.max_value()); // -1
        obj.push_back(1);
        System.out.println(obj.max_value()); // 1
        obj.push_back(2);
        System.out.println(obj.max_value()); // 2
        System.out.println(obj.pop_front()); // 1
        System.out.println(obj.max_value()); // 2
        System.out.println();

        MaxQueue obj2 = new MaxQueue();
        System.out.println(obj2.pop_front()); // -1
        System.out.println(obj2.max_value()); // -1
        System.out.println();

        MaxQueue obj3 = new MaxQueue();
        obj3.push_back(868);
        System.out.println(obj3.pop_front()); // 868
        System.out.println(obj3.pop_front()); // -1
        System.out.println(obj3.pop_front()); // -1
        obj3.push_back(525);
        System.out.println(obj3.pop_front()); // 525
        System.out.println(obj3.max_value()); // -1
    }
}
