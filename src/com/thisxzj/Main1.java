package com.thisxzj;


/**
 * date    2019-09-17
 * time    16:01
 *
 * @author thisxzj - 中建
 */


public class Main1 {
    public static String longestPalindrome(String s) {
        if (s.length() <= 1)
            return s;
        String longest = s.charAt(0) + "";
        int length = s.length();
        boolean[][] dp = new boolean[length][length];

        for (int j = length - 1; j >= 0; j--) {
            //j在前,i在后
            for (int i = j; i < length; i++) {
                dp[j][i] = s.charAt(i) == s.charAt(j) && ((i - j < 3) || dp[j + 1][i - 1]);
                if (dp[j][i] && i - j + 1 > longest.length()) {
                    longest = s.substring(j, i + 1);
                }
            }
        }
        return longest;
    }

    public static void move(int n, String from, String buffer, String to) {
        if (n == 1) {
            System.out.println("move " + n + " from " + from + " to " + to);
        } else {

            move(n - 1, from, to, buffer);
            move(1, from, buffer, to);
            move(n - 1, buffer, from, to);
        }
    }

}



