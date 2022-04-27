### 解题思路
干了这篇题解，思路都在代码和注释里了。Cheers!
相似题目：[543. 二叉树的直径](https://leetcode-cn.com/problems/diameter-of-binary-tree/)
对应题解：[543. 二叉树的直径【递归】](https://leetcode-cn.com/problems/diameter-of-binary-tree/solution/543-er-cha-shu-de-zhi-jing-by-celestezep-naki/)

### 复杂度分析
- 时间复杂度：*O(N)*。
- 空间复杂度：*O(N)*。

### 代码

```java
class Solution {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        //更新max
        dfs(root);
        //返回
        return max;
    }

    //计算并返回从当前根节点出发的最大左或右子树节点的路径和，同时实时更新最大左右子树路径和
    public int dfs(TreeNode root){
        if(root == null) return 0;
        //当前节点的左孩子节点的最大子路径和（注意舍弃掉和小于0的路径）
        int leftSum = Math.max(0, dfs(root.left));
        //当前节点的右孩子节点的最大子路径和
        int rightSum = Math.max(0, dfs(root.right));
        //更新最大路径和（最大左路径和+最大右路径和+当前节点值）
        max = Math.max((leftSum + rightSum + root.val), max);
        //返回从当前节点出发的最大左/右路径和
        return Math.max(leftSum, rightSum) + root.val;
    }
}
```