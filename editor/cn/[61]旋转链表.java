//输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//        e

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        int size = 1;
        while (cur.next != null) {
            cur = cur.next;
            size++;
        }
        ListNode end = cur;
        k = k % size;
        int steps = size - k;

        cur.next = head;
        while (steps > 0) {
            cur = cur.next;
            steps--;
        }
        ListNode res = cur.next;
        cur.next = null;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
