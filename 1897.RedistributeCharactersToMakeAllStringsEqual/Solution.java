/**
 * 1897. Redistribute Characters to Make All Strings Equal
 * Easy
 */
public class Solution {
    public boolean makeEqual(String[] words) {
        int[] alphabet = new int[26];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                alphabet[words[i].charAt(j) - 'a']++;
            }
        }
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] != 0 && alphabet[i] % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}
