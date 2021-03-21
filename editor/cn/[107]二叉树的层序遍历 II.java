//给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层序遍历为： 
//
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 420 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    // 当前层
    private LinkedList<TreeNode> levelList = new LinkedList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        levelList.addLast(root);
        iterByLevel();
        return res;
    }

    public void iterByLevel() {
        // 准答案层
        LinkedList<Integer> resLevelList = new LinkedList<>();
        // 下一层
        LinkedList<TreeNode> nextLevelList = new LinkedList<>();

        while (!levelList.isEmpty()) {
            while (!levelList.isEmpty()) {
                TreeNode node = levelList.pollFirst();
                resLevelList.addLast(node.val);

                if (node.left != null) nextLevelList.add(node.left);
                if (node.right != null) nextLevelList.add(node.right);
            }
            levelList.addAll(nextLevelList);
            res.add(new ArrayList<>(resLevelList));
            nextLevelList.clear();
            resLevelList.clear();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
