/**
 * 852. Peak Index in a Mountain Array
 * Easy
 * Binary Search
 */
public class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int i = 1, j = arr.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] > arr[mid + 1]) {
                if (arr[mid - 1] < arr[mid]) {
                    return mid;
                } else {
                    j = mid - 1;
                }
            } else {
                i = mid + 1;
            }
        }
        return i;
    }
    
    public static void main(String[] args) {
        int[][] arrs = { { 0, 1, 0 }, { 0, 2, 1, 0 }, { 0, 10, 5, 2 }, { 3, 4, 5, 1 },
                { 24, 69, 100, 99, 79, 78, 67, 36, 26, 19 } };
        Solution s = new Solution();
        for (int[] arr : arrs) {
            System.out.println(s.peakIndexInMountainArray(arr));
        }
    }
}