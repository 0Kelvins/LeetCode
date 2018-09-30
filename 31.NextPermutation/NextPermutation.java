/**
 * 31. Next Permutation
 * medium
 * find NEXT GREATER permutation of numbers
 * 变换为字典序排列的下一个排列，123->132->213->231->312->321->123
*/
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++; j--;
        }
    }

    private void swap(int[] nums, int a, int b) {
        int t = nums[b];
        nums[b] = nums[a];
        nums[a] = t;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] nums = {{ 1, 2, 3}, { 3, 2, 1}, { 1, 3, 2}};

        for (int i = 0; i < nums.length; i++) {
            s.nextPermutation(nums[i]);
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }
}