import java.io.*;
import java.util.*;

/**
 * 150. Evaluate Reverse Polish Notation
 * 用数组和下标模拟栈会更快，数组最大长度为tokens.length / 2 + 1
 */
class Solution {
    private boolean isNumber(String token) {
        if (token.length() == 1) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    return false;
            }
        }
        return true;
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            if (isNumber(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                int a = stack.pop();
                int b = stack.pop();
                switch (tokens[i]) {
                    case "+":
                        b += a;
                        break;
                    case "-":
                        b -= a;
                        break;
                    case "*":
                        b *= a;
                        break;
                    case "/":
                        b /= a;
                        break;
                }
                stack.push(b);
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        File f = new File("input.txt");
        Scanner scan = new Scanner(f);
        while (scan.hasNextLine()) {
            String[] tokens = scan.nextLine().split(" ");
            System.out.println(s.evalRPN(tokens));
        }
        scan.close();
    }
}