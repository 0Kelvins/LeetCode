import java.util.Deque;
import java.util.LinkedList;

/**
 * 227. Basic Calculator II
 * Medium
 * 双栈速度稍慢，但是思路比较泛用
 */
public class Solution {

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private int getSignPriority(char c) {
        switch (c) {
            case '+':
                return 0;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;   // 符号优先级有点忘了。
            default:
                System.out.println("err sign:"+c);
                return -1;
        }
    }

    private void cal(Deque<Character> signs, Deque<Integer> numbers, int postPriori) {
        while (!signs.isEmpty() && getSignPriority(signs.peek()) >= postPriori) {
            char sign = signs.pop();
            int b = numbers.pop();
            int a = numbers.pop();
            // System.out.println("pop:"+a+sign+b);
            switch (sign) {
                case '+':
                    numbers.push(a + b);
                    break;
                case '-':
                    numbers.push(a - b);
                    break;
                case '*':
                    numbers.push(a * b);
                    break;
                case '/':
                    numbers.push(a / b);
                    break;
                default:
                    System.out.println("err sign:" + sign);
                    break;
            }
            // System.out.println("push:"+numbers.peek());
        }
    }

    public int calculate(String s) {
        s = s.replace(" ", "");
        char[] exp = s.toCharArray();
        Deque<Character> signs = new LinkedList<>();
        Deque<Integer> numbers = new LinkedList<>();
        if (!isNumber(exp[0])) {
            numbers.push(0);
        }
        int num = 0;
        for (int i = 0; i < exp.length; i++) {
            if (isNumber(exp[i])) {
                num = num * 10 + (exp[i] - '0');
                if (i == exp.length - 1 || !isNumber(exp[i + 1])) {
                    // System.out.println("push:"+num);
                    numbers.push(num);
                    num = 0;
                }
            } else {
                int postPriori = getSignPriority(exp[i]);
                if (!signs.isEmpty() && postPriori <= getSignPriority(signs.peek())) {
                    // System.out.println("in:");
                    cal(signs, numbers, postPriori);
                }
                // System.out.println("push:"+exp[i]);
                signs.push(exp[i]);
            }
        }
        // System.out.println("fin:"+signs.peek() +" "+ numbers.peek());
        cal(signs, numbers, 0);
        return numbers.pop();
    }

    public static void main(String[] args) {
        String[] exp = { "3+2*2", " 3/2 ", " 3+5 / 2 ", "14/3*2", "1+2*5/3+6/4*2" };
        Solution sol = new Solution();
        for (String s : exp) {
            System.out.println(sol.calculate(s));
        }
    }
}
