//给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= 
//t ，同时又满足 abs(i - j) <= k 。 
//
// 如果存在则返回 true，不存在返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3, t = 0
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,0,1,1], k = 1, t = 2
//输出：true 
//
// 示例 3： 
//
// 
//输入：nums = [1,5,9,1,5,9], k = 2, t = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 2 * 104 
// -231 <= nums[i] <= 231 - 1 
// 0 <= k <= 104 
// 0 <= t <= 231 - 1 
// 
// 👍 378 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * dp[i][j] 表示从第i到j位之间的最大差
     */
    private int[][] dp;

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums[0].length; j++) {
                if (j - i > k) {
                    dp[i][j] = 0;
                }
                fullDp(nums, i, j);
            }
        }
    }

    public int fullDp(int[] nums, int i, int j) {
        int res = 0;
        if (i == j) {
            return res;
        } else {
            dp[i][j] =
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
