//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 668 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // 原始的字符串数组的index -> 对应的字符串
        HashMap<Integer, String> originMap = new HashMap<>();

        // 排序后的字符串 -> 对应的list
        HashMap<String, List<String>> sortedListMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            originMap.put(i, strs[i]);
        }
        for (int i = 0; i < strs.length; i++) {
            String sortString = sortString(strs[i]);
            if (sortedListMap.containsKey(sortString)) {
                List<String> list = sortedListMap.get(sortString);
                list.add(originMap.get(i));
            } else {
                List<String> list = new ArrayList<>();
                list.add(originMap.get(i));
                sortedListMap.put(sortString, list);
            }
        }
        return sortedListMap.values().stream().collect(Collectors.toList());

    }

    public String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuilder builder = new StringBuilder();
        for (char aChar : chars) {
            builder.append(aChar);
        }
        return builder.toString();
    }


}
//leetcode submit region end(Prohibit modification and deletion)
