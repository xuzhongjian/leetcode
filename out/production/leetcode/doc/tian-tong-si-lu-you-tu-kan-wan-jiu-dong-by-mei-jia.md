# 思路

要算出最短时间，就要思考如何安排任务可以得到最短时间

首先算出每个任务的个数，并排序。接着当然是安排个数最大的任务，并且附带间隔，这个过程类型填桶的过程

## 任务种类较少，填不满桶时（桶是图蓝色部分）

假设有 5  个 A，5 个 B， 2 个 C

**注意：桶并不是完整的矩形，最后一行由 max count 决定！！**

- **摆列顺序**：先放任务个数大的，再放小的；从上到下，从左到右放，如图（ - 代表待命）。

- **执行顺序**：左到右，上到下

![image.png](https://pic.leetcode-cn.com/1599234115-CZJhkx-image.png)


- **分析可行性**：**由于高度是最大值，不可能存在同一行出现相同的任务**，而宽度为 n + 1，符合要求，最短时间很明显主要由最后一行的个数（maxCount）决定
- **最短时间**：(n + 1) * (max - 1) + maxCount，**也就是桶的大小**

## 任务种类较多，桶放不下时

假设有 5  个 A，5 个 B， 3 个 C，2 个 D，2 个 E，2 个 F，1 个 G

- **摆放顺序**：在前面的基础上，桶不够时往桶右边补，顺序仍然是从上到下，从左到右放，如图（浅色部分是桶外）

- **执行顺序**：左到右，上到下

![image.png](https://pic.leetcode-cn.com/1599234086-nxWjrW-image.png)


- **分析可行性**：**由于高度是最大值，不可能存在同一行出现相同的任务**，而宽度大于等于 n + 1，符合要求。由于不含待命格子，最短时间很明显由**总任务个数**决定。

- **最短时间**：tasks.length

## 小结

回过头来看，其实两种差别不大，任务的摆放和执行顺序基本一致

- **摆放顺序**：先摆放任务个数多的，从上到下，从左到右摆放

- **执行顺序**：左到右，上到下
- **最短时间**：在填不满桶时，最短时间为` (n + 1) * (max - 1) + maxCount`，也就是桶的大小；在桶放不下时，最短时间是`tasks.length`。综合起来就是它两的最大值。**思路一如果 maxCount > n + 1，由于宽度早已溢出，此时都不需要有填桶这个概念了，你可以直接把这种情况归为思路二**

读到这，如果题目要写一种组合实现最短时间，照着这个思路大家肯定写的出

# 代码

```java
public class Solution {

    public int leastInterval(char[] tasks, int n) {

        int[] counts = new int[26];

        for (char c : tasks) {
            counts[c - 'A'] += 1;
        }

        int max = 0;
        for (int count : counts) {
            max = Math.max(max, count);
        }

        int maxCount = 0;
        for (int count : counts) {
            if (count == max) {
                maxCount++;
            }
        }

        return Math.max((n + 1) * (max - 1) + maxCount, tasks.length);
    }

}
```
