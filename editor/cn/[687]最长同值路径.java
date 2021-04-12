//给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。 
//
// 注意：两个节点之间的路径长度由它们之间的边数表示。 
//
// 示例 1: 
//
// 输入: 
//
// 
//              5
//             / \
//            4   5
//           / \   \
//          1   1   5
// 
//
// 输出: 
//
// 
//2
// 
//
// 示例 2: 
//
// 输入: 
//
// 
//              1
//             / \
//            4   5
//           / \   \
//          4   4   5
// 
//
// 输出: 
//
// 
//2
// 
//
// 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。 
// Related Topics 树 递归 
// 👍 441 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int res = 0;

    public int longestUnivaluePath(TreeNode node) {
        dfs(node);
        return res;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        int resLeft = 0;
        int resRight = 0;
        if (node.left != null && node.left.val == node.val) {
            resLeft = left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            resRight = right + 1;
        }
        res = Math.max(res, resLeft + resRight);
        return Math.max(resLeft, resRight);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
