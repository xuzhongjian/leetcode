### 解题思路：
1、我们定义两个指针，分别称之为 `g(guard 守卫)` 和 `p(point)`。
我们首先根据方法的参数 `m` 确定 `g` 和 `p` 的位置。将 `g` 移动到第一个要反转的节点的前面，将 `p` 移动到第一个要反转的节点的位置上。我们以 `m=2`，`n=4`为例。

![1.png](https://pic.leetcode-cn.com/5389db651086bd4bcd42dd5c4552f180b553a9b204cfc1013523dfe09beac382-1.png)



2、将 `p` 后面的元素删除，然后添加到 `g` 的后面。也即头插法。
![2.png](https://pic.leetcode-cn.com/db22bdb60035e45f8c354b3f45f2a844260d6cafcf81528d2c4f1b51e484fb45-2.png)

3、根据     `m` 和 `n` 重复步骤（2）
4、返回d `ummyHead.next`

``` Java []
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode g = dummyHead;
        ListNode p = dummyHead.next;

        int step = 0;
        while (step < m - 1) {
            g = g.next; p = p.next;
            step ++;
        }

        for (int i = 0; i < n - m; i++) {
            ListNode removed = p.next;
            p.next = p.next.next;

            removed.next = g.next;
            g.next = removed;
        }

        return dummyHead.next;
    }
}
```

