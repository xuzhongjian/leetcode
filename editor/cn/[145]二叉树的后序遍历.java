//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 572 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode cur = root;
        while (cur != null || stack.size() != 0) {
            while (cur != null) {
                res.addFirst(cur.val);
                stack.addFirst(cur);
                cur = cur.right;
            }
            TreeNode node = stack.pollFirst();
            cur = node.left;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
