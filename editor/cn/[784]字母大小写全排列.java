//给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。 
//
// 
//
// 示例：
//输入：S = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
//
//输入：S = "3z4"
//输出：["3z4", "3Z4"]
//
//输入：S = "12345"
//输出：["12345"]
// 
//
// 
//
// 提示： 
//
// 
// S 的长度不超过12。 
// S 仅由数字和字母组成。 
// 
// Related Topics 位运算 回溯算法 
// 👍 257 👎 0


import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private LinkedList<Character> tempList = new LinkedList<>();
    private List<String> res = new ArrayList();

    public List<String> letterCasePermutation(String S) {
        dfs(S, 0);
        return res;
    }

    public void dfs(String S, int index) {
        if (index == S.length()) {
            StringBuilder sb = new StringBuilder();
            for (Character c : tempList) sb.append(c);
            res.add(sb.toString());
            return;
        }
        int val = S.charAt(index) - '0';

        tempList.addLast(S.charAt(index));
        dfs(S, index + 1);
        tempList.removeLast();

        // 不是数字才能进行大小写转换
        if (val < 0 || val > 9) {
            tempList.addLast(trans(S.charAt(index)));
            dfs(S, index + 1);
            tempList.removeLast();
        }
    }

    public char trans(char c) {
        // 小写
        if (0 <= c - 'a' && c - 'a' <= 26) {
            return (char) (c - 32);
        }
        // 大写
        if (0 <= c - 'A' && c - 'A' <= 26) {
            return (char) (c + 32);
        }
        return '?';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
