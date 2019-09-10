package com.thisxzj.company.tencent;

import java.util.Scanner;

/**
 * date    2019-09-10
 * time    00:20
 *
 * @author thisxzj - 中建
 */


public class Main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int times = input.nextInt();
        for (int i = 0; i < times; i++) {
            int width = input.nextInt();
            int height = input.nextInt();
            int[] points = new int[8];
            for (int j = 0; j < 8; j++) {
                points[j] = input.nextInt();
            }

            //计算初始值
            int countOfBlack = width * height / 2;
            int countOfWhite = 0;
            if ((width & 1) == 0 || (height & 1) == 0) {
                countOfWhite = countOfBlack;
            } else {
                countOfWhite++;
            }

            //统计涂白的数量
            if (((points[2] - points[0] + 1) & 1) == 0 && ((points[3] - points[1] + 1) & 1) == 0) {

            }

        }

        System.out.println(Integer.MAX_VALUE);
    }
}
