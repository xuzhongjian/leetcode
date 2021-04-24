//给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[
//j]) 都应当满足：
// 
// answer[i] % answer[j] == 0 ，或 
// answer[j] % answer[i] == 0 
// 
//
// 如果存在多个有效解子集，返回其中任何一个均可。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,2]
//解释：[1,3] 也会被视为正确答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,4,8]
//输出：[1,2,4,8]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 2 * 109 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数学 动态规划 
// 👍 241 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[][] res = new int[nums.length][nums.length];


        for (int i = 0; i < nums.length; i++) {
            int maxLength = 0;
            for (int j = 0; j <= i; j++) {
                List<Integer> temp = new ArrayList<>();
                if (isDivisible(nums[i], nums[j])) {
                    List<Integer> list = map.get(j);
                    if (maxLength < list.size() + 1) {
                        temp.addAll(list);
                        temp.add(nums[j]);
                    }
                    maxLength = Math.max(maxLength, dp[j] + 1);
                }
            }
            dp[i] = maxLength;
            System.out.println(i + " " + maxLength);
        }
        return new ArrayList<Integer>();
    }

    public boolean isDivisible(int i, int j) {
        return i > j ? i % j == 0 : j % i == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
