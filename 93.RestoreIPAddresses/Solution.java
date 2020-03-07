import java.io.*;
import java.util.*;

/**
 * 93. Restore IP Addresses
 * 写完再仔细看才明白自己用的DFS。还需要多练
 * BFS的效率好像还不如暴力呢，也不够简洁。
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<>(); // 当作队列
        List<Integer> count = new LinkedList<>(); // 可少数字个数
        int n = s.length();
        if (n < 4 || n > 12)
            return res;
        res.add(""); // 添加空开始串
        count.add(12 - n); // 初始最大可缺少个数
        for (int i = 0; i < 4; i++) {
            int rsize = res.size();
            for (int j = 0; j < rsize; j++) {
                String r = res.get(0);
                int c = count.get(0);
                int rlen = r.length() - i;
                for (int k = 1; k < 4; k++) {
                    if (rlen + k > n || (s.charAt(rlen) == '0' && k > 1))
                        break; // 边界及0开头的非零数处理
                    int t = Integer.valueOf(s.substring(rlen, rlen + k));
                    int d = 3 - k; // 占用缺少位的数量
                    if (d > c || t > 255) // 大于最大缺少或非法值
                        continue;
                    if (i == 3)
                        r = r.substring(1);
                    res.add(r + '.' + s.substring(rlen, rlen + k));
                    count.add(c - d); // 插入队尾
                }
                res.remove(0); // 队首出队
                count.remove(0);
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        File f = new File("input.txt");
        Scanner scan = new Scanner(f);
        // Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String ip = scan.next();
            List<String> res = s.restoreIpAddresses(ip);
            for (String r : res)
                System.out.println(r);
        }
        scan.close();
    }
}