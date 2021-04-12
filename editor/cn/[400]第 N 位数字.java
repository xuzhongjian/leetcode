//在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 位数字。 
//
// 
//
// 注意：n 是正数且在 32 位整数范围内（n < 231）。 
//
// 
//
// 示例 1： 
//
// 
//输入：3
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：11
//输出：0
//解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
// 
// Related Topics 数学 
// 👍 149 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNthDigit(int n) {
        long num = n;

        long size = 1;
        long max = 9;

        while (n > 0) {
            //判断不在当前位数内
            if (num - max * size > 0) {
                num = num - max * size;
                size++;
                max = max * 10;
            } else {
                long count = num / size;
                long left = num % size;
                if (left == 0) {
                    return (int) (((long) Math.pow(10, size - 1) + count - 1) % 10);
                } else {
                    return (int) (((long) Math.pow(10, size - 1) + count) / ((long) Math.pow(10, (size - left))) % 10);
                }
            }
        }

        return 0;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
