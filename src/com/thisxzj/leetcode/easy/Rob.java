package com.thisxzj.leetcode.easy;

/**
 * date    2019-09-22
 * time    14:24
 * "https://leetcode-cn.com/problems/house-robber/"
 * @author thisxzj - 中建
 */


public class Rob {
    public static void main(String[] args) {

    }

    public static int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int[] cnt = new int[length];
        cnt[0] = nums[0];
        for (int i = 1; i < length; i++) {
            int touzhejia = nums[i] + (i == 1 ? 0 : cnt[i - 2]);
            int butouzhejia = cnt[i - 1];
            cnt[i] = Math.max(touzhejia, butouzhejia);
        }
        return cnt[length - 1];
    }
}
