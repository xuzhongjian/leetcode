//给定一个整数 n，返回 n! 结果尾数中零的数量。 
//
// 示例 1: 
//
// 输入: 3
//输出: 0
//解释: 3! = 6, 尾数中没有零。 
//
// 示例 2: 
//
// 输入: 5
//输出: 1
//解释: 5! = 120, 尾数中有 1 个零. 
//
// 说明: 你算法的时间复杂度应为 O(log n) 。 
// Related Topics 数学 
// 👍 452 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    int count = 0;

    public int trailingZeroes(int n) {
        for (int i = 1; i <= n; i++) {
            countNum(i);
        }
        return count;
    }

    public void countNum(int i) {
        while (i % 10 == 0) {
            i /= 10;
            count++;
        }
        while (i % 5 == 0) {
            i /= 5;
            count++;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
