import java.util.*;

class InfixExperssion {
    private static Stack<Integer> snum = new Stack<>();
    private static Stack<Character> soper = new Stack<>();
    
    private static int getOperPriority(char c) {        
        switch (c) {
            case '{': case '[': case '(':
                return 4;
            case '*': case '/':
                return 3;
            case '+': case '-':
                return 2;
            case ')': case ']': case '}':
                return 1;
            default:
                return 0;
        }
    }
    
    private static void cal(char pre) {
        int b = snum.pop();
        int r = 0;
        while (!soper.isEmpty()) {
            char oper = soper.pop();
            int a = 0;
            if (!snum.isEmpty() && getOperPriority(pre) == 0)
                a = snum.pop();
            switch (oper) {
                case '+': 
                    r = a + b; break;
                case '-':
                    r = a - b; break;
                case '*':
                    r = a * b; break;
                case '/':
                    r = a / b; break;
                default:
                    break;
            }
        }
        snum.push(r);
    }

    public static int calculate(String exp)
    {
        int t = 0;
        for (int i = 0; i < exp.length(); i++) {
            if (getOperPriority(exp.charAt(i)) == 0) {
                t = t * 10 + exp.charAt(i) - '0';
            }
            else {
                if (i > 0 && getOperPriority(exp.charAt(i - 1)) == 0) {
                    snum.push(t);
                    t = 0;
                }
                else if (!soper.isEmpty()
                 && getOperPriority(soper.peek()) > getOperPriority(exp.charAt(i))) {
                    cal(exp.charAt(i - 1));
                    if (getOperPriority(exp.charAt(i)) != 1)
                        soper.push(exp.charAt(i));
                }
                else {
                    soper.push(exp.charAt(i));
                }
            }
        }
        
        while (!soper.isEmpty()) {
            cal('0');
        }

        return snum.pop();
    }

    public static void main(String[] args) {
        String exp = "3+2*{1+2*[-4/(8-6)+7]}";

        System.out.println(calculate(exp));
    }
}