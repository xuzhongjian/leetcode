package com.thisxzj.leetcode.hard;

/**
 * date    2019-09-10
 * time    23:31
 *
 * @author thisxzj - 中建
 * <p>
 * [2,3,1,1,4]
 * <p>
 * 2
 * "https://leetcode-cn.com/problems/jump-game-ii"
 */


public class JumpGameII {

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 1, 4, 1, 1, 1, 5, 1, 1, 1};
        System.out.println(jump(nums));
    }


    public static int jump(int[] nums) {
        int count = 0;
        int maxPos = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            maxPos = Math.max(maxPos, nums[i] + i);
            if (i == end) {
                end = maxPos;
                count++;
            }
        }
        return count;
    }

}
