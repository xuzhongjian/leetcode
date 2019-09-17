package com.thisxzj;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = input.nextInt();
        }
        int[] cnt = new int[size];
        for (int i = 0; i < size; i++) {
            if (i == 0 || nums[i] < nums[i - 1]) {
                cnt[i] = 1;
            } else {
                cnt[i] = cnt[i - 1] + 1;
            }
        }
//        for (int i = 0; i < size; i++) {
//            System.out.print(cnt[i] + " ");
//        }
//        System.out.println();


        int max = 0;
        for (int i = 0; i < size; i++) {
            if (cnt[i] == 1 && i != 0) {
                if (nums[i] > nums[i - 2] + 1) {
                    int j = i;
                    while (true) {
                        if (j == size - 1) {
                            break;
                        }
                        if (cnt[j] > cnt[j - 1]) {
                            j++;
                        } else {
                            break;
                        }
                    }

                    System.out.println(max + " " + (cnt[i - 1] + cnt[j - 1]));
                    max = Math.max(max, cnt[i - 1] + cnt[j - 1]);

                }
            }
        }
        System.out.println(max);
    }
}
