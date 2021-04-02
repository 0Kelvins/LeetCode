import java.util.*;

/**
 * 68. Text Justification
 * Hard
 * 主要就是贪心往行里填词
 */
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        int left = 0, right = 0, len = 0, t;
        for (String w : words) {
            t = len + w.length() + 1;
            if (t - 1 > maxWidth) { // max words
                // System.out.println(w + " " + t + " " + len + " " + left + " " + right);
                builder = new StringBuilder(words[left]);
                int count = right - left;
                if (count > 1) {
                    int space = maxWidth - (len - count), mod = space % (count - 1);
                    space /= (count - 1);
                    for (int i = left + 1; i < right; i++) {
                        for (int j = 0; j < space; j++) {
                            builder.append(" ");
                        }
                        if (mod-- > 0) {
                            builder.append(" ");
                        }
                        builder.append(words[i]);
                    }
                } else {
                    for (int i = 0; i <= maxWidth - len; i++) {
                        builder.append(" ");
                    }
                }
                
                res.add(builder.toString());
                // System.out.println(builder.toString() + " " + builder.length());
                len = w.length() + 1; // new next line
                left = right;
                right = left + 1;
            } else {
                len = t;
                right++;
            }
        }
        
        builder = new StringBuilder(words[left]); // last line
        for (int i = left + 1; i < right; i++) {
            builder.append(" " + words[i]);
        }
        for (int i = 0; i <= maxWidth - len; i++) {
            builder.append(" ");
        }
        res.add(builder.toString());
        // System.out.println(builder.toString() + " " + builder.length());
        return res;
    }

    public static void main(String[] args) {
        String[][] words = { {"One"},
            {"This", "is", "an", "example", "of", "text", "justification."},
            {"What","must","be","acknowledgment","shall","be"},
            {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}
        };
        int[] maxWidths = { 5, 16, 16, 20 };
        Solution s = new Solution();
        for (int i = 0; i < maxWidths.length; i++) {
            List<String> res = s.fullJustify(words[i], maxWidths[i]);
            for (String r : res) {
                System.out.println("\"" + r + "\"");
            }
            System.out.println();
        }
    }
}
