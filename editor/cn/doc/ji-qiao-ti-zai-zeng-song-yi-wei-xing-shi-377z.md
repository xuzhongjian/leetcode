## 一、思路解析

这道题目很简单：**先以对角线（左上<—>右下）为轴进行翻转，再对每行左右翻转即可。**

> 这是一道重复的题目，还有 [面试题 01.07. 旋转矩阵](https://leetcode-cn.com/problems/rotate-matrix-lcci/solution/jian-dan-java-yuan-di-shuang-bai-by-sweetiee/)。一题顶俩题！

如下图，先以对角线 `[1, 5, 9]` 为轴进行翻转：
![image.png](https://pic.leetcode-cn.com/7c85f9932eeae5a454cd0e825106c972c719ed4401f7ab62bc4092c7239ff41b-image.png)

于是数组变成了：
```
[1,4,7]
[2,5,8]
[3,6,9]
```

再对每一行以中点进行翻转，就得到了最终结果：

```
[7,4,1]
[8,5,2]
[9,6,3]
```

## 二、代码实现
```Java []
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 先以对角线（左上-右下）为轴进行翻转
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 再对每一行以中点进行翻转
        int mid = n >> 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mid; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }
}
```

时间复杂度：*O(n^2)*。翻转 2 次每次都是操作 *n^2* 次。
空间复杂度：*O(1)*。都是原地翻转。


## 三、思维扩展

本题是「旋转二维数组」，如果是「旋转一维数组」呢？

**题目：**
给定一个长度为 n 的一维数组，将前 k 个数移动到末尾。要求 **原地** 操作，该如何实现？

**样例：**
```
输入: 1, 2, 3, 4, 5, 6, 7
输出: 4, 5, 6, 7, 1, 2, 3
```

**实现方法：**
1. 前 k 个原地翻转
2. 后 n - k 个原地翻转
3. 整体原地翻转

我们看下这个算法为什么是生效的：

```
1, 2, 3, 4, 5, 6, 7

前 k 个原地翻转：
3, 2, 1, 4, 5, 6, 7

后 n - k 个原地翻转：
3, 2, 1, 7, 6, 5, 4

整体原地翻转：
4, 5, 6, 7, 1, 2, 3
```

## 🤔 是不是很神奇？

---

### 关于我

❤️ 欢迎大佬们随手关注下我的公众号【[甜姨的奇妙冒险](https://sweeetiee-1256505723.cos.ap-beijing.myqcloud.com/sweetiee_wechat.jpeg)】和 知乎专栏【[甜姨的力扣题解](https://zhuanlan.zhihu.com/c_1224355183452614656)】❤️