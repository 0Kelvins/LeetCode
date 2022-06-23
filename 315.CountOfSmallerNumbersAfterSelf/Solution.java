import java.util.ArrayList;
import java.util.List;

/**
 * 315. Count of Smaller Numbers After Self
 * Hard
 * 归并排序
 */
public class Solution {
    
    private int[] index;
    private int[] sort;
    private int[] pointer;
    private int[] res;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        index = new int[n];
        sort = new int[n];
        pointer = new int[n];
        res = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        mergeSort(nums, 0, n - 1);
        List<Integer> r = new ArrayList<>();
        for (int i : res) {
            r.add(i);
        }
        return r;
    }
    
    private void mergeSort(int[] nums, int l, int r) {
        if (l == r) {
            return;
        }
        int m = l + (r - l) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);
        merge(nums, l, m, r);
    }

    private void merge(int[] nums, int l, int m, int r) {
        int i = l, j = m + 1, p = l;
        while (i <= m && j <= r) {
            if (nums[i] <= nums[j]) {
                sort[p] = nums[i];
                pointer[p] = index[i];
                res[index[i]] += (j - m - 1);
                i++;
            } else {
                sort[p] = nums[j];
                pointer[p] = index[j];
                j++;
            }
            p++;
        }

        while (i <= m) {
            sort[p] = nums[i];
            pointer[p] = index[i];
            res[index[i]] += (j - m - 1);
            i++;
            p++;
        }

        while (j <= r) {
            sort[p] = nums[j];
            pointer[p] = index[j];
            j++;
            p++;
        }

        for (int k = l; k <= r; k++) {
            nums[k] = sort[k];
            index[k] = pointer[k];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] nums = { { 5, 2, 6, 1 }, { -1 }, { -1, -1 } };
        for (int[] ns : nums) {
            List<Integer> r = sol.countSmaller(ns);
            System.out.println(r.toString());
        }
    }
}
