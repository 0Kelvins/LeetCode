import java.util.Deque;
import java.util.LinkedList;

/**
 * 224. Basic Calculator
 * Hard
 * 写的还是不清晰，边界处理变得很麻烦
 */
public class Solution {

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    public int calculate(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                builder.append(s.charAt(i));
            }
        }
        char[] exp = builder.toString().toCharArray();
        Deque<Integer> numbers = new LinkedList<>();
        Deque<Character> signs = new LinkedList<>();
        Integer curNum = 0;
        for (int i = 0; i < exp.length; i++) {
            char cur = exp[i];
            if (isNumber(cur)) {
                curNum = curNum * 10 + (cur - '0');
                if (i == exp.length - 1 || !isNumber(exp[i + 1])) {
                    while (!signs.isEmpty()) {
                        char sign = signs.pop();
                        if (sign == '(') {
                            if (exp[i + 1] == ')') {
                                i++;
                                continue;
                            }
                            signs.push('(');
                            break;
                        }
                        int a = numbers.isEmpty() ? 0 : numbers.pop();
                        if (sign == '+') {
                            curNum = a + curNum;
                        } else if (sign == '-') {
                            curNum = a - curNum;
                        }
                    }
                    numbers.push(curNum);
                    curNum = 0;
                }
            } else {
                if (cur == '(' && !isNumber(exp[i+1])) {
                    numbers.push(0);
                }
                signs.push(cur);
            }
        }
        return numbers.pop();
    }

    public static void main(String[] args) {
        String[] str = {"2-4-(8+2-6+(8+4-(1)+8-10))", "- (3 + (4 + 5))", "(1+(4+5+2)-3)+(6+8)", "1-(+1+1)", "1 + 1", " 2-10 + 2 ", "-1111", "1-(-1)" };
        Solution sol = new Solution();
        for (String s : str) {
            System.out.println(sol.calculate(s));
        }
    }
}
