/**
 * 155. Min Stack
 * 双栈法不一定getMin()最快，但是所有操作平均速度应该是很快的
 */
public class Solution {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.printStack();
        minStack.push(0);
        minStack.printStack();
        minStack.push(-3);
        minStack.printStack();
        System.out.println("min:" + minStack.getMin()); // return -3
        minStack.pop();
        minStack.printStack();
        System.out.println("top:" + minStack.top()); // return 0
        System.out.println("min:" + minStack.getMin());// return -2
    }
}