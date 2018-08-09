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

    // 基础运算
    private static void baseCal(char o) {
        while (!soper.isEmpty()) {
            if (getOperPriority(soper.peek()) == 4) { // 左括号不运算，并结束运算
                if (getOperPriority(o) == 1) { // 当前为右括号时，抛出左括号
                    soper.pop();
                }
                break;
            }
            char oper = soper.pop();
            int b = snum.pop();
            int a = snum.pop();
            int r = b;
            switch (oper) {
                case '+': 
                    r = a + b;
                    System.out.println(a + "+" + b + "=" + r);
                    break;
                case '-':
                    r = a - b;
                    System.out.println(a + "-" + b + "=" + r);
                    break;
                case '*':
                    r = a * b;
                    System.out.println(a + "*" + b + "=" + r);
                    break;
                case '/':
                    r = a / b;
                    System.out.println(a + "/" + b + "=" + r);
                    break;
                default:
                    break;
            }
            snum.push(r);
        }
    }

    public static int calculate(String exp)
    {
        for (int i = 0; i < exp.length(); i++) {
            if (getOperPriority(exp.charAt(i)) == 0) {
                int t = exp.charAt(i) - '0';
                while (getOperPriority(exp.charAt(i+1)) == 0) {
                    t = t * 10 + exp.charAt(++i) - '0';
                }
                snum.push(t);
            }
            else {
                if (getOperPriority(exp.charAt(i)) == 2     //  +-正负号处理
                    && (i == 0 || getOperPriority(exp.charAt(i-1)) > 2)) {
                    snum.push(0);
                }

                // 当前运算符比栈顶运算符权重小时，栈内运算符抛出计算
                if (!soper.isEmpty() && getOperPriority(exp.charAt(i)) != 4
                    && getOperPriority(soper.peek()) > getOperPriority(exp.charAt(i)) ) {
                    
                    baseCal(exp.charAt(i));
                    
                    if (getOperPriority(exp.charAt(i)) != 1) // 右括号不入栈
                        soper.push(exp.charAt(i));
                }
                else {
                    soper.push(exp.charAt(i));
                }
            }
        }
        while (!soper.isEmpty()) {
            baseCal(' ');
        }

        return snum.pop();
    }

    public static void main(String[] args) {
        String[] exps = { "3+2*{1+2*[-4/(8-6)+7]}", "11-1*(7-(-2))" };

        for (String exp: exps) {
            System.out.println(calculate(exp));
        }
    }
}