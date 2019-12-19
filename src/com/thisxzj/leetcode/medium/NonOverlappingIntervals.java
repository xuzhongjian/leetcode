package com.thisxzj.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * date    2019-09-22
 * time    14:53
 *
 * @author thisxzj - 中建
 * "https://leetcode-cn.com/problems/non-overlapping-intervals/submissions/"
 */


public class NonOverlappingIntervals {
    public static void main(String[] args) {

    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        int length = intervals.length;
        if (length <= 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int cnt = 0;
        int end = intervals[0][1];
        for (int i = 1; i < length; i++) {
            if (intervals[i][0] >= end) {
                cnt++;
                end = intervals[i][1];
            }
        }
        return length - cnt - 1;
    }
}
