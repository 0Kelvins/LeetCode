import java.util.Arrays;

/**
 * 1723. Find Minimum Time to Finish All Jobs
 * Hard
 */
public class Solution {

    // 递归分配任务给不同工人，满足最大工作时间为limit
    private boolean backtrack(int[] jobs, int i, int[] workloads, int limit) {
        if (i >= jobs.length) {
            return true;
        }
        int curJob = jobs[i];
        for (int j = 0; j < workloads.length; j++) {
            if (workloads[j] + curJob <= limit) {
                workloads[j] += curJob;
                if (backtrack(jobs, i + 1, workloads, limit)) {
                    return true;
                }
                workloads[j] -= curJob;
            }
            // 当前工人分配负载为0或limit时，没必要继续给后面人分配尝试
            if (workloads[j] == 0 || workloads[j] + curJob == limit) {
                break;
            }
        }
            
        return false;
    }

    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        int l = 0, r = jobs.length - 1;
        while (l < r) { // 逆序
            int t = jobs[l];
            jobs[l] = jobs[r];
            jobs[r] = t;
            l++;
            r--;
        }
        int low = jobs[0], high = Arrays.stream(jobs).sum();
        while (low < high) {    // 二分查找最小最大工作时间
            int mid = (low + high) / 2;
            int[] workloads = new int[k];
            if(backtrack(jobs, 0, workloads, mid)) { //尝试该limit是否有解
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[][] jobs = { { 3, 2, 3 }, { 1, 2, 4, 7, 8 }, { 5, 5, 4, 4, 4 }, { 1, 3, 5, 1000 }, {12,13,14,17,25} };
        int[] k = { 3, 2, 2, 4, 3 };
        Solution s = new Solution();
        for (int i = 0; i < k.length; i++) {
            System.out.println(s.minimumTimeRequired(jobs[i], k[i]));
        }
    }
}