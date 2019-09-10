package com.thisxzj.company.bytedance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * date    2019-09-10
 * time    09:04
 *
 * @author thisxzj - 中建
 */


public class Main2 {

    public static void main(String[] args) {
        FileInputStream file;
        try {
            file = new FileInputStream("/Users/thisxzj/GitHub/my-leetcode/src/com/thisxzj/company/bytedance/main2.txt");
        } catch (FileNotFoundException e) {
            return;
        }
        Scanner in = new Scanner(file);
        // 城市数目
        int cityNum = in.nextInt();
        // 距离矩阵 距离为欧式空间距离 表示车费
        int[][] dist = new int[cityNum][cityNum];
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < cityNum; j++) {
                dist[i][j] = in.nextInt();
            }
        }
        in.close();

        // 对1进行左移n-1位 值刚好等于2^(n-1)
        int v = 1 << (cityNum - 1);
        // dp表，n行，2^(n-1)列
        int[][] dp = new int[cityNum][v];
        // 初始化dp表第一列
        for (int i = 0; i < cityNum; i++) {
            dp[i][0] = dist[i][0];
        }
        //设想一个数组城市子集V[j]，长度为V,且V[j] = j,对于V[j]即为压缩状态的城市集合
        //从1到V-1  用二进制表示的话，刚好可以映射成除了0号城市外的剩余n-1个城市在不在子集V[j]，1代表在，0代表不在
        //若有总共有4个城市的话，除了第0号城市，对于1-3号城市
        //111 = v-1 = 2^3 - 1  = 7 ，从高位到低位表示3到1号城市都在子集中
        //而101 = 5 ，表示3,1号城市在子集中，而其他城市不在子集中
        //这里j不仅是dp表的列坐标值，如上描述，j的二进制表示城市相应城市是否在子集中
        for (int j = 1; j < v; j++) {
            //这个i不仅代表城市号，还代表第i次迭代
            for (int i = 0; i < cityNum; i++) {
                //为了方便求最小值,先将其设为最大值
                dp[i][j] = Integer.MAX_VALUE;
                if (((j >> (i - 1)) & 1) == 0) {
                    // 因为j就代表城市子集V[j],((j >> (i - 1))是把第i号城市取出来
                    // 并位与上1，等于0，说明是从i号城市出发，经过城市子集V[j]，回到起点0号城市
                    // 这里要求经过子集V[j]里的城市回到0号城市的最小距离
                    for (int k = 1; k < cityNum; k++) {
                        //遍历城市子集V[j]
                        if (((j >> (k - 1)) & 1) == 1) {
                            //设s=j ^ (1 << (k - 1))
                            //dp[k][j ^ (1 << (k - 1))，是将dp定位到，从k城市出发，经过城市子集V[s]，回到0号城市所花费的最小距离
                            //怎么定位到城市子集V[s]呢，因为如果从k城市出发的，经过城市子集V[s]的话
                            //那么V[s]中肯定不包含k了，那么在j中把第k个城市置0就可以了，而j ^ (1 << (k - 1))的功能就是这个
                            //^异或
                            dp[i][j] = Math.min(dp[i][j], dist[i][k] + dp[k][j ^ (1 << (k - 1))]);
                            //还有怎么保证dp[k][j ^ (1 << (k - 1))]的值已经得到了呢，
                            //注意所有的计算都是以dp表为准，从左往右从上往下的计算的，每次计算都用到左边列的数据
                            //而dp表是有初试值的，所以肯定能表格都能计算出来
                        }
                    }
                }
            }
        }
        System.out.println(dp[0][v - 1]);
    }
}