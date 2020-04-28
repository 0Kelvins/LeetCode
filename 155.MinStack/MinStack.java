import java.util.LinkedList;

class MinStack {
    private LinkedList<Integer> s;
    private LinkedList<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        s = new LinkedList<>();
        min = new LinkedList<>();
        min.add(Integer.MAX_VALUE);
    }

    public void push(int x) {
        s.addLast(x);
        min.addLast(x < min.getLast() ? x : min.getLast());
    }

    public void pop() {
        s.removeLast();
        min.removeLast();
    }

    public int top() {
        return s.getLast();
    }

    public int getMin() {
        return min.getLast();
    }

    public void printStack() {
        System.out.println(s.toString());
    }
}
