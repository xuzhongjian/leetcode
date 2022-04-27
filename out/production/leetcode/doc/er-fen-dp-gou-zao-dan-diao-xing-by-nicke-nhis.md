### 思路

二维转一维

朴素dp：

    dp[] 存 以当前字母结尾能达到的最长递增子序列

    每个字母都遍历 左边所有 dp[] 找到最大的那个 + 1 
    
    没有就是 本体 1

抓住`单调性`

二分dp：
    
    搞一个end[i] 用来存放 所有长度位 i + 1 的递增子序列的 最小结尾 
    
    二分查找end的有小区 如果有 更小 更新 

    搞一个 满足当前长度 且 结尾最小数字的数组 他单调就有二段性 懂得都懂

    如果有 大于最长的最小数字 拓展长度 

    如果没有 更新当前数能组成的最长的最后一位 `二分查找

### Code
```java
    class Solution {
        public int maxEnvelopes(int[][] matrix) {
            // 宽度不等时 宽度升序 相等时长度降序
            Arrays.sort(matrix, (o1, o2) -> (o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1]));
            // ends 数组是用 记录 长度为 index + 1 最小的结尾
            int[] ends = new int[matrix.length];
            ends[0] = matrix[0][1];
            // 用二分效率高
            int right = 0;
            int l = 0;
            int r = 0;
            int m = 0;
            for (int i = 1; i < matrix.length; i++) {
                l = 0;
                r = right;
                while (l <= r) {
                    m = (l + r) / 2;
                    if (matrix[i][1] > ends[m]) {
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }
                right = Math.max(right, l);
                ends[l] = matrix[i][1];
            }
            return right + 1;
        }
    }
```