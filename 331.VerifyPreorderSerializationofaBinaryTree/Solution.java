import java.util.*;
/**
 * 331. Verify Preorder Serialization of a Binary Tree
 * Medium
 * 这里是从下往上删除节点验证，用从上往下记录可填入节点数量代替栈会更快
 */
public class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder.length() == 0)
            return false;
        String NullNode = "#";
        if(NullNode.equals(preorder))
            return true;
        String[] nodes = preorder.split(",");
        Deque<String> s = new LinkedList<>();
        for (int i = 0; i < nodes.length; i++) {
            if (!s.isEmpty() && NullNode.equals(s.peek()) && NullNode.equals(nodes[i])) {
                while (!s.isEmpty() && NullNode.equals(s.peek())) {
                    s.pop();
                    if (s.isEmpty())
                        return false;
                    s.pop();
                }
                if(!s.isEmpty())
                    s.push(NullNode);
                else if(i != nodes.length - 1)
                    return false;
            } else
                s.push(nodes[i]);
            // s.forEach((c) -> System.out.print(c + " "));
            // System.out.println();
        }
        return s.isEmpty();
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] ps = { "9,3,4,#,#,1,#,#,2,#,6,#,#", "1,#", "9,#,#,1", "#" };
        for (String p : ps) {
            System.out.println(sol.isValidSerialization(p));
        }
    }
}