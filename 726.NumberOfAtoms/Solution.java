import java.util.*;

/**
 * 726. Number of Atoms
 * Hard
 */
public class Solution {

    class Pair {
        String key;
        int val;
        Pair() {}
        Pair(String key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int getType(char c) {
        if (c >= 'A' && c <= 'Z')
            return 0;
        if (c >= 'a' && c <= 'z')
            return 1;
        if (c >= '0' && c <= '9')
            return 2;
        return 3;
    }

    public String countOfAtoms(String formula) {
        Deque<Pair> stack = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        char[] f = formula.toCharArray();
        for (int i = 0; i < f.length; i++) {
            char c = f[i];
            if (getType(c) == 0) { // A
                int j = i;
                builder.append(f[j++]);
                while (j < f.length && getType(f[j]) == 1) { // Au
                    builder.append(f[j++]);
                }
                Pair t = new Pair(builder.toString(), 1);
                stack.push(t);
                i = j - 1;
                builder = new StringBuilder();
            } else if (getType(c) == 2) { // 1
                int j = i;
                while (j < f.length && getType(f[j]) == 2) { // 12
                    builder.append(f[j++]);
                }
                int count = Integer.parseInt(builder.toString());
                builder = new StringBuilder();
                if (getType(f[i - 1]) <= 1) { // a1
                    Pair t = stack.pop();
                    t.val = count;
                    stack.push(t);
                } else if (")".equals(stack.peek().key)) { // )1
                    stack.pop();
                    List<Pair> tList = new ArrayList<>();
                    while (!stack.isEmpty()) {
                        Pair t = stack.pop();
                        if ("(".equals(t.key)) {
                            break;
                        }
                        t.val *= count;
                        tList.add(t);
                    }
                    tList.forEach((e) -> stack.push(e));
                }
                i = j - 1;
            } else if (c == '(' || c == ')') {
                Pair b = new Pair(c + "", 0);
                stack.push(b);
                if (c == ')' && (i == f.length - 1 || getType(f[i + 1]) != 2)) {
                    stack.pop();
                    List<Pair> tList = new ArrayList<>();
                    while (!stack.isEmpty()) {
                        Pair t = stack.pop();
                        if ("(".equals(t.key)) {
                            break;
                        }
                        tList.add(t);
                    }
                    tList.forEach((e) -> stack.push(e));
                }
            }
        }

        Map<String, Integer> map = new TreeMap<>();
        while (!stack.isEmpty()) {
            Pair t = stack.pop();
            int et = map.getOrDefault(t.key, 0);
            map.put(t.key, et + t.val);
        }
        StringBuilder ans = new StringBuilder();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            ans.append(e.getKey());
            if (e.getValue() > 1) {
                ans.append(e.getValue());
            }
        }
        return ans.toString();
    }
    
    public static void main(String[] args) {
        String[] formula = { "H2O", "Mg(OH)2", "K4(ON(SO3)2)2", "Be32", "H" };
        Solution s = new Solution();
        for (String f : formula) {
            System.out.println(s.countOfAtoms(f));
        }
    }
}