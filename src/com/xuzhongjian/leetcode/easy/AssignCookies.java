package com.xuzhongjian.leetcode.easy;

import java.util.Arrays;

/**
 * date    2019-09-11
 * time    10:51
 *
 * @author thisxzj - 中建
 * leetcode - 455
 * "https://leetcode-cn.com/problems/assign-cookies/"
 */


public class AssignCookies {
    public static void main(String[] args) {
        int[] g = {10, 9, 8, 7};
        int[] s = {5, 6, 7, 8};
        Arrays.sort(g);
        Arrays.sort(s);
        System.out.println(findContentChildren(g, s));
    }

    /**
     * @param g 孩子的胃口
     * @param s 饼干
     * @return 满足的孩子的个数
     */
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gLength = g.length;
        int sLength = s.length;
        int gIndex = 0;
        int sIndex = 0;
        int cnt = 0;
        while (true) {
            if (gIndex >= gLength || sIndex >= sLength) {
                return cnt;
            } else {
                if (s[sIndex] >= g[gIndex]) {
                    cnt++;
                    sIndex++;
                    gIndex++;
                } else {
                    sIndex++;
                }
            }
        }

    }
}
