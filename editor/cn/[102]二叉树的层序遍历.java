//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 803 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // for return
        List<List<Integer>> res = new ArrayList<>();
        // for level
        LinkedList<TreeNode> level = new LinkedList<>();
        // for tempLevel
        LinkedList<Integer> queue = new LinkedList<>();

        if (root == null) {
            return res;
        }
        level.add(root);

        while (level.size() != 0) {
            // for nextLevel
            LinkedList<TreeNode> nextLevel = new LinkedList<>();
            while (level.size() != 0) {
                TreeNode node = level.pollFirst();
                if (node.left != null) nextLevel.add(node.left);
                if (node.right != null) nextLevel.add(node.right);
                queue.addLast(node.val);
            }
            level.addAll(nextLevel);
            res.add(new ArrayList<>(queue));
            queue.clear();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
