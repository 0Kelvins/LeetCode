class IntegertoRoman {
    public String intToRoman(int num) {
        char[] symbols = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
        int[] values = { 1, 5, 10, 50, 100, 500, 1000 };
        StringBuilder roman = new StringBuilder();
        int t = num, i = 6, p, k;

        while (t > 0) {
            p = t / values[i];
            t %= values[i];
            while (p-- > 0) {   // 当前位转换
                roman.append(symbols[i]);
            }
            if (i > 1 && i % 2 == 0) { // 在10的倍数位进行特殊值处理
                k = t / values[i - 2];
                if (k == 4) {
                    roman.append("" + symbols[i - 2] + symbols[i - 1]);
                    t -= 4 * values[i - 2];
                } else if (k == 9) {
                    roman.append("" + symbols[i - 2] + symbols[i]);
                    t -= 9 * values[i - 2];
                }
            }
            i--;
        }

        return roman.toString();
    }

    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};    
    String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public String intToRoman_offical(int num) {
        StringBuilder sb = new StringBuilder();
        // Loop through each symbol, stopping if num becomes 0.
        for (int i = 0; i < values.length && num >= 0; i++) {
            // Repeat while the current symbol still fits into num.
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        IntegertoRoman s = new IntegertoRoman();
        int[] nums = { 1, 2, 4, 5, 6, 9, 10, 11, 14, 19, 20, 40, 50, 58, 90, 100, 101, 109, 190, 1000, 1001, 1004, 1044, 1994 };
        for (int i : nums) {
            System.out.println(i + ":" + s.intToRoman(i));
        }
    }
}