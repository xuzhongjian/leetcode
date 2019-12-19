package com.thisxzj.leetcode.easy;

/**
 * date    2019-09-11
 * time    14:38
 *
 * @author thisxzj - 中建
 * <p>
 * "https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/"
 * [1,3,5,4,7]
 */


public class LongestContinuousIncreasingSubSequence {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 4, 3, 7};
        System.out.println(findLengthOfLCIS(nums));
    }

    public static int findLengthOfLCIS(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int[] cnt = new int[length];
        cnt[0] = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i] > nums[i - 1]) {
                cnt[i] = cnt[i - 1] + 1;
            } else {
                cnt[i] = 1;
            }
        }
        int max = 0;
        for (int i : cnt) {
            System.out.print(i + " ");
            max = Math.max(i, max);
        }
        return max;
    }
}
