/**
 * 58. Length of Last Word
 * Easy
 */
public class Solution {

    public int lengthOfLastWord(String s) {
        boolean inWord = false;
        int n = s.length(), len = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                inWord = true;
                len++;
            } else if (inWord) {
                break;
            }
        }
        return len;
    }
}