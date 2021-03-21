//给定一个二叉树 
//
// 
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。 
//
// 初始状态下，所有 next 指针都被设置为 NULL。 
//
// 
//
// 进阶： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
// 
//
// 
//
// 示例： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,null,7]
//输出：[1,#,2,3,#,4,5,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指
//针连接），'#' 表示每层的末尾。 
//
// 
//
// 提示： 
//
// 
// 树中的节点数小于 6000 
// -100 <= node.val <= 100 
// 
//
// 
//
// 
// 
// Related Topics 树 深度优先搜索 
// 👍 378 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

import java.util.List;

class Solution {

    // 当前层
    private LinkedList<Node> levelList = new LinkedList<>();
    private List<List<Node>> res = new ArrayList<>();

    public Node connect(Node root) {
        List<List<Node>> lists = levelOrder(root);
        for (List<Node> list : lists) {
            for (int i = 0; i < list.size() - 1; i++) {
                Node node1 = list.get(i);
                Node node2 = list.get(i + 1);
                node1.next = node2;
            }
        }

        return root;
    }

    public List<List<Node>> levelOrder(Node root) {
        if (root != null) {
            levelList.addLast(root);
            iterByLevel();
        }
        return res;
    }

    public void iterByLevel() {
        // 准答案层
        LinkedList<Node> resLevelList = new LinkedList<>();
        // 下一层
        LinkedList<Node> nextLevelList = new LinkedList<>();

        while (!levelList.isEmpty()) {
            while (!levelList.isEmpty()) {
                Node node = levelList.pollFirst();
                resLevelList.addLast(node);

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
