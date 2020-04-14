import java.util.*;

/**
 * 146. LRU Cache
 * 链表还是要自己用实现个双向链表优化删除和尾插才能快，我就不具体再写了
 */
class Solution {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));// returns 1
        cache.put(3, 3); // evicts key 2
        System.out.println(cache.get(2));// returns -1 (not found)
        cache.put(4, 4); // evicts key 1
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
        cache.put(4, 5); // evicts key 1
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 5
    }
}

class LRUCache {
    private Map<Integer, Integer> cache;
    private List<Integer> priority;
    private int capacity;
    private int used;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.used = 0;
        this.cache = new HashMap<>();
        this.priority = new LinkedList<>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            priority.remove((Integer) key);
            priority.add(key);
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key))
            priority.remove((Integer) key);
        else if (used < capacity)
            used++;
        else {
            Integer rm = priority.get(0);
            cache.remove(rm);
            priority.remove(rm);
        }
        cache.put(key, value);
        priority.add(key);
        // System.out.println(priority.toString());
    }
}