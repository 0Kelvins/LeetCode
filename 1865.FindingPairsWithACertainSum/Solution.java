import java.util.*;

/**
 * 1865. Finding Pairs With a Certain Sum
 * Meidum
 * nums1的数比nums2的少很多，遍历更快
 */
class FindSumPairs {

    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> map;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], map.getOrDefault(nums2[i], 0) + 1);
        }
    }
    
    public void add(int index, int val) {
        map.put(nums2[index], map.get(nums2[index]) - 1);
        nums2[index] += val;
        map.put(nums2[index], map.getOrDefault(nums2[index], 0) + 1);
    }
    
    public int count(int tot) {
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            count += map.getOrDefault(tot - nums1[i], 0);
        }
        return count;
    }
}

public class Solution {
    public static void main(String[] args) {
        int[][] nums = { { 1, 1, 2, 2, 2, 3 }, { 1, 4, 5, 2, 5, 4 } };
        FindSumPairs findSumPairs = new FindSumPairs(nums[0], nums[1]);
        System.out.println(findSumPairs.count(7)); // return 8; pairs (2,2), (3,2), (4,2), (2,4), (3,4), (4,4) make 2 + 5 and pairs (5,1), (5,5) make 3 + 4
        findSumPairs.add(3, 2); // now nums2 = [1,4,5,4,5,4]
        System.out.println(findSumPairs.count(8)); // return 2; pairs (5,2), (5,4) make 3 + 5
        System.out.println(findSumPairs.count(4)); // return 1; pair (5,0) makes 3 + 1
        findSumPairs.add(0, 1); // now nums2 = [2,4,5,4,5,4]
        findSumPairs.add(1, 1); // now nums2 = [2,5,5,4,5,4]
        System.out.println(findSumPairs.count(7)); // return 11; pairs (2,1), (2,2), (2,4), (3,1), (3,2), (3,4), (4,1), (4,2), (4,4) make 2 + 5 and pairs (5,3), (5,5) make 3 + 4
    }
}
