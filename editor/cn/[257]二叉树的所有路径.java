//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 467 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
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
    private List<List<Integer>> res = new ArrayList<>();
    private List<TreeNode> tempList = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        tempList.add(root);
        dfs(root);
        ArrayList<String> strings = new ArrayList<>();
        for (List<Integer> list : res) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : list) {
                sb.append(i);
                sb.append("->");
            }
            String string = sb.toString();
            string = string.substring(0, string.length() - 2);
            strings.add(string);
        }
        return strings;
    }

    public void dfs(TreeNode root) {
        System.out.println(root.val);
        if (root.right == null && root.left == null) {
            ArrayList<Integer> list = new ArrayList<>();
            for (TreeNode node : tempList) {
                list.add(node.val);
            }
            res.add(list);
            return;
        }
        if (root.left != null) {
            tempList.add(root.left);
            dfs(root.left);
            tempList.remove(tempList.size() - 1);
        }

        if (root.right != null) {
            tempList.add(root.right);
            dfs(root.right);
            tempList.remove(tempList.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
