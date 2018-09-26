import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int ls = 0, leftIndex = 0;
        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            int l = 1;
            for (int j = leftIndex; j < i; j++) {
                if (sc[j] == sc[i]) {
                    leftIndex = j + 1;
                    break;
                }
                else {
                    l++;
                }
            }
            if (l > ls) {
                ls = l;
            }
        }
        return ls;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String s = scanner.nextLine();
            if ("q".equals(s))
                break;
            int l = lengthOfLongestSubstring(s);
            System.out.println(l);
        }
        scanner.close();
    }
}