//给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 动态规划 
// 👍 850 👎 0


import java.util.HashSet;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private boolean[] dp;
    private HashSet<String> set = new HashSet<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        // 1. 将字典放入一个hashSet中，并且计算出字典中最长和最短的单词
        dp = new boolean[s.length()];
        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;
        for (String ss : wordDict) {
            set.add(ss);
            minLength = Math.min(minLength, ss.length());
            maxLength = Math.max(maxLength, ss.length());
        }

        for (int i = 0; i < s.length(); i++) {
            dp[i] = dpFunc(s, minLength, maxLength, i);
        }
        return dp[s.length() - 1];
    }

    /**
     * dp，计算对应的位置是否可以由字典组成
     *
     * @param s              源字符
     * @param dictRangeStart 字典最短的字符 [1,++)
     * @param dictRangeEnd   字典最长的字符 [1,++)
     * @param index          计算从s.(0) 到s.(index) 能否用字典完成 [0,length-1]
     * @return boolean
     */
    public boolean dpFunc(String s, int dictRangeStart, int dictRangeEnd, int index) {

        /**
         * 按照字典的长度开始遍历，截取s.(index)前字典长度个字符，判断在不在字典中
         * 在：s.(0) 到s.(index) 可以由字典完成
         * 不在：不能有字典完成
         * i：在s中截取的单词的长度
         */
        for (int subLength = dictRangeStart; subLength <= dictRangeEnd; subLength++) {
            // 单词匹配的起点
            int matchStart = index - subLength + 1;
            // 如果单词匹配的起点
            // 1. 小于 0
            // 2. 起点刚好为零就不用管dp数组了
            if (matchStart < 0 || (matchStart != 0 && !dp[matchStart - 1])) {
                continue;
            }

            // 把index之前长度为subLength的字符串抠出来，然后在set中找，如果set包含就说明存在
            String substring = s.substring(matchStart, matchStart + subLength);
            if (set.contains(substring)) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
