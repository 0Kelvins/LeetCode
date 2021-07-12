import java.util.*;

/**
 * 981. Time Based Key-Value Store
 * Medium
 * 偷懒了，应该用Map+ArrayList，时间查找用二分
 */
class TimeMap {

    private Map<String, TreeMap<Integer, String>> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> tMap = map.getOrDefault(key, new TreeMap<>());
        tMap.put(timestamp, value);
        map.put(key, tMap);
    }
    
    public String get(String key, int timestamp) {
        if (map.containsKey(key)) {
            TreeMap<Integer, String> tMap = map.get(key);
            Integer prev = tMap.floorKey(timestamp);
            if (prev != null) {
                return tMap.get(prev);
            }
            return "";
        }
        return "";
    }
}

public class Solution {

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1.
        System.out.println(timeMap.get("foo", 1)); // return "bar"
        System.out.println(timeMap.get("foo", 3)); // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "ba2r" along with timestamp = 4.
        System.out.println(timeMap.get("foo", 4)); // return "bar2"
        System.out.println(timeMap.get("foo", 5)); // return "bar2"
        
        TimeMap timeMap2 = new TimeMap();
        timeMap2.set("love", "high", 10);
        timeMap2.set("love", "low", 20);
        timeMap2.set("love", "high", 10);
        System.out.println("\"" + timeMap2.get("love", 5) + "\""); // return ""
        System.out.println(timeMap2.get("love", 10)); // return "high"
        System.out.println(timeMap2.get("love", 15)); // return "high"
        System.out.println(timeMap2.get("love", 20)); // return "low"
        System.out.println(timeMap2.get("love", 25)); // return "low"
    }
}