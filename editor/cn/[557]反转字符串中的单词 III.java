//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 字符串 
// 👍 279 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                int index = indexOf(chars, i, ' ');
                // 局部反转
                swapBetween(chars, i, index - 1);
                i = index;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            sb.append(aChar);
        }
        return sb.toString().trim();
    }

    public void swapBetween(char[] chars, int index1, int index2) {
        int length = index2 - index1 + 1;
        for (int i = index1; i < index1 + length / 2; i++) {
            int j = index2 - (i - index1);
            char aChar = chars[i];
            chars[i] = chars[j];
            chars[j] = aChar;
        }
    }

    public int indexOf(char[] chars, int begin, char c) {
        for (int i = begin; i < chars.length; i++) {
            if (chars[i] == c) {
                return i;
            }
        }
        return chars.length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
