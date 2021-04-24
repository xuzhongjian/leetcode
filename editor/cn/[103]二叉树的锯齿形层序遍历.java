//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
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
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 407 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> levelList = new LinkedList<>();

        levelList.addLast(root);

        boolean flag = false;
        while (levelList.size() != 0) {
            LinkedList<Integer> curLevelList = new LinkedList<>();
            LinkedList<TreeNode> tempLevelList = new LinkedList<>();

            while (levelList.size() != 0) {
                TreeNode node = flag ? levelList.pollLast() : levelList.pollFirst();
                if (node != null) {
                    curLevelList.add(node.val);
                    if (flag) {
                        tempLevelList.addFirst(node.right);
                        tempLevelList.addFirst(node.left);
                    } else {
                        tempLevelList.addLast(node.left);
                        tempLevelList.addLast(node.right);
                    }
                }
            }
            levelList = tempLevelList;
            if (curLevelList.size() != 0) res.add(curLevelList);

            flag = !flag;
        }
        return res;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
