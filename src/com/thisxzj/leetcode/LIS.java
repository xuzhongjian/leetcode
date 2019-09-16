package com.thisxzj.leetcode;

import java.util.Scanner;

import static java.lang.Math.max;

/**
 * date    2019-09-11
 * time    14:55
 *
 * @author thisxzj - 中建
 */


public class LIS {
    /**
     * 测试数据: 6 4 2 3 1 5 6 输出4
     */
    public static void main(String[] args) {
        int[] array = {6, 4, 2, 3, 1, 5, 6};

        System.out.println(solution(array));

    }

    private static int solution(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int cnt = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    cnt = max(cnt, dp[j] + 1);
                }
            }
            dp[i] = cnt;
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = max(max, dp[i]);
        }
        return max;
    }
}
