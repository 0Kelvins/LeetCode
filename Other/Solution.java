public class Solution {
    public int calculate(String s) {
        ArrayList<String> tokens = tokenize(s);
        Stack<Character> operators = new Stack<Character>();
        Stack<Integer> operands = new Stack<Integer>();
        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);
            //if token is number
            if (isNumber(token))
                operands.push(Integer.valueOf(token));
            //is operators: (,),+,-,*,/
            else {
                Character cur = token.charAt(0);//convert string to char for operator
                if (operators.isEmpty()) {
                    operators.push(cur);
                } 
                else if (cur == '(') {
                    operators.push(cur);
                }
                else if (cur == ')') {
                    while (operators.peek() != '(') {
                        popAndCal(operators, operands);
                    }
                    operators.pop();
                }
                else if (cur == '+' || cur == '-')  {
                    char top = operators.peek();
                    while (top == '+' || top == '-' || top == '*' || top == '/' ) {
                        popAndCal(operators, operands);
                        top = operators.isEmpty() ? ' ' : operators.peek();
                    }
                    operators.push(cur);
                }
                else if (cur == '*' || cur == '/') {
                    char top = operators.peek();
                    while (top == '*' || top == '/' ) {
                        popAndCal(operators, operands);
                        top = operators.isEmpty() ? ' ' : operators.peek();
                    }
                    operators.push(cur);
                }
            }
        }
        while (!operators.isEmpty()) {
            popAndCal(operators, operands);
        }
        return operands.pop();
    }
    
    public boolean isNumber(String s) {
        if (s.charAt(0) <= '9' && s.charAt(0) >= '0')
            return true;
        return false;
    }
    public ArrayList<String> tokenize(String s) {
        ArrayList<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length();) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            else if (!Character.isDigit(s.charAt(i))) {
                result.add(String.valueOf(s.charAt(i++)));
            }
            else {
                sb = new StringBuilder();
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i++;
                }
                result.add(sb.toString());
            }
        }
        return result;
    }
    public void popAndCal(Stack<Character> operators, Stack<Integer> operands) {
        int num2 = operands.pop();
        int num1 = operands.pop();
        char opr = operators.pop();
        operands.push(exe(num1, num2, opr));
    }
    public int exe(int n1, int n2, char op) {
        int result = 0;
        if (op == '+') {
            result = n1 + n2;
        }
        else if (op == '-') {
            result = n1 - n2;
        }
        else if (op == '*') {
            result = n1 * n2;
        }
        else if (op == '/') {
            result = n1 / n2;
        }
        return result;
    }
}