
/**
 * 剑指 Offer 13. 机器人的运动范围
 * 找半天规律没找清楚，看到官方PPT豁然开朗。
 * DFS解的
 */
public class Solution {

    // 求位数和
    private int sumBits(int a) {
        int s = 0;
        while (a > 0) {
            s += (a % 10);
            a /= 10;
        }
        return s;
    }

    private int move(int m, int n, int k, int i, int j, int[][] flag) {
        if (i < 0 || j < 0 || i == m || j == n || flag[i][j] == 1)  // 边界及访问判断
            return 0;
        flag[i][j] = 1;

        int q = sumBits(i) + sumBits(j);
        if (q > k)
            return 0;
            
        return move(m, n, k, i + 1, j, flag) // 向右向下搜索即可
             + move(m, n, k, i, j + 1, flag) + 1;
    }

    public int movingCount(int m, int n, int k) {
        int[][] flag = new int[m][n];
        return move(m, n, k, 0, 0, flag);
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] in = { { 2, 3, 1 }, { 3, 1, 0 }, { 1, 2, 1 } };
        for (int[] i : in) {
            System.out.println(s.movingCount(i[0], i[1], i[2]));
        }
    }
}