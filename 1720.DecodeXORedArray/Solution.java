import java.util.*;

/**
 * 1720. Decode XORed Array
 * Easy
 * 0^1=1 1^0=1 1^1=0 0^0=0
 */
public class Solution {

    public int[] decode(int[] encoded, int first) {
        int[] arr = new int[encoded.length + 1];
        arr[0] = first;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = encoded[i - 1] ^ arr[i - 1];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] encodeds = {{1,2,3},{6,2,7,3}};
        int[] firsts = { 1, 4 };
        Solution s = new Solution();
        for (int i = 0; i < firsts.length; i++) {
            System.out.println(Arrays.toString(s.decode(encodeds[i], firsts[i])));
        }
    }
}