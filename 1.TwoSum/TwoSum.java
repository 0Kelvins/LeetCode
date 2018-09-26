import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> m = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if(m.containsKey(complement)){
				return new int[] {m.get(complement), i};
			}
			m.put(nums[i], i);
		}
		return new int[] {-1, -1};
    }

    public static void main(String[] args) {
    	int[] nums = {2, 11, 15, 7, 1};
		int target = 9;
		Solution s = new Solution();
    	int[] result = s.twoSum(nums, target);
    	for (int r : result ) {
    		System.out.println(r);
    	}
    }
}