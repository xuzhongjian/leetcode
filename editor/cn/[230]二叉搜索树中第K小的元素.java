//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,1,4,null,2], k = 1
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 。 
// 1 <= k <= n <= 104 
// 0 <= Node.val <= 104 
// 
//
// 
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？ 
// Related Topics 树 二分查找 
// 👍 368 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.PriorityQueue;

class Solution {

    private PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public int kthSmallest(TreeNode root, int k) {
        buildHeap(root, k);
        System.out.println(pq.size());
        return pq.peek();
    }

    public void buildHeap(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        buildHeap(root.left, k);
        if (pq.size() < k) {
            pq.add(root.val);
        } else {
            if (root.val < pq.peek()) {
                pq.poll();
                pq.add(root.val);
            }
        }
        buildHeap(root.right, k);
    }

}

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode() {
//    }
//
//    TreeNode(int val) {
//        this.val = val;
//    }
//
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
