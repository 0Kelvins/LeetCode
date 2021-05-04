import java.util.Arrays;

/**
 * 223. Rectangle Area
 * Meidum
 * 没有想清楚最根本的原理的时候代码就会很罗嗦
 */
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int X = Math.max(0, Math.min(G, C) - Math.max(A, E));
        int Y = Math.max(0, Math.min(D, H) - Math.max(B, F));
        return (C - A) * (D - B) + (G - E) * (H - F) - X * Y;
    }

    public static void main(String[] args) {
        int[][] coordinates = { { -3, 0, 3, 4, 0, -1, 9, 2 }, { -2, -2, 2, 2, -2, -2, 2, 2 }, {-2, -2, 2, 2, -1, 4, 1, 6 } };
        Solution s = new Solution();
        for (int[] c : coordinates) {
            System.out.println(s.computeArea(c[0], c[1], c[2], c[3], c[4], c[5], c[6], c[7]));
        }
    }
}
