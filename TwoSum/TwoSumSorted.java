import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int l = 0, r = numbers.length - 1;
        while(l < r) {
            int t = numbers[l] + numbers[r];
            if (t < target) {
                l++;
            }
            else if (t > target){
                r--;
            }
            else {
                result[0] = l + 1;
                result[1] = r + 1;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
    	int[] nums = {0, 0, 3, 5};
		int target = 0;
		Solution s = new Solution();
    	int[] result = s.twoSum(nums, target);
    	for (int r : result ) {
    		System.out.println(r);
        }
        System.exit(0);
    }
}