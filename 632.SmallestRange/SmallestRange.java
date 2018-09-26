import java.util.*;

/**
 * 632. Smallest Range
 * So Hard -_-b
 * 求多个整数数组列表中，每个数组取至少一个值，组成的最小数值范围
*/
class Solution {
    public int[] smallestRangePointer(List<List<Integer>> nums) {
        int minx = 0, miny = Integer.MAX_VALUE;
        int[] next = new int[nums.size()];  // 遍历时指向每个list的指针
        boolean flag = true;
        for (int i = 0; i < nums.size() && flag; i++) {
            for (int j = 0; j < nums.get(i).size() && flag; j++) {
                int min_i = 0, max_i = 0;
                for (int k = 0; k < nums.size(); k++) { // 遍历所有list当前next下标的值，求出当前范围最大最小值list下标
                    if (nums.get(min_i).get(next[min_i]) > nums.get(k).get(next[k]))
                        min_i = k;
                    if (nums.get(max_i).get(next[max_i]) < nums.get(k).get(next[k]))
                        max_i = k;
                }
                // 与记录的最小的范围比较大小，并取小的范围
                if (miny - minx > nums.get(max_i).get(next[max_i]) - nums.get(min_i).get(next[min_i])) {
                    miny = nums.get(max_i).get(next[max_i]);
                    minx = nums.get(min_i).get(next[min_i]);
                }
                next[min_i]++;  // 增加最小值对应list的next下标
                if (next[min_i] == nums.get(min_i).size()) { // 若最小next指针到了末尾，则结束
                    flag = false;
                }
            }
        }
        return new int[] {minx, miny};
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        int minx = 0, miny = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int[] next = new int[nums.size()];
        boolean flag = true;
        PriorityQueue<Integer> min_queue = new PriorityQueue<Integer>(  // 优先队列（小顶堆），优化比较速度 
            (i, j) -> nums.get(i).get(next[i]) - nums.get(j).get(next[j])); // 比较函数
        for (int i = 0; i < nums.size(); i++) {
            min_queue.offer(i);
            max = Math.max(max, nums.get(i).get(0));
        }
        for (int i = 0; i < nums.size() && flag; i++) {
            for (int j = 0; j < nums.get(i).size() && flag; j++) {
                int min_i = min_queue.poll();
                if (miny - minx > max - nums.get(min_i).get(next[min_i])) {
                    minx = nums.get(min_i).get(next[min_i]);
                    miny = max;
                }
                next[min_i]++;
                if (next[min_i] == nums.get(min_i).size()) {
                    flag = false;
                    break;
                }
                min_queue.offer(min_i);
                max = Math.max(max, nums.get(min_i).get(next[min_i]));
            }
        }
        return new int[] {minx, miny};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Integer[][] nums1 = {{4,10,15,24,26}, {0,9,12,20,50}, {5,18,22,30,99}};
        List<List<Integer>> nums = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums1.length; i++) {
            List<Integer> t = Arrays.asList(nums1[i]);
            nums.add(t);
        }
        int[] result = s.smallestRange(nums);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}