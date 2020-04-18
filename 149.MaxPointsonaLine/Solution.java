import java.io.*;
import java.util.*;

/**
 * 149. Max Points on a Line
 */
class Solution {
    // 最大公约数
    private int getGcd(int a, int b) {
        return b == 0 ? a : getGcd(b, a % b);
    }

    public int maxPoints(int[][] points) {
        if (points.length <= 2)
            return points.length;
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            int duplicate = 1, m = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                int y = points[j][1] - points[i][1];
                int x = points[j][0] - points[i][0];
                if (x == 0 && y == 0) { // 重复的点也在线上
                    duplicate++;
                    continue;
                }
                int gcd = getGcd(x, y);
                y /= gcd;
                x /= gcd;
                String key = y + "/" + x; // 分数做键，避免精度问题
                int pointNum = map.getOrDefault(key, 0) + 1;
                map.put(key, pointNum);
                m = Math.max(m, pointNum);
            }
            max = Math.max(max, m + duplicate);
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        File f = new File("input.txt");
        Scanner scan = new Scanner(f);
        while (scan.hasNextLine()) {
            String in = scan.nextLine();
            String[] pairs = new String[0];
            if (in.length() > 2)
                pairs = in.substring(2, in.length() - 2).split("\\],\\[");
            int[][] points = new int[pairs.length][2];
            for (int i = 0; i < points.length; i++) {
                String[] nums = pairs[i].split(",");
                points[i][0] = Integer.parseInt(nums[0]);
                points[i][1] = Integer.parseInt(nums[1]);
            }
            System.out.println(s.maxPoints(points));
        }
        scan.close();
    }
}