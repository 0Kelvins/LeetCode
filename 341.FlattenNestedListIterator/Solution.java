import java.util.*;

/**
 * 341. Flatten Nested List Iterator
 * 栈存迭代器的方法就很没想到，一开始想用栈迭代，但是被存列表和下标弄得太麻烦了
 * 直接嵌套存NestedIterator自身也是很好的方法
 */
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> flattenList;
    private Integer index;

    public NestedIterator(List<NestedInteger> nestedList) {
        flattenList = new LinkedList<>();
        flatten(nestedList);
        index = 0;
    }
    
    private void flatten(List<NestedInteger> list) {
        for (NestedInteger i : list) {
            if (i.isInteger())
                flattenList.add(i.getInteger());
            else
                flatten(i.getList());
        }
    }

    @Override
    public Integer next() {
        return flattenList.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < flattenList.size();
    }
}

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
public interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */