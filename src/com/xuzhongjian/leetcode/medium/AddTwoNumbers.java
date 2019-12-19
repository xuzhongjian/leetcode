package com.xuzhongjian.leetcode.medium;

import com.xuzhongjian.leetcode.common.ListNode;

/**
 * leetcode No.2
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zjxu97
 * @date 2019/12/19
 */
public class AddTwoNumbers {
    public static void main(String[] args) {

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = null;
        int temp = 0;

        //进位标记
        boolean flag = false;

        ListNode rear = null;
        while (l1 != null || l2 != null) {
            temp = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + (flag ? 1 : 0);
            flag = temp >= 10;
            ListNode innerNode = new ListNode(temp - (flag ? 10 : 0));
            if (ans == null) {
                ans = innerNode;
            } else {
                rear.next = innerNode;
            }
            rear = innerNode;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (flag) {
            rear.next = new ListNode(1);
        }
        return ans;
    }
}
