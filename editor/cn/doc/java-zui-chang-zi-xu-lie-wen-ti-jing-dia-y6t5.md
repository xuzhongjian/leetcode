### 解题思路
> 首先，初始化dp数组：
>>  以当前元素作为子序列的开头，计算dp数组
> 
> 其次，根据之前的状态值，计算当前状态值
> 为了简化之后的从 dp数组中取最大值，我们可以定义一个allMax变量，在循环时就判断
> 最终，返回allMax即可

### 运行结果
![image.png](https://pic.leetcode-cn.com/1607148430-kRMIvh-image.png)

### 代码

```java
class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length <= 0 || pairs[0].length <= 0) {
            return 0;
        }

        Arrays.sort(pairs, (pair1, pair2) -> (pair1[0] - pair2[0]));
        int length = pairs.length;
        int[] dp = new int[length];
        //Arrays.fill(dp, 1);
        dp[0] = 1;
        int allMax = Integer.MIN_VALUE;
        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            allMax = Math.max(allMax, dp[i]);
        }
        return allMax;
    }
}
```
打卡135天，加油！！！
今天是 模块化刷算法 的第五天，敬请关注本人 模块化题解-动态规划专题 博文：
[《【算法精研】动态规划 总集篇》](https://www.cnblogs.com/codderYouzg/p/14067635.html)