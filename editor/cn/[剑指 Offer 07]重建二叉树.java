//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//                   0 1 2  3 4
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int treeSize = preorder.length;
        return subBuildTree(preorder, 0, treeSize, inorder, 0, treeSize);
    }

    /**
     * @param preorder 前序
     * @param pStart   前序开始
     * @param pEnd     前序截止
     * @param inorder  中序
     * @param iStart   中序开始
     * @param iEnd     中序截止
     * @return
     */
    public TreeNode subBuildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pEnd - pStart < 1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pStart]);

        // 在中序遍历中的 root 节点的index
        int rootIndex = indexOf(inorder, iStart, iEnd, preorder[pStart]);
        // 前部分长度
        int prePartLenght = rootIndex - iStart;
        // 后部分长度
        int backPartLength = pEnd - pStart - prePartLenght - 1;

        root.left = subBuildTree(preorder, pStart + 1, pStart + 1 + prePartLenght, inorder, iStart, iStart + prePartLenght);
        root.right = subBuildTree(preorder, pStart + 1 + prePartLenght, pEnd, inorder, iStart + prePartLenght + 1, iEnd);
        return root;
    }

    public int indexOf(int[] nums, int start, int end, int target) {
        for (int i = start; i < end; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
