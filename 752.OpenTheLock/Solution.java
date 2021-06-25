import java.util.*;

/**
 * 752. Open the Lock
 * Medium
 */
public class Solution {

    private char pre(char c) {
        return c == '0' ? '9' : (char) (c - 1);
    }

    private char next(char c) {
        return c == '9' ? '0' : (char) (c + 1);
    }

    private List<String> nextStatus(String code) {
        List<String> next = new ArrayList<>();
        char[] sc = code.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            char t = sc[i];
            sc[i] = pre(t);
            next.add(new String(sc));
            sc[i] = next(t);
            next.add(new String(sc));
            sc[i] = t;
        }
        return next;
    }

    public int openLock(String[] deadends, String target) {
        if ("0000".equals(target)) {
            return 0;
        }
        Set<String> dead = new HashSet<>();
        for (String d : deadends) {
            dead.add(d);
        }
        if (dead.contains("0000")) {
            return -1;
        }
        Deque<String> queue = new LinkedList<>();
        queue.offer("0000");
        int step = 0;
        Set<String> seen = new HashSet<String>();
        seen.add("0000");
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String status = queue.poll();
                for (String n : nextStatus(status)) {
                    if (!seen.contains(n) && !dead.contains(n)) {
                        if (n.equals(target)) {
                            return step;
                        }
                        queue.offer(n);
                        seen.add(n);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[][] deadends = { { "0201", "0101", "0102", "1212", "2002" }, { "8888" },
                { "8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888" }, { "0000" } };
        String[] target = { "0202", "0009", "8888", "8888" };
        Solution s = new Solution();
        for (int i = 0; i < target.length; i++) {
            System.out.println(s.openLock(deadends[i], target[i]));
        }
    }
}
