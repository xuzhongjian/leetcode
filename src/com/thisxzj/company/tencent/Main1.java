package com.thisxzj.company.tencent;

import java.util.Scanner;

/**
 * date    2019-09-09
 * time    23:58
 *
 * @author thisxzj - 中建
 */

/*
        腾讯第一题，跳楼层和爬楼层
 */

public class Main1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int ranks = input.nextInt();
        int[] heights = new int[ranks];
        for (int i = 0; i < ranks; i++) {
            heights[i] = input.nextInt();
        }
        int[] jump = new int[ranks];
        int[] climb = new int[ranks];
        // 第 0 层时间肯定都是 0
        // 爬到第一层的时间就是第一层的高度
        // 跳到第一层的时间也是 0 ，由于考虑到越界，所以 continue 了
        for (int i = 1; i < ranks; i++) {
            //如果是爬到第 i 层，那么这个所用的时间是上一层时间的较优解。
            climb[i] = Math.min(climb[i - 1], jump[i - 1]) + heights[i];
            if (i == 1) {
                continue;
            }
            //如果是跳到第 i 层，那么上一次的动作一定是爬
            jump[i] = Math.min(climb[i - 1], climb[i - 2]);
        }
        System.out.println(Math.min(climb[ranks - 1], jump[ranks - 1]));

    }
}
