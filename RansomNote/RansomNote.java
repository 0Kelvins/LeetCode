import java.util.Scanner;

class Solution {
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] num = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            num[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--num[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            String a = scanner.next();
            String b = scanner.next();
            Boolean r = canConstruct(a, b);
            System.out.println(r);
        }
    }
}