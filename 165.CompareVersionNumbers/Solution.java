import java.io.*;
import java.util.*;

/**
 * 165. Compare Version Numbers
 * 留意了一下Java的文件输出
 */
class Solution {
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0, len1 = version1.length(), len2 = version2.length(), r = 0;
        while (i < len1 || j < len2) {
            int v1 = 0, v2 = 0, left;
            if (i < len1) {
                left = i;
                while (i < len1 && version1.charAt(i) != '.')
                    i++;
                v1 = Integer.parseInt(version1, left, i, 10);
            }
            if (j < len2) {
                left = j;
                while (j < len2 && version2.charAt(j) != '.')
                    j++;
                v2 = Integer.parseInt(version2, left, j, 10);
            }
            if (v1 != v2) {
                r = v1 > v2 ? 1 : -1;
                break;
            }
            i++;
            j++;
        }
        return r;
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        File in = new File("input.txt");
        File out = new File("output.txt");
        Scanner scan = new Scanner(in);
        PrintWriter writer = new PrintWriter(out);
        while (scan.hasNextLine()) {
            String[] inputs = scan.nextLine().split(" ");
            int r = s.compareVersion(inputs[0], inputs[1]);
            writer.println(r);
        }
        scan.close();
        writer.close();
    }
}