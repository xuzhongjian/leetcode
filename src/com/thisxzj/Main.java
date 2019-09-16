package com.thisxzj;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        in.nextLine();
        String line = in.nextLine();
        String[] s = line.split(" ");
        int length = s.length;
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        System.out.println(func(nums, k));
    }


    public static int func(int[] A, int K) {
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
