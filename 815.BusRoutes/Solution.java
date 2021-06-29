import java.util.*;

/**
 * 815. Bus Routes
 * Hard
 */
public class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        Map<Integer, List<Integer>> stopMap = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                List<Integer> rs = stopMap.getOrDefault(routes[i][j], new ArrayList<>());
                rs.add(i);
                stopMap.put(routes[i][j], rs);
            }
        }
        Map<Integer, Integer> dis = new HashMap<>(); // current route distance
        Deque<Integer> queue = new LinkedList<>();
        for (Integer r : stopMap.get(source)) {
            queue.offer(r);
            dis.put(r, 1);
        }
        while (!queue.isEmpty()) {
            int r = queue.poll();
            int d = dis.get(r);
            for (int s : routes[r]) {
                if (s == target) {
                    return d;
                }
                for (Integer nr : stopMap.get(s)) {
                    if (!dis.containsKey(nr)) {
                        dis.put(nr, d + 1);
                        queue.offer(nr);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][][] routes = { { { 1, 2, 7 }, { 3, 6, 7 } },
                { { 7, 12 }, { 4, 5, 15 }, { 6 }, { 15, 19 }, { 9, 12, 13 } } };
        int[] source = { 1, 15 };
        int[] target = { 6, 12 };
        Solution s = new Solution();
        for (int i = 0; i < target.length; i++) {
            System.out.println(s.numBusesToDestination(routes[i], source[i], target[i]));
        }
    }
}
