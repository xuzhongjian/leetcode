package com.thisxzj.leetcode;

import java.util.Arrays;

/**
 * date    2019-09-11
 * time    11:02
 *
 * @author thisxzj - 中建
 * <p>
 * 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择 x = -K 或是 x = K，并将 x 加到 A[i] 中。
 * <p>
 * 在此过程之后，我们得到一些数组 B。
 * <p>
 * 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-range-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 输入：A = [1,3,6], K = 3
 * 输出：3
 * 解释：B = [4,6,3]
 * <p>
 * 我不会
 */


public class SmallestRangeII {
    public static void main(String[] args) {

        int[] a = {1, 3, 6};
        System.out.println(smallestRangeII(a, 3));
    }

    public static int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int n = A.length;
        int res = A[n - 1] - A[0];
        for (int i = 1; i < n; i++) {
            int i1 = A[0] + K;
            int i2 = A[i] - K;
            int i3 = A[n - 1] - K;
            int i4 = A[i - 1] + K;

            int min = i1 < i2 ? i1 : i2;
            int max = i3 > i4 ? i3 : i4;
            res = Math.min(max - min, res);
        }
        return res;
    }
}
