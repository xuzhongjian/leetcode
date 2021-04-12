//森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。 
//
// 返回森林中兔子的最少数量。 
//
// 
//示例:
//输入: answers = [1, 1, 2]
//输出: 5
//解释:
//两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
//之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
//设回答了 "2" 的兔子为蓝色。
//此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
//因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
//
//输入: answers = [10, 10, 10]
//输出: 11
//
//输入: answers = []
//输出: 0
// 
//
// 说明: 
//
// 
// answers 的长度最大为1000。 
// answers[i] 是在 [0, 999] 范围内的整数。 
// 
// Related Topics 哈希表 数学 
// 👍 47 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numRabbits(int[] answers) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int answer : answers) {
            map.put(answer, map.getOrDefault(answer, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 额外几只
            int other = entry.getKey();
            // 次数
            int times = entry.getValue();
            // 还有两只同颜色的兔子，但是出现了三次及以内
            // 所以认定叫额外两只的兔子是一个颜色的
            if (other + 1 >= times) {
                res = res + other + 1;
            } else {
                int part = other + 1;
                int partCount = times / part + (times % part == 0 ? 0 : 1);
                res = res + part * partCount;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
