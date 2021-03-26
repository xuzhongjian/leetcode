//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 118 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        int[] res = new int[size];

        cur = head;
        int count = 0;
        while (cur != null) {
            res[size-count-1] = cur.val;
            count++;
            cur = cur.next;
        }
        return res;
    }
}
//
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
