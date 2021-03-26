//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
// 注意:
//
//
// 每个数组中的元素不会超过 100
// 数组的大小不会超过 200
//
//
// 示例 1:
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
//
//
//
//
// 示例 2:
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
//
//
//
// Related Topics 动态规划
// 👍 701 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        int sumAll = Arrays.stream(nums).sum();
        if (sumAll % 2 == 1) {
            return false;
        }
        int target = sumAll / 2;
        boolean[] dp = new boolean[target + 1];
        // dp[num]: 在数组中能否有一些数字加起来为num
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            int add = nums[i];
            for (int targetIter = target; targetIter >= add; targetIter--) {
                dp[targetIter] = dp[targetIter] || dp[targetIter - add];
            }
        }
        return dp[target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
