import java.util.*;

/**
 * 295. Find Median from Data Stream
 * Hard
 * 这题做出来不难，就是优化有点难
 */
class MedianFinder {

    private List<Integer> list;

    public MedianFinder() {
        this.list = new ArrayList<>();
    }

    public void addNum(int num) {
        if (list.size() == 0 || num >= list.get(list.size() - 1)) {
            list.add(num);
        } else {
            int i = 0, j = list.size() - 1;
            while (i < j) {
                int m = (i + j) / 2;
                int t = list.get(m);
                if (t > num) {
                    j = m;
                } else if (t < num) {
                    i = m + 1;
                } else {
                    list.add(m, num);
                    return;
                }
            }
            list.add(i, num);
        }
    }

    public double findMedian() {
        int n = list.size();
        if (n == 0)
            return 0;
        return n % 2 == 0 ? (double) (list.get(n / 2 - 1) + list.get(n / 2)) / 2 : list.get(n / 2);
    }
}

/**
 * 双堆（优先队列），还可以用自平衡二叉搜索树
 */
class MedianFinder1 {

    private int count;
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    MedianFinder1() {
        count = 0;
        maxHeap = new PriorityQueue<>((x, y)-> y - x);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        count++;
        maxHeap.add(num);
        minHeap.add(maxHeap.remove());
        if (minHeap.size() > maxHeap.size())
            maxHeap.add(minHeap.remove());
    }

    public double findMedian() {
        return count % 2 == 0 ? (double) (maxHeap.peek() + minHeap.peek()) / 2 : maxHeap.peek();
    }
}

public class Solution {
    public static void main(String[] args) {
        MedianFinder1 obj = new MedianFinder1();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
        obj.addNum(2);
        System.out.println(obj.findMedian());
        System.out.println();

        MedianFinder1 obj1 = new MedianFinder1();
        obj1.addNum(6);
        System.out.println(obj1.findMedian());
        obj1.addNum(10);
        System.out.println(obj1.findMedian());
        obj1.addNum(2);
        System.out.println(obj1.findMedian());
        obj1.addNum(5);
        System.out.println(obj1.findMedian());
        obj1.addNum(0);
        System.out.println(obj1.findMedian());
    }
}
