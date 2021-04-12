//给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。 
//
// 
//
// 示例： 
//
// 输入: root = [4,2,6,1,3,null,null]
//输出: 1
//解释:
//注意，root是树节点对象(TreeNode object)，而不是数组。
//
//给定的树 [4,2,6,1,3,null,null] 可表示为下图:
//
//          4
//        /   \
//      2      6
//     / \    
//    1   3  
//
//最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。 
//
// 
//
// 注意： 
//
// 
// 二叉树的大小范围在 2 到 100。 
// 二叉树总是有效的，每个节点的值都是整数，且不重复。 
// 本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 
//相同 
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 116 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.Objects;

class Solution {

    private int res = Integer.MAX_VALUE;
    private LinkedList<TreeNode> tempList = new LinkedList<>();

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode node) {
        if (tempList.size() == 2) {
            res = Math.min(res, Math.abs(tempList.peekFirst().val - tempList.peekLast().val));
            return;
        } else if (Objects.isNull(node)) {
            return;
        }
        dfs(node.right);
        dfs(node.left);

        tempList.addLast(node);
        dfs(node.right);
        dfs(node.left);
        tempList.removeLast();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
