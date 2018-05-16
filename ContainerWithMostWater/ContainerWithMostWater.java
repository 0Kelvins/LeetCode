/**
 * 11. Container With Most Water
 * medium
 * 需要找规律，可以从两端向内比较，高度比外侧高的才有可能比外侧面积大
*/
class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, area = 0;
        while (l < r) {
            area = Math.max(area, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) {
                l++;
            }
            else {
                r--;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] height0 = {1, 1};
        int[] height1 = {1, 2, 5, 0, 13, 7, 2};
        System.out.println(s.maxArea(height0));
        System.out.println(s.maxArea(height1));
    }
}