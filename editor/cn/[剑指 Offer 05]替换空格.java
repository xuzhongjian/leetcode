//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 88 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            sb.append(aChar != ' ' ? aChar : "%20");
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
