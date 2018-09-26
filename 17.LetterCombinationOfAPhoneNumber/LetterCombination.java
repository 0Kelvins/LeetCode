import java.util.*;

/**
 * 17. Letter Combinations of a Phone Number
 * medium
 * 使用先入先出（FIFO）的队列，解决字符串拼接的流水线问题
 * BFS简化循环层次
 */
class Solution {
    private static String[] map = {"", "", "abc", "def",
        "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if (digits.isEmpty()) return result;
        result.add("");
        while(result.peek().length() != digits.length()) {
            String top = result.remove();
            int t = digits.charAt(top.length()) - '0';
            for(char c: map[t].toCharArray()) {
                result.add(top + c);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner scan = new Scanner(System.in);
        while(true) {
            String input = scan.next();
            if (!input.matches("[0-9]+")) break;
            List<String> result = s.letterCombinations(input);
            System.out.println(String.join(", ", result));
        }
        scan.close();
    }
}