import java.util.*;

/**
 * 218. The Skyline Problem
 * Hard
 * 这题是真的难。
 */
public class Solution {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        List<int[]> corner = new ArrayList<>(); // 将每个建筑的左右上角分别存储
        for (int[] b : buildings) {
            corner.add(new int[] { b[0], -b[2] });  // 左角负高度表示
            corner.add(new int[] { b[1], b[2] });
        }
        // 将角落按左边>高度递增排序
        Collections.sort(corner, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        TreeMap<Integer, Integer> heightCount = new TreeMap<>((a, b) -> b - a);    // 高度的数量
        heightCount.put(0, 1);  // 地面高度0有1个
        int preHeight = 0;
        for (int[] c : corner) {
            if (c[1] < 0) { // 左角，加入对应高度
                Integer count = heightCount.get(-c[1]);
                count = count == null ? 1 : count + 1;
                heightCount.put(-c[1], count);
            } else {    // 右角，移除对应高度
                Integer count = heightCount.get(c[1]);
                if (count == 1) {
                    heightCount.remove(c[1]);
                } else {
                    heightCount.put(c[1], count - 1);
                }
            }
            int curMaxHeight = heightCount.firstKey(); // 当前最大高度
            if (preHeight != curMaxHeight) {    // 高度变化时，记录拐点
                ans.add(Arrays.asList(c[0], curMaxHeight));
                preHeight = curMaxHeight;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[][][] buildings = { { { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 } },
                { { 0, 2, 3 }, { 2, 5, 3 } } };
        for (int[][] bs : buildings) {
            System.out.println(s.getSkyline(bs).toString());
        }
    }
}


// buildings  [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8]
// 根据 buildings 求出每个 building 的左上角和右上角坐标
// 将所有坐标按照 x 排序, 并标记当前坐标是左上角坐标还是右上角坐标
// l(2,10) l(3,15) l(5,12) r(7,15) r(9,10) r(12,12) l(15,10) l(19,8) r(20,10) r(24,8)
// PriorityQueue = {0}, preMax = 0

// l(2,10) 将 10 加入优先队列
// preMax = 0, PriorityQueue  = {0 10}
// 当前 PriorityQueue 的 max = 10, 相对于 preMax 更新了
// 将 (2,10) 加入到 res, res = {(2,10)}
// 更新 preMax = 10
    
// l(3,15) 将 15 加入优先队列
// preMax = 10, PriorityQueue  = {0 10 15}
// 当前 PriorityQueue 的 max = 15, 相对于 preMax 更新了
// 将 (3,15) 加入到 res, res = {(2,10) (3,15)}
// 更新 preMax = 15    
    
// l(5,12) 将 12 加入优先队列
// preMax = 15, PriorityQueue  = {0 10 15 12}
// 当前 PriorityQueue 的 max = 15, 相对于 preMax 没有更新
// res 不变

// r(7,15) , 遇到右上角坐标, 将 15 从优先队列删除
// preMax = 15, PriorityQueue  = {0 10 12}
// 当前 PriorityQueue 的 max = 12, 相对于 preMax 更新了
// 将 (7,max) 即 (7,12) 加入到 res, res = {(2,10) (3,15) (7,12)}
// 更新 preMax = 12
    
// r(9,10) , 遇到右上角坐标, 将 10 从优先队列删除
// preMax = 12, PriorityQueue  = {0 12}
// 当前 PriorityQueue 的 max = 12, 相对于 preMax 没有更新
// res 不变

// r(12,12) , 遇到右上角坐标, 将 12 从优先队列删除
// preMax = 12, PriorityQueue  = {0}
// 当前 PriorityQueue 的 max = 0, 相对于 preMax 更新了
// 将 (12,max) 即 (7,0) 加入到 res, res = {(2,10) (3,15) (7,12) (12,0)}
// 更新 preMax = 0
    
// 后边的同理，就不进行下去了。


// 作者：windliang
// 链接：https://leetcode-cn.com/problems/the-skyline-problem/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--45/