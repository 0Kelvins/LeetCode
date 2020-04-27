import java.io.*;
import java.util.*;

/**
 * 166. Fraction to Recurring Decimal
 * 注意符号和边界，好久不优化代码了，自己写的比别人就乱很多
 */
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        StringBuilder result = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) // 异或
            result.append("-");
        long num = Math.abs(Long.valueOf(numerator)), denom = Math.abs(Long.valueOf(denominator));
        result.append(num / denom);
        num %= denom;
        if (num == 0)
            return result.toString();
        result.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (num != 0) {
            if (map.containsKey(num)) {
                result.insert(map.get(num), "(");
                result.append(")");
                break;
            }
            map.put(num, result.length());
            num *= 10;
            result.append(num / denom);
            num %= denom;
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        Scanner scan = new Scanner(new File("input.txt"));
        while (scan.hasNextLine()) {
            int a = scan.nextInt(), b = scan.nextInt();
            System.out.println(s.fractionToDecimal(a, b));
        }
        scan.close();
    }
}