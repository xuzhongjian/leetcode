//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 深度优先搜索 动态规划 回溯算法 
// 👍 650 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<String>> res = new ArrayList<>();
    private LinkedList<String> tempList = new LinkedList<>();

    public List<List<String>> partition(String s) {
        if (s.length() > 0) {
            tempList.add("" + s.charAt(0));
            dfs(s, 1);
        }
        return res;
    }

    public void dfs(String s, int index) {
        if (index == s.length()) {
            boolean b = true;
            for (String str : tempList) {
                if (!isValid(str)) {
                    b = false;
                    break;
                }
            }
            if (b) {
                res.add(new ArrayList<>(tempList));
            }
            return;
        }
        // 作为一个新字符串的第一位
        tempList.addLast("" + s.charAt(index));
        dfs(s, index + 1);
        tempList.removeLast();


        // 黏到最后一个字符串的后面
        String temps = tempList.size() == 0 ? "" : tempList.pollLast();
        tempList.addLast(temps + s.charAt(index));
        dfs(s, index + 1);
    }

    public boolean isValid(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
