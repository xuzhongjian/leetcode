
package com.zjxu97.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 中建
 *
 * @author thisxzj
 * @date 2019 2019-08-20 13:52
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */

public class P17 {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> nullList = new ArrayList<>();
        return innerLetterCombinations(nullList, digits);
    }

    private List<String> innerLetterCombinations(List<String> preAns, String restDigits) {
        ArrayList<String> ans = new ArrayList<>();
        char[] chars = restDigits.toCharArray();
        if (preAns.size() <= 0) {
            for (char aChar : chars) {
                String s = "" + aChar;
                ans.add(s);
            }
        } else {
            for (String pre : preAns) {
                ans.add(pre + chars[0]);
            }
        }
        return ans;
    }

    private char[] numToWord(int num) {
        return null;
    }
}


class P17Main {
    public static void main(String[] args) {
        P17Main p17Main = new P17Main();
    }
}