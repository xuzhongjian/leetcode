//给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。 
//
// 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。 
//
// 
//
// 示例 1： 
//
// 输入：a = "abcd", b = "cdabcdab"
//输出：3
//解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
// 
//
// 示例 2： 
//
// 输入：a = "a", b = "aa"
//输出：2
// 
//
// 示例 3： 
//
// 输入：a = "a", b = "a"
//输出：1
// 
//
// 示例 4： 
//
// 输入：a = "abc", b = "wxyz"
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length <= 104 
// 1 <= b.length <= 104 
// a 和 b 由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 138 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int repeatedStringMatch(String a, String b) {
        int indexA = 0;
        int indexB = 0;
        boolean isMatch = false;
        boolean isPerfectMatch = true;
        int res = 0;
        while (true) {
            if (indexA == a.length()) {
                if (!isMatch) {
                    return -1;
                } else {
                    indexA = 0;
                    res++;
                }
            }

            if (indexB == b.length()) {
                break;
            }

            if (a.charAt(indexA) != b.charAt(indexB)) {
                indexA++;
                isMatch = false;
                isPerfectMatch = false;
            } else {
                indexA++;
                indexB++;
                isMatch = true;
            }
        }

        if (a.length() > b.length()) {
            return res + 1;
        }
        return (isPerfectMatch) ? res : res + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
