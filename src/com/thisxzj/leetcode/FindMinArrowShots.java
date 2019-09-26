package com.thisxzj.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * date    2019-09-22
 * time    15:17
 *
 * @author thisxzj - 中建
 * "https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/"
 */


public class FindMinArrowShots {
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int cnt = 1, end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                continue;
            }
            cnt++;
            end = points[i][1];
        }
        return cnt;
    }
}
