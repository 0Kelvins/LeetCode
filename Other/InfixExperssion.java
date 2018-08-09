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
    private static void baseCal(char cur) {
        while (!soper.isEmpty()) {
            if (getOperPriority(soper.peek()) == 4) { // 左括号不运算，并结束运算
                if (getOperPriority(cur) == 1) { // 当前为右括号时，抛出左括号
                    soper.pop();
                }
                break;
            }
            else if (getOperPriority(cur) == 3 && getOperPriority(soper.peek()) < 3) {
                break;	// */只运行栈顶*/运算
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
            char cur = exp.charAt(i);
            if (getOperPriority(cur) == 0) {
                int t = cur - '0';
                while (i < exp.length()-1 && getOperPriority(exp.charAt(i+1)) == 0) {
                    t = t * 10 + exp.charAt(++i) - '0';
                }
                snum.push(t);
            }
            else {
                if (getOperPriority(cur) == 2     //  +-正负号处理
                    && (i == 0 || getOperPriority(exp.charAt(i-1)) > 2)) {
                    snum.push(0);
                }

                // 当前运算符比栈顶运算符优先级小时，栈内运算符抛出计算
                if (!soper.isEmpty() && getOperPriority(cur) != 4
                    && getOperPriority(soper.peek()) >= getOperPriority(cur)) {
                        baseCal(cur);
                }
                if (getOperPriority(cur) != 1) // 右括号不入栈
                    soper.push(cur);
            }
        }
        while (!soper.isEmpty()) {
            baseCal(' ');
        }

        return snum.pop();
    }

    public static void main(String[] args) {
        String[] exps = { "3+2*{1+2*[-4/(8-6)+7]}", "11-1*(7-(-2))",
                           "5-3+9*6*(6-10-2)", "(7+5*4*3+6)" };

        for (String exp: exps) {
            System.out.println(calculate(exp));
        }
    }
}