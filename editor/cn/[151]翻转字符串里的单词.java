//给定一个字符串，逐个翻转字符串中的每个单词。 
//
// 说明： 
//
// 
// 无空格字符构成一个 单词 。 
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。 
// 
//
// 
//
// 示例 1： 
//
// 输入："the sky is blue"
//输出："blue is sky the"
// 
//
// 示例 2： 
//
// 输入："  hello world!  "
//输出："world! hello"
//解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 
//
// 示例 3： 
//
// 输入："a good   example"
//输出："example good a"
//解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
// 
//
// 示例 4： 
//
// 输入：s = "  Bob    Loves  Alice   "
//输出："Alice Loves Bob"
// 
//
// 示例 5： 
//
// 输入：s = "Alice does not even like bob"
//输出："bob like even not does Alice"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 包含英文大小写字母、数字和空格 ' ' 
// s 中 至少存在一个 单词
// 
//
// 进阶： 
//
// 
// 请尝试使用 O(1) 额外空间复杂度的原地解法。 
// 
// Related Topics 字符串 
// 👍 296 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        // 全部反转
        swapBetween(chars, 0, s.length() - 1);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                int index = indexOf(chars, i, ' ');
                // 局部反转
                swapBetween(chars, i, index - 1);
                i = index;
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean b = false;
        for (char aChar : chars) {
            if (aChar == ' ') {
                if (b) {
                    continue;
                } else {
                    sb.append(aChar);
                    b = true;
                }
            }
            if (aChar != ' ') {
                sb.append(aChar);
                b = false;
            }
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
