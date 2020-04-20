/**
 * 151. Reverse Words in a String
 */
class Solution {
    // substring会比较费时间吧，用更多空间可以换更快的时间
    public String reverseWords(String s) {
        if (s == null)
            return s;
        s = s.trim();
        if ("".equals(s))
            return s;
        s = " " + s;
        StringBuilder result = new StringBuilder();
        int end = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (s.charAt(i + 1) != ' ')
                    result.append(s.substring(i, end));
                end = i;
                continue;
            }
        }
        result.deleteCharAt(0);
        return result.toString();
    }

    // 库的效率肯定没有直接操作快，不过短是真的短
    public String reverseWords2(String s) {
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] inputs = { "the sky is blue", "  hello world!  ", "a good   example" };
        for (String s : inputs)
            System.out.println("[" + sol.reverseWords(s) + "]");
    }
}