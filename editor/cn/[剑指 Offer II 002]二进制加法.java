//给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
//
// 示例 1: 
//
// 
//输入: a = "11", b = "10"
//输出: "101" 
//
// 示例 2: 
//
// 
//输入: a = "1010", b = "1011"
//输出: "10101" 
//
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
//
// 
//
// 注意：本题与主站 67 题相同：https://leetcode-cn.com/problems/add-binary/ 
// Related Topics 位运算 数学 字符串 模拟 
// 👍 30 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean flag = false;

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int lengthA = a.length();
        int lengthB = b.length();
        while (i < lengthA || i < lengthB) {
            char ac = i < lengthA ? a.charAt(lengthA - 1 - i) : '0';
            char bc = i < lengthB ? b.charAt(lengthB - 1 - i) : '0';
            sb.append(ans(ac, bc, flag));
            i++;
        }
        if (flag) sb.append('1');
        return sb.reverse().toString();
    }

    public char ans(char a, char b, boolean needAdd) {
        int aa = a - '0';
        int bb = b - '0';
        int i = aa + bb + (needAdd ? 1 : 0);
        flag = (i == 2) || (i == 3);
        return (i == 0 || i == 1) ? (char) ('0' + i) : (char) ('0' + i - 2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
