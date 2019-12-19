package com.xuzhongjian.leetcode.medium;

/**
 * "https://leetcode-cn.com/problems/coin-change/"
 * date    2019-09-10
 * time    20:54
 *
 * @author thisxzj - 中建
 */

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    /**
     * @param coins 有哪些种类的硬币
     * @param rem   还剩下需要被凑的钱数
     * @param count 凑 i 元钱，最多有 count[ i - 1 ] 种凑法
     * @return 凑够 rem 的额最多的凑法
     */
    public static int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        count[rem - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return count[rem - 1];

    }

}