import java.util.*;
import java.io.*;

/**
 * 90. Subsets II
 * 参考78题，DP+剪枝
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> r = new ArrayList<>();
        r.add(new ArrayList<>());
        int rsize = 0, preStart;
        for (int i = 0; i < nums.length; i++) {
            preStart = 0;
            if (i > 0 && nums[i] == nums[i - 1])
                preStart = rsize;
            rsize = r.size();
            for (int j = preStart; j < rsize; j++) {
                List<Integer> t2 = new ArrayList<>();
                for (int k = 0; k < r.get(j).size(); k++)
                    t2.add(r.get(j).get(k));
                t2.add(nums[i]);
                r.add(t2);
            }
        }
        return r;
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        File f = new File("input.txt");
        Scanner scan = new Scanner(f);
        while (scan.hasNext()) {
            String in = scan.nextLine();
            String[] ins = in.split(" ");
            int[] nums = new int[ins.length];
            for (int i = 0; i < ins.length; i++)
                nums[i] = Integer.valueOf(ins[i]);
            List<List<Integer>> r = s.subsetsWithDup(nums);
            for (List<Integer> i : r) {
                for (Integer j : i)
                    System.out.print(j + " ");
                System.out.println();
            }
        }
        scan.close();
    }
}