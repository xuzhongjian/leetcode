//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。） 
// Related Topics 递归 链表 
// 👍 833 👎 0


import java.util.Objects;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }

        ListNode second = head.next;
        head.next = second.next;
        second.next = head;

        while (Objects.nonNull(head) && Objects.nonNull(head.next)) {
            System.out.println(head.val);
            head = swapNextTwo(head);
        }

        return second;
    }

    /**
     * 交换这个节点之后的两个节点
     *
     * @param node
     * @return
     */
    public ListNode swapNextTwo(ListNode node) {
        ListNode next = null;
        ListNode nextNext = null;
        if (Objects.isNull(node)) {
            return null;
        }
        if (Objects.isNull(next = node.next)) {
            return node;
        }
        if (Objects.isNull(nextNext = next.next)) {
            return next;
        }

        node.next = nextNext;
        next.next = nextNext.next;
        nextNext.next = next;

        return next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
